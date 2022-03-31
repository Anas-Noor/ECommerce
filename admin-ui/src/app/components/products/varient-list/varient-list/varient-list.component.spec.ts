import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VarientListComponent } from './varient-list.component';

describe('VarientListComponent', () => {
  let component: VarientListComponent;
  let fixture: ComponentFixture<VarientListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VarientListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VarientListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
