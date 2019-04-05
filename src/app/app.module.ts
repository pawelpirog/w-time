import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppRoutingModule, routingComponents} from './app-routing.module';
import {AppComponent} from './app.component';
import {WorkerTableComponent} from './worker-table/worker-table.component';
import {FooterComponent} from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import {MasterTableComponent} from './master-table/master-table.component';
import {AddWorkerComponent} from './add-worker/add-worker.component';
import {ModifyWorkerComponent} from './modify-worker/modify-worker.component';

import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AllworkersComponent } from './allworkers/allworkers.component';
import {AppService} from './app.service';


@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}


@NgModule({
  declarations: [
    routingComponents,
    FooterComponent,
    HeaderComponent,
    MasterTableComponent,
    AddWorkerComponent,
    ModifyWorkerComponent,
    AllworkersComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [AppService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent,
    // LogowanieComponent,
    // WorkerTableComponent,
    // MasterTableComponent,
    // AddWorkerComponent
  ]
})
export class AppModule {
}



