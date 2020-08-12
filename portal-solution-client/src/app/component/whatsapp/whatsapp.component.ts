import { Component, OnInit } from '@angular/core';
import { WhatsappService, WhatsappResponseData, WhatsappRecieveResponseData } from 'src/app/service/whatsapp.service';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-whatsapp',
  templateUrl: './whatsapp.component.html',
  styleUrls: ['./whatsapp.component.css']
})
export class WhatsappComponent implements OnInit {
  constructor(private whatsappService: WhatsappService) { }

  ngOnInit() {
  }
  error = null;
  success = null;

  recieveMessage() {
    let obs: Observable<WhatsappRecieveResponseData[]>;
    this.error = null;
    this.success = null
    
    obs = this.whatsappService.recieveMessage();
  
    obs.subscribe(
      resData => {
      },
      errorMessage => {
        this.error = errorMessage;
      }
    );
  }
}
