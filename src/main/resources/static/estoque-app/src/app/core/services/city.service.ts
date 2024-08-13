import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CityDto } from '../interfaces/city.dto';

@Injectable({
  providedIn: 'root'
})
export class CityService {
  private baseUrl = 'http://localhost:8080/api/cities';

  constructor(private http: HttpClient) {}

  getAllCities(): Observable<CityDto[]> {
    return this.http.get<CityDto[]>(this.baseUrl);
  }

  getCityById(id: number): Observable<CityDto> {
    return this.http.get<CityDto>(`${this.baseUrl}/${id}`);
  }
}
