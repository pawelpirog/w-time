import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-master-table',
  templateUrl: './master-table.component.html',
  styleUrls: ['./master-table.component.css']
})
export class MasterTableComponent implements OnInit {

 // tydzienroboczy: TydzienRoboczy[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
   // this.getAllTydzienRoboczy();
  }




  // public getAllTydzienRoboczy() {
  //   const url = 'http://localhost:8080/api/tydzienroboczy/all';
  //   this.http.get<Worker[]>(url).subscribe(
  //
  //
  //     res => {
  //       this. = res;
  //     },
  //     err => {alert('something has fucked up');
  //     }
  //   );
  //
  // }
}
