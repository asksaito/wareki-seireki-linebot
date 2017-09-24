package com.example.bot.spring.echo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WarekiSeirekiConvertService {
	private static final Map<Integer, String> SEIREKI_TO_WAREKI_MAP = new HashMap<>();
	
	static {
		SEIREKI_TO_WAREKI_MAP.put(2017, "平成29");
	}
	
	public String execute(String inputText) {
		String outText = "";
		
		if (isWarekiText(inputText)) { // 和暦入力か？
			
		}
		else if (isSeirekiText(inputText)) { // 西暦入力か？
        	int seireki = parseSeirekiText(inputText);
        	
        	outText = SEIREKI_TO_WAREKI_MAP.getOrDefault(seireki, "SORRY. Not Found.");
        }
		
		return outText;
	}
	
	private boolean isWarekiText(String inputText) {
		return false;
	}
	
	private boolean isSeirekiText(String inputText) {
		if (StringUtils.isEmpty(inputText)) {
			return false;
		}
		
		String inputValue = inputText.trim().replaceAll("[^0-9]", "");
    	try {
    		int seireki = Integer.parseInt(inputValue);
    		if (1900 <= seireki && seireki <= 2099) {
    			return true;
    		}
    	} catch(NumberFormatException e) {
    		// Nothing to do...
    	}
    	return false;
    }
    
    private int parseSeirekiText(String message) {
    	return Integer.parseInt(message);
    }
}
