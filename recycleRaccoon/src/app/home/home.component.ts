import { Component } from '@angular/core';


@Component({ //@Component is a decorator function that specifies the Angular metadata for the component
  selector: 'app-home', // the componenets CSS element selector - this matches the name of the HTML elements that identies this component within a parent component's template 
  templateUrl: './home.component.html', // the location of the component's template file 
  styleUrls: ['./home.component.css'] // the location of the component's private CSS styles 
})
export class HomeComponent {
   FirstLocation = 'RIT';
}
