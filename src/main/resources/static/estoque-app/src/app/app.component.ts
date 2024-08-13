import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true // Adicione esta linha para tornar o componente standalone
})
export class AppComponent {
  title = 'Meu App Angular';
}
