import { Component, OnInit } from '@angular/core';
import { WhatsappService, WhatsappResponseData } from 'src/app/service/whatsapp.service';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-whatsapp',
  templateUrl: './whatsapp.component.html',
  styleUrls: ['./whatsapp.component.css']
})
export class WhatsappComponent implements OnInit {
  error = null;
  success = null;
  constructor(private whatsappService: WhatsappService) { }

  ngOnInit() {
  }

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
