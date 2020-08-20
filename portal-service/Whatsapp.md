## Create Twilio account for whatsapp.
From Twilio console you will get account_sid, auth token and trial number. 

## Reference link for using Twilio api
https://www.twilio.com/docs/whatsapp/api

Send 'Join _____' from whatsapp to trial number to register your number in whatsapp sandbox.
To receive message from trial number and send message to trial number.


### Update application.properties with account_sid, auth token and trial number from Twilio console.

## Receive messages from whatsapp
For Receiving message from the whatsapp number. Need to register an end point with Twilio.
Twilio will call this api when message is send to trial number.
### Register the end point using this link.
https://www.twilio.com/console/sms/whatsapp/sandbox

## Exposed apis are- 
Receive all messages send from whatsapp to trial number - whatsapp/fetchMessage

Send message from trial number to whatsapp number - /whatsapp/send  Request body - {"phoneNumber":9839399933, "message":"Hi, Welcome to whatsapp sandbox"}

Api exposed with Twilio -  /sms
