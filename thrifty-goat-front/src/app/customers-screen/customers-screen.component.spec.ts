import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersScreenComponent } from './customers-screen.component';

describe('CustomersScreenComponent', () => {
  let component: CustomersScreenComponent;
  let fixture: ComponentFixture<CustomersScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersScreenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
