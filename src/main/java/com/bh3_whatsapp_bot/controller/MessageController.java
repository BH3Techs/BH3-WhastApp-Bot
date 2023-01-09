package com.bh3_whatsapp_bot.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * 9/1/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * Bh3 WhatsApp bot
 **/

@RestController
@RequestMapping("/webhook/")
public class MessageController {
    @PostMapping
    public String AnswerWebhook(@RequestBody RequestWebHook hook) throws IOException {

        for (var message : hook.getMessages()) {
            if (message.getFromMe())
                continue;

            String option = message.getBody().split(" ")[0].toLowerCase();
            System.out.println("Honawo"+option);
            switch (option)
            {
                case "chatid":
                    ApiWA.sendChatId(message.getChatId());
                    break;
                case "file":
                    var texts = message.getBody().split(" ");
                    if (texts.length > 1)
                        ApiWA.sendFile(message.getChatId(), texts[1]);
                    break;
                case "ogg":
                    ApiWA.sendOgg(message.getChatId());
                    break;
                case "geo":
                    ApiWA.sendGeo(message.getChatId());
                    break;
                case "group":
                    ApiWA.createGroup(message.getAuthor());
                    break;
                default:
                    ApiWA.sendDefault(message.getChatId());
                    break;
            }

        }
        return  "ok";
    }
}
