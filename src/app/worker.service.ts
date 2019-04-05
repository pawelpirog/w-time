
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getWorkers() {
    const url = 'http://localhost:8081/workers/all';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('user:secret123') });
    return this.http.get(url);
  }
}
