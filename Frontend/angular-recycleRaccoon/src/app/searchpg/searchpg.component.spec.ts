import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchpgComponent } from './searchpg.component';

describe('SearchpgComponent', () => {
  let component: SearchpgComponent;
  let fixture: ComponentFixture<SearchpgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchpgComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchpgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
