import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-forside',
  templateUrl: './forside.component.html',
  styleUrls: ['./forside.component.css']
})
export class ForsideComponent {
  @Output() action=new EventEmitter<string>();
}
