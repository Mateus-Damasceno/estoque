import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductDto } from '../interfaces/product.dto';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/products';

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<ProductDto[]> {
    return this.http.get<ProductDto[]>(this.baseUrl);
  }

  getProductById(id: number): Observable<ProductDto> {
    return this.http.get<ProductDto>(`${this.baseUrl}/${id}`);
  }

  createProduct(product: ProductDto): Observable<ProductDto> {
    return this.http.post<ProductDto>(this.baseUrl, product);
  }

  updateProduct(id: number, product: ProductDto): Observable<ProductDto> {
    return this.http.put<ProductDto>(`${this.baseUrl}/${id}`, product);
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
