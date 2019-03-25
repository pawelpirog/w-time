import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomthingComponent } from './randomthing.component';

describe('RandomthingComponent', () => {
  let component: RandomthingComponent;
  let fixture: ComponentFixture<RandomthingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RandomthingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomthingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
