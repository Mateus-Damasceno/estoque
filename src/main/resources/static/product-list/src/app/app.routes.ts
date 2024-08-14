import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list.component';
import {ProductFormComponent} from './components/product-form.component';
import {ProductEditComponent} from './components/product-edit.component';
export const routes: Routes = [
  { path: '', component: ProductListComponent },
 { path: 'product/new', component: ProductFormComponent },
  { path: 'edit/:id', component: ProductEditComponent },
];
