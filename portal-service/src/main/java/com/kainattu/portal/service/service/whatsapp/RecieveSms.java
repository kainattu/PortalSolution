package com.kainattu.portal.service.service.whatsapp;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.twiml.messaging.Message;

public class RecieveSms {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello Web");

        post("/sms", (req, res) -> {
        	 Map<String, String> parameters = parseBody(req.body());
        	    String message = "The Robots are coming! Head for the hills!";
        	    if (parameters.get("Body").equals("hello")) {
        	      // Say hi
        	      message = "Hi there!";
        	    } else if (parameters.get("Body").equals("bye")) {
        	      // Say goodbye
        	      message = "Goodbye!";
        	    }

            res.type("application/xml");
            Body body = new Body
                    .Builder(message)
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .media(new Media.Builder("https://farm8.staticflickr.com/7090/6941316406_80b4d6d50e_z_d.jpg").build())
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            return twiml.toXml();
        });
    }
    
    public static Map<String, String> parseBody(String body) throws UnsupportedEncodingException {
        String[] unparsedParams = body.split("&");
        Map<String, String> parsedParams = new HashMap<String, String>();
        for (int i = 0; i < unparsedParams.length; i++) {
          String[] param = unparsedParams[i].split("=");
          if (param.length == 2) {
            parsedParams.put(urlDecode(param[0]), urlDecode(param[1]));
          } else if (param.length == 1) {
            parsedParams.put(urlDecode(param[0]), "");
          }
        }
        return parsedParams;
      }

      public static String urlDecode(String s) throws UnsupportedEncodingException {
        return URLDecoder.decode(s, "utf-8");
      }
}
