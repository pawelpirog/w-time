import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ApiService} from '../shared/api.service';

@Component({
  selector: 'app-add-worker',
  templateUrl: './add-worker.component.html',
  styleUrls: ['./add-worker.component.css']
})
export class AddWorkerComponent implements OnInit {
  workers: Worker[] = [];
  model: Worker;

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.getAllWorkers();

  }

  public getAllWorkers() {
    this.apiService.getAllWorkers().subscribe(// cala  logika jest w getAllWorkers


      res => {
        this.workers = res;
      },
      err => {
        alert('something has fucked up');
      }
    );

  }


  public addWorker() {

    this.apiService.addWorker(this.model).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert('something has fucked up');
      }
    );
  }


// //ALTERNATYWA DLA ADDWORKER
//
//   /* createUser(): void {
//      this.userService.createUser(this.user)
//        .subscribe( data => {
//          alert("User created successfully.");
//        });
//
//    };*/


}
