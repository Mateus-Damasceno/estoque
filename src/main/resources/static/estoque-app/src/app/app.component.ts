import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true, // Isso indica que o componente é standalone
  imports: [RouterModule] // Importe o RouterModule aqui
})
export class AppComponent {
  title = 'Meu App Angular';
}
