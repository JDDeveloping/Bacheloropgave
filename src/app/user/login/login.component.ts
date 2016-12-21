import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'fa-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Output() clicked = new EventEmitter<string>();
  _existing = false;

  login() {
    alert("idiot");
  }
}
