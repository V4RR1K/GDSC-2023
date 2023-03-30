import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {SearchpgComponent} from "./searchpg/searchpg.component";
import {SignUpComponent} from "./sign-up/sign-up.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home-component',
    pathMatch: 'full'
  },
  {path:'home-component', component: HomeComponent},
  {path:'searchpg-component', component: SearchpgComponent},
  {path:'signup-component', component: SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
