import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
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

  field!: string;
  param!: string;

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
        console.error('Error fetching data: ', err);
      }
    });
  }
}
