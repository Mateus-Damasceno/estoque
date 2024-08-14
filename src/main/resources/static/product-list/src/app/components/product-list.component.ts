import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // Importe o RouterModule
import { ProductService } from '../services/product.service';
import { ProductDto } from '../models/product.dto';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  standalone: true,
  imports: [CommonModule, RouterModule], // Adicione RouterModule aqui
})
export class ProductListComponent implements OnInit {
  products: ProductDto[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(products => {
      this.products = products;
    });
  }

  deleteProduct(id: number): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe(() => {
        this.products = this.products.filter(p => p.id !== id);
        this.loadProducts();
      });
    }
  }
}
