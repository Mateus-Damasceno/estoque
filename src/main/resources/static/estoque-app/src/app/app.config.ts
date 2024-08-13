import { NgModule } from '@angular/core'; // Ensure this import is correct
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component'; // Ensure this import is correct
import { ProductListComponent } from './features/product/product-list/product-list.component';
import { ProductDetailComponent } from './features/product/product-detail/product-detail.component';
import { CityListComponent } from './features/city/city-list/city-list.component';

@NgModule({
  declarations: [
        ProductListComponent,
        ProductDetailComponent,
        CityListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule, // Certifique-se de que o AppRoutingModule está aqui
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppConfig { }

export const appConfig = {
  providers: [],

};
