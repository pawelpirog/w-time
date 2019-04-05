/*import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private AUTH_USER = 'http://localhost:4200/backend/api/workers/login';
  private CREATE_USER_URL = 'http://localhost:4200/backend/api/workers/create';

  constructor(private http: HttpClient) {
  }

  getUserDetails(username, password) {

    return this.http.post(this.AUTH_USER, {
      username,
      password


    }).subscribe(data => {
      console.log(data, ' is what we got from the  server');
    });
  }


  public createWorker(user) {
    return this.http.post<Worker>(this.CREATE_USER_URL, user);
  }


}
*/

import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

export class User {
  constructor(
    public status: string,
  ) {
  }

}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(
    private httpClient: HttpClient
  ) {
  }

  authenticate(username, password) {
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.httpClient.get<User>('http://localhost:8081/employees/validateLogin', {headers}).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          return userData;
        }
      )
    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}
