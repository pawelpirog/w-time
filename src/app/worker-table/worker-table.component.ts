import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppService} from '../app.service';

@Component({
  selector: 'app-worker-table',
  templateUrl: './worker-table.component.html',
  styleUrls: ['./worker-table.component.css']
})
export class WorkerTableComponent {

  greeting = {};

  constructor(private app: AppService, private http: HttpClient) {
    http.get('http://localhost:8081/resources').subscribe(data => this.greeting = data);


  }

  authenticated() {
    return this.app.authenticated;
  }

}
