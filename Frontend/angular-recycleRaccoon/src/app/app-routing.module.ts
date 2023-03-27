import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {SearchpgComponent} from "./searchpg/searchpg.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home-component',
    pathMatch: 'full'
  },
  {path:'home-component', component: HomeComponent},
  {path:'searchpg-component', component: SearchpgComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
