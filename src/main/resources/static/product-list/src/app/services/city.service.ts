import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CityDto } from '../models/city.dto';

@Injectable({
  providedIn: 'root',
})
export class CityService {
  private apiUrl = 'http://localhost:8080/cities';

  constructor(private http: HttpClient) {}

  getCities(): Observable<CityDto[]> {
    return this.http.get<CityDto[]>(this.apiUrl);
  }
}
