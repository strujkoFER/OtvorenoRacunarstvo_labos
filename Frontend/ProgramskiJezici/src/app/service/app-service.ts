import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  tableStorage: any = [];
  url!: string;
  http: HttpClient;

  headers = [
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
  ];

  selectOptions = [
    "everything(wildcard)",
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
  ];

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

    return this.http.get<any>(this.url);
  }

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
