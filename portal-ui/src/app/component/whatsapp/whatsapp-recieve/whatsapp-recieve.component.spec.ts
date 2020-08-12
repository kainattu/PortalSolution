import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhatsappRecieveComponent } from './whatsapp-recieve.component';

describe('WhatsappRecieveComponent', () => {
  let component: WhatsappRecieveComponent;
  let fixture: ComponentFixture<WhatsappRecieveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhatsappRecieveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhatsappRecieveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
