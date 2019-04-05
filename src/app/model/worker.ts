import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';


export class Worker {
  id: number;
  imie: string;
  nazwisko: string;
  nick: string;
  haslo: string;
  adres: string;
  mail: string;
}


@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getEmployees() {
    let username = 'javainuse';
    let password = 'password';

    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.httpClient.get<Worker[]>('http://localhost:8081/workers/all', {headers});
  }


  public deleteEmployee(employee) {
    let username = 'javainuse';
    let password = 'password';

    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.httpClient.delete<Worker>('http://localhost:8080/employees' + '/' + employee.empId, {headers});
  }

  public createEmployee(employee) {
    let username = 'javainuse';
    let password = 'password';

    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.httpClient.post<Worker>('http://localhost:8080/employees', employee, {headers});
  }

}
