import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import Ajv from "ajv";
import {jsonShema} from "../shema/ProgrammingLanguagesShema";

@Injectable({
  providedIn: 'root'
})
export class AppService {
  tableStorage: any = [];
  url!: string;
  http: HttpClient;

  headers = [
    "Name",
    "Year created",
    "Creator",
    "Popular frameworks",
    "Primary uses",
    "Description",
    "Website",
    "Type checking",
    "Strength",
    "Programming style",
  ];

  selectOptions = [
      {name: "Everything (wildcard)", value: "everything(wildcard)"},
      {name: "Name", value: "name"},
      {name: "Year created", value: "year_created"},
      {name: "Creator", value: "creator"},
      {name: "Popular frameworks", value: "popular_frameworks"},
      {name: "Primary uses", value: "primary_uses"},
      {name: "Description", value: "description"},
      {name: "Website", value: "website"},
      {name: "Type checking", value: "type_checking"},
      {name: "Strength", value: "strength"},
      {name: "Programming style", value: "programming_style"},
  ];

  private ajv = new Ajv();
  private validate = this.ajv.compile(jsonShema);

  constructor(http: HttpClient) {
    this.http = http;
  }

  fetchData(field: string, param: any) {

    switch(field) {
      case 'everything(wildcard)':
        this.url = `http://localhost:8080/programmingLanguages/getByWildcard?wildcard=${param}`;
        break;
      case 'name':
        this.url = `http://localhost:8080/programmingLanguages/getByName?name=${param}`;
        break;
      case 'year_created':
        this.url = `http://localhost:8080/programmingLanguages/getByYearCreated?yearCreated=${param}`;
        break;
      case 'creator':
        this.url = `http://localhost:8080/programmingLanguages/getByCreator?creator=${param}`;
        break;
      case 'popular_frameworks':
        this.url = `http://localhost:8080/programmingLanguages/getByPopularFrameworks?framework=${param}`;
        break;
      case 'primary_uses':
        this.url = `http://localhost:8080/programmingLanguages/getByPrimaryUses?primaryUse=${param}`;
        break;
      case 'description':
        this.url = `http://localhost:8080/programmingLanguages/getByDescription?description=${param}`;
        break;
      case 'website':
        this.url = `http://localhost:8080/programmingLanguages/getByPopularWebsite?website=${param}`;
        break;
      case 'type_checking':
        this.url = `http://localhost:8080/programmingLanguages/getByTypeChecking?typeChecking=${param}`;
        break;
      case 'strength':
        this.url = `http://localhost:8080/programmingLanguages/getByStrength?strength=${param}`;
        break;
      case 'programming_style':
        this.url = `http://localhost:8080/programmingLanguages/getByPopularStyle?style=${param}`;
        break;
      default:
        this.url = 'http://localhost:8080/programmingLanguages/getAll';
        break;
    }

    return this.http.get<any>(this.url).pipe(
        tap(data => {
            const valid = this.validate(data);
            if (!valid) {
                console.error("JSON validation failed", this.validate.errors);
                throw new Error("JSON validation failed");
            }
        })
    );
  };

  saveInTableStorage(
    name: string,
    yearCreated: number,
    creator: string,
    popularFrameworks: string,
    primaryUses: string,
    description: string,
    website: string,
    typingDisciplineTypeChecking: string,
    typingDisciplineStrength: string ,
    programmingStyle: string
  ) {
    this.tableStorage.push({
      name: name,
      yearCreated: yearCreated,
      creator: creator,
      popularFrameworks: popularFrameworks,
      primaryUses: primaryUses,
      description: description,
      website: website,
      typingDisciplineTypeChecking: typingDisciplineTypeChecking,
      typingDisciplineStrength: typingDisciplineStrength ,
      programmingStyle: programmingStyle
    })
  }

}
