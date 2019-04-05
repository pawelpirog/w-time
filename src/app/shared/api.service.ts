import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = 'http://localhost:8081/api/';
  private  ALL_WORKERS_URL = '${this.BASE_URL}\\workers\\all';
  private ALL_TYDZIEN_ROBOCZY_URL = 'http://localhost:8081/api/tydzienroboczy/all';
  private ADD_WORKER_URL = 'http://localhost:8081/api/workers/add';
  ///
  // http://localhost:8080/api/Workers/all
  constructor(private http: HttpClient) {
  }


  getAllWorkers(): Observable<Worker[]> {
   return  this.http.get<Worker[]>(this.ALL_WORKERS_URL);
  }

  // getAllTygodnies(): Observable<TydzienRoboczy[]> {
  //   return this.http.get<TydzienRoboczy[]>(this.ALL_TYDZIEN_ROBOCZY_URL);
  // }


  addWorker(worker: Worker): Observable<any> {
    return this.http.post(this.ADD_WORKER_URL, worker);
  }




}

