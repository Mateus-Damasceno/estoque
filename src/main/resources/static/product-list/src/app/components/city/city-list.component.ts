import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CityService } from '../../services/city.service';
import { CityDto } from '../../models/city.dto';

@Component({
 selector: 'app-city-list',
   templateUrl: './city-list.component.html',
   styleUrls: ['./city-list.component.css'],
   standalone: true,
   imports: [CommonModule],
})
export class CityListComponent implements OnInit {
  cities: CityDto[] = [];

  constructor(private cityService: CityService) {}

  ngOnInit(): void {
    this.loadCities();
  }

  loadCities(): void {
    this.cityService.getCities().subscribe(cities => {
      this.cities = cities;
    });
  }
}
