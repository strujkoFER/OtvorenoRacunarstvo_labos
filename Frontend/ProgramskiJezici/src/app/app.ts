import { Component } from '@angular/core';
import { AppService } from './service/app-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
    imports: [
        FormsModule
    ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  name!: string;
  yearCreated!: number;
  creator!: string;
  popularFrameworks!: string[];
  primaryUses!: string[];
  description!: string;
  website!: string;
  typingDisciplineTypeChecking!: string;
  typingDisciplineStrength!: string;
  programmingStyle!: string;

  appService: any;

  field = '';
  param = '';

  constructor(appService: AppService) {
    this.appService = appService;
  }

  applyFilter() {
    this.fetchData(this.field, this.param);
  }

  clearFilter() {
    this.field = '';
    this.param = '';
  }

  fetchData(field: string, param: string) {
    this.appService.tableStorage.length = 0;
    this.appService.fetchData(field, param).subscribe({
      next: (data: any[]) => {
        for (let i = 0; i < data.length; ++i) {
          this.name = data[i].name;
          this.yearCreated = data[i].year_created;
          this.creator = data[i].creator;
          this.popularFrameworks = data[i].popular_frameworks;
          this.primaryUses = data[i].primary_uses;
          this.description = data[i].description;
          this.website = data[i].website;
          this.typingDisciplineTypeChecking = data[i].typing_discipline.type_checking;
          this.typingDisciplineStrength = data[i].typing_discipline.strength;
          this.programmingStyle = data[i].programming_style;

          this.appService.saveInTableStorage(
            this.name,
            this.yearCreated,
            this.creator,
            this.popularFrameworks,
            this.primaryUses,
            this.description,
            this.website,
            this.typingDisciplineTypeChecking,
            this.typingDisciplineStrength ,
            this.programmingStyle
          )
        }
      },
      error: (err: any) => {
        console.error('Error: ', err);
      }
    });
  }

    isDown = false;
    startX = 0;
    startY = 0;
    scrollLeft = 0;
    scrollTop = 0;

    startDrag(event: MouseEvent) {
        this.isDown = true;
        let div = event.currentTarget as HTMLElement;
        this.startX = event.pageX - div.offsetLeft;
        this.startY = event.pageY - div.offsetTop;
        this.scrollLeft = div.scrollLeft;
        this.scrollTop = div.scrollTop;
    }

    onDrag(event: MouseEvent) {
        if (!this.isDown) return;
        event.preventDefault();
        let div = event.currentTarget as HTMLElement;
        let x = event.pageX - div.offsetLeft;
        let y = event.pageY - div.offsetTop;
        div.scrollLeft = this.scrollLeft - (x - this.startX);
        div.scrollTop = this.scrollTop - (y - this.startY);
    }

    stopDrag() {
        this.isDown = false;
    }

    exportJSON() {
        let data = [];
        for(let element of this.appService.tableStorage) {
            data.push({
                "name": element.name,
                "creator": element.creator,
                "website": element.website,
                "description": element.description,
                "primary_uses": element.primaryUses,
                "year_created": element.yearCreated,
                "programming_style": element.programmingStyle,
                "typing_discipline": {
                "strength": element.typingDisciplineStrength,
                "type_checking": element.typingDisciplineTypeChecking
            },
                "popular_frameworks": element.popularFrameworks
            })
        }

        let jsonString = JSON.stringify(data, null, 2);
        let blob = new Blob([jsonString], { type: "application/json" });
        let link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        let filename = "programming_languages" + (this.field == "" ? "" : "_filter_" + this.field);
        link.download = `${filename}.json`;
        link.click();
        URL.revokeObjectURL(link.href);
    }

    exportCSV(){
        let data = [];

        let headers = [
            "name",
            "year_created",
            "creator",
            "popular_frameworks",
            "primary_uses",
            "description",
            "website",
            "type_checking",
            "strength",
            "programming_style",
        ]

        data.push(headers.join(','));

        for (let element of this.appService.tableStorage) {
            for (let style of element.programmingStyle) {
                data.push([
                    element.name,
                    element.yearCreated,
                    element.creator.includes(",") ? `"${element.creator}"`: element.creator,
                    `"${element.popularFrameworks.join(",")}"`,
                    `"${element.primaryUses.join(",")}"`,
                    `"${element.description}"`,
                    element.website,
                    element.typingDisciplineTypeChecking,
                    element.typingDisciplineStrength,
                    style,
                ].join(','))
            }
        }

        let blob = new Blob([data.join('\n')], { type: 'text/csv' });
        let link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        let filename = "programming_languages" + (this.field == "" ? "" : "_filter_" + this.field);
        link.download = `${filename}.csv`;
        link.click();
        URL.revokeObjectURL(link.href);
    }

}
