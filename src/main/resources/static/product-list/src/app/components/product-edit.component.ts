import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../services/product.service';
import { ProductDto } from '../models/product.dto';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule], // Import FormsModule for ngModel
})
export class ProductEditComponent implements OnInit {
  product: ProductDto = {
    name: '',
    value: 0,
    stock: 0,
    city: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.loadProduct();
  }

  loadProduct(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.productService.getProductById(Number(id)).subscribe(product => {
        this.product = product;
      });
    }
  }

  updateProduct(): void {
    if (this.product.id) {
      this.productService.updateProduct(this.product.id, this.product).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancel(): void { // Public method for navigation
    this.router.navigate(['/']);
  }
}
