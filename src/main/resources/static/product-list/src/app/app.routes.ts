import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import {ProductFormComponent} from './components/product-form/product-form.component';
import {ProductEditComponent} from './components/product-edit/product-edit.component';
import { CityListComponent } from './components/city/city-list.component';

export const routes: Routes = [
  { path: '', component: ProductListComponent },
  { path: 'product/new', component: ProductFormComponent },
  { path: 'edit/:id', component: ProductEditComponent },
  { path: 'cities', component: CityListComponent },
];
