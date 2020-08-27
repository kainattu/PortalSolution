## Create Twilio account for whatsapp.

https://www.twilio.com/docs/sms/quickstart/java#sign-up-for-or-sign-in-to-twilio

a.create an account
 login password : Welcome till 5 ( mine, you must have your own)

##Project setup wtih WhatsApp.

1. Access the twilio console :https://www.twilio.com/console
2. Open the project tab in twilio poratal
  a. copy Account SID  use as twilio.account_sid value in properties file.
  b. copy the AUTH token use as twilio.auth_token value in properties file.
  c. copy the Train Number use as twilio.trial_number in properties file. (for Sandbox you need use Sandbox trail number.)

### Update application.properties with account_sid, auth token and trial number from Twilio console.

## Receive messages from whatsapp
For Receiving message from the whatsapp number. Need to register an end point with Twilio.
Twilio will call this api when message is send to trial number.
### Register the end point using this link.
https://www.twilio.com/console/sms/whatsapp/sandbox

copy the same Number use as twilio.trial_number in properties file.

start the application and send messages.
 
Sand box Participants
Invite your friends to your Sand box. Ask them to send a WhatsApp message to+1 415 523 8886 with code join carried-kill.
use the same number in 

then save the number as a contact and send 'Join _____' from whatsapp to trial number to register your number in whatsapp sand box.
To receive message from trial number and send message to trial number.

## Reference link for using Twilio api
https://www.twilio.com/docs/whatsapp/api

## Exposed apis are- 
Receive all messages send from whatsapp to trial number - whatsapp/fetchMessage

Send message from trial number to whatsapp number - /whatsapp/send  Request body - {"phoneNumber":9839399933, "message":"Hi, Welcome to whatsapp sandbox"}

Api exposed with Twilio -  /sms
