import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { ProductDto } from '../../models/product.dto';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-form.component.html',
  styleUrl: './product-form.component.css'
})

export class ProductFormComponent {
  product: ProductDto = {
    name: '',
    value: 0,
    stock: 0,
    city: ''
  };

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  createProduct(): void {
    this.productService.createProduct(this.product).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
