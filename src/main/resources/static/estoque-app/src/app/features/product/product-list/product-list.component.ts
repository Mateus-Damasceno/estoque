import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'; // Certifique-se de importar ActivatedRoute
import { ProductService } from 'src/app/core/services/product.service';
import { ProductDto } from 'src/app/core/interfaces/product.dto';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: ProductDto[] = [];

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute // Certifique-se de injetar ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  deleteProduct(id: number): void {
    this.productService.deleteProduct(id).subscribe(() => {
      this.loadProducts();
    });
  }
}
