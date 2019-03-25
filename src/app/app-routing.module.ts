import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WorkerTableComponent} from './worker-table/worker-table.component';
import {AppComponent} from './app.component';
import {LogowanieComponent} from './logowanie/logowanie.component';
import {MasterTableComponent} from './master-table/master-table.component';
import {AddWorkerComponent} from './add-worker/add-worker.component';
import {ModifyWorkerComponent} from './modify-worker/modify-worker.component';
import {FormsModule} from "@angular/forms";

const routes: Routes = [
  {path: 'worker', component: WorkerTableComponent},
  {path: 'main', component: AppComponent},
  {path: 'logowanie', component: LogowanieComponent},
  {path: 'master', component: MasterTableComponent},
  {path: 'addworker', component: AddWorkerComponent},

  {path: 'modifyworker', component: ModifyWorkerComponent}


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    FormsModule

  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routingComponents = [WorkerTableComponent, AppComponent, LogowanieComponent,
  MasterTableComponent, AddWorkerComponent, ModifyWorkerComponent];


