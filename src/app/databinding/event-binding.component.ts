import { Component } from '@angular/core';

@Component({
  selector: 'fa-event-binding',
  template: `
    <button (click)="onClicked()">Click me!</button>
  `,
  styles: []
})
export class EventBindingComponent {

    onClicked(){
      alert('it worked!');
    }
}
