import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FloatingCartComponent } from './floating-cart.component';

describe('FloatingCartComponent', () => {
  let component: FloatingCartComponent;
  let fixture: ComponentFixture<FloatingCartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FloatingCartComponent]
    });
    fixture = TestBed.createComponent(FloatingCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
