/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.bot.spring.echo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class EchoApplication {
	private static final Map<Integer, String> SEIREKI_TO_WAREKI_MAP = new HashMap<>();
	
	static {
		SEIREKI_TO_WAREKI_MAP.put(2017, "平成29");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        
        String message = event.getMessage().getText();
        String respMessage = message;
        
        if (isSeirekiText(message)) {
        	int seireki = parseSeirekiText(message);
        	
        	respMessage = SEIREKI_TO_WAREKI_MAP.getOrDefault(seireki, "SORRY!! Not Found.");
        }
        
        return new TextMessage(respMessage + "年です。。");
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
    
    private boolean isSeirekiText(String message) {
    	try {
    		Integer.parseInt(message);
    		return true;
    	} catch(NumberFormatException e) {
    		return false;
    	}
    }
    
    private int parseSeirekiText(String message) {
    	return Integer.parseInt(message);
    }
}
