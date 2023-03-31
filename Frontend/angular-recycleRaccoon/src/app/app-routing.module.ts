import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {SearchpgComponent} from "./searchpg/searchpg.component";
import {SignUpComponent} from "./sign-up/sign-up.component";
import {AboutUsComponent} from './about-us/about-us.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home-component',
    pathMatch: 'full'
  },
  {path:'home-component', component: HomeComponent},
  {path:'searchpg-component', component: SearchpgComponent},
  {path:'signup-component', component: SignUpComponent},
  {path:'about-us-component', component: AboutUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
