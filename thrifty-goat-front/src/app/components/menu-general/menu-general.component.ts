import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-menu-general',
  templateUrl: './menu-general.component.html',
  styleUrls: ['./menu-general.component.css'],
  standalone: true,
  imports: [RouterLink],
})
export class MenuGeneralComponent {}
