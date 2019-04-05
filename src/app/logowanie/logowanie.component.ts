// import {Component, OnInit} from '@angular/core';
// import {AuthService} from '../auth.service';
// import {HttpClient} from '@angular/common/http';
// import {Router} from '@angular/router';
// import {AppService} from '../app.service';
//
// @Component({
//   selector: 'app-logowanie',
//   templateUrl: './logowanie.component.html',
//   styleUrls: ['./logowanie.component.css']
// })
// export class LogowanieComponent implements OnInit {
//
//   credentials = {username: '', password: ''};
//   worker: Worker;
//
//
//   constructor(private app: AppService, private http: HttpClient, private router: Router) {
//   }
//
//
//   login() {
//     this.app.authenticate(this.credentials, () => {
//       this.router.navigateByUrl('/');
//     });
//     return false;
//   }
//
//
//   ngOnInit() {
//   }
//
//   // loginUser(event) {
//   //   console.log(event);
//   //   event.preventDefault();
//   //
//   //   const target = event.target;
//   //   const username = target.querySelector('#nick').value;
//   //   const password = target.querySelector('#haslo').value;
//   //
//   //
//   //   this.Auth.getUserDetails(username, password);
//   //   console.log(username, password);
//   //
//   // }
//
// }


import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../auth.service';

@Component({
  selector: 'app-logowanie',
  templateUrl: './logowanie.component.html',
  styleUrls: ['./logowanie.component.css']
})
export class LogowanieComponent implements OnInit {

  username = '';
  password = '';
  invalidLogin = false;

  constructor(private router: Router,
              private loginservice: AuthenticationService) {
  }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
        data => {
          this.router.navigate(['localhost:8081/workers/login']);
          this.invalidLogin = false;
        },
        error => {
          this.invalidLogin = true;

        }
      )
    );

  }


}
