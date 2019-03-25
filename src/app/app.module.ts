import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule, routingComponents} from './app-routing.module';
import {AppComponent} from './app.component';
import {WorkerTableComponent} from './worker-table/worker-table.component';
import {FooterComponent} from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import {LogowanieComponent} from './logowanie/logowanie.component';
import {MasterTableComponent} from './master-table/master-table.component';
import {AddWorkerComponent} from './add-worker/add-worker.component';
import {ModifyWorkerComponent} from './modify-worker/modify-worker.component';
import {RandomthingComponent} from './randomthing/randomthing.component';

@NgModule({
  declarations: [
    routingComponents,
    FooterComponent,
    HeaderComponent,
    MasterTableComponent,
    AddWorkerComponent,
    ModifyWorkerComponent,
    RandomthingComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent,
    LogowanieComponent,
    WorkerTableComponent,
    MasterTableComponent,
    AddWorkerComponent]
})
export class AppModule { }
