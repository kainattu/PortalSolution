import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { WhatsappResponseData, WhatsappService } from 'src/app/service/whatsapp.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-whatsapp-send',
  templateUrl: './whatsapp-send.component.html',
  styleUrls: ['./whatsapp-send.component.css']
})
export class WhatsappSendComponent implements OnInit {

  constructor(private whatsappService: WhatsappService) { }

  ngOnInit() {
  }

  error = null;
  success = null;
  
  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    const phoneNumber = form.value.phoneNumber;
    const message = form.value.message;

    let obs: Observable<WhatsappResponseData>;
    this.error = null;
    this.success = null
    
    obs = this.whatsappService.sendMessage(phoneNumber, message);
  
    obs.subscribe(
      resData => {
        console.log(resData);
        this.success = resData;
      },
      errorMessage => {
        console.log(errorMessage);
        this.error = errorMessage;
      }
    );

    form.reset();
  }
}
