import { Component, OnInit } from '@angular/core';
import { WhatsappService, WhatsappRecieveResponseData } from 'src/app/service/whatsapp.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-whatsapp-recieve',
  templateUrl: './whatsapp-recieve.component.html',
  styleUrls: ['./whatsapp-recieve.component.css']
})
export class WhatsappRecieveComponent implements OnInit {
  subscription: Subscription;

  constructor(private whatsappService: WhatsappService) { }
  messages: WhatsappRecieveResponseData[];

  ngOnInit() {
    this.messages= null;
    this.subscription = this.whatsappService.allWhatsappRecieveChanged
      .subscribe(
        (messages: WhatsappRecieveResponseData[]) => {
          this.messages = messages;
        }
      );

    this.messages = this.whatsappService.fetchMessages();
  }

}
