import { Component, OnInit } from '@angular/core';
import { CityService } from 'src/app/core/services/city.service';
import { CityDto } from 'src/app/core/interfaces/city.dto';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {
  cities: CityDto[] = [];

  constructor(private cityService: CityService) {}

  ngOnInit(): void {
    this.loadCities();
  }

  loadCities(): void {
    this.cityService.getAllCities().subscribe(data => {
      this.cities = data;
    });
  }
}
