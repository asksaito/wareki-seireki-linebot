package com.example.bot.spring.echo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.bot.spring.echo.repository.WarekiSeirekiRepository;

@Service
public class WarekiSeirekiConvertService {
	private List<String> currentYearText = Arrays.asList(new String[]{"いま", "今", "now"});
	
	@Autowired
	private WarekiSeirekiRepository warekiSeirekiRepository;
	
	public String execute(String inputText) {
		System.out.println("[DEBUG] inputText = " + inputText);
		if (currentYearText.contains(inputText.toLowerCase())) {
			// 現在の年を取得
			inputText = String.valueOf(LocalDateTime.now().getYear());
		}
		
		String outputText = "";
		if (isWarekiText(inputText)) { // 和暦入力か？
			Wareki wareki = parseWarekiText(inputText);
			System.out.println("[DEBUG] isWarekiText warekiGengo = " + wareki.getGengo()
					+ " / warekiYear = " + wareki.getYear());
			
			// 西暦に変換
			outputText = warekiSeirekiRepository.findSeirekiText(wareki.getGengo(), wareki.getYear());
		}
		else if (isSeirekiText(inputText)) { // 西暦入力か？
        	int seirekiYear = parseSeirekiText(inputText);
        	System.out.println("[DEBUG] isSeirekiText seirekiYear = " + seirekiYear);
        	
        	// 和暦に変換
        	outputText = warekiSeirekiRepository.findWarekiText(seirekiYear);
        }
		
		System.out.println("[DEBUG] outputText = " + outputText);
		return outputText;
	}
	
	private boolean isWarekiText(String inputText) {
		return parseWarekiText(inputText) != null;
	}
	
	private boolean isSeirekiText(String inputText) {
		if (!StringUtils.isEmpty(inputText)) {	
	    	try {
	    		int seireki = parseSeirekiText(inputText);
	    		if (1900 <= seireki && seireki <= 2099) {
	    			return true;
	    		}
	    	} catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
		}
    	return false;
    }
    
	// 平成29年
	// 昭和31
	// 大正12年ごろ
	// 明治42年
	private Wareki parseWarekiText(String message) {
		Wareki result = null;
		
		if (!StringUtils.isEmpty(message)) {
			String regex = "^(明治|大正|昭和|平成)(\\d+).*";
			Pattern p = Pattern.compile(regex);
			
			System.out.println("[DEBUG] regexText = " + regex);
			Matcher m = p.matcher(message);
			if (m.matches()) {
				String matchstr = m.group();
				System.out.println("[DEBUG] マッチ文字列 : " + matchstr);
				System.out.println("[DEBUG] 元号 : " + m.group(1));
				System.out.println("[DEBUG] 年  : " + m.group(2));
  
				result = new Wareki(m.group(1), Integer.parseInt(m.group(2)));
			}
		}
		
		return result;
    }
	
	// 2017年
	// 2018
    private int parseSeirekiText(String message) {
    	return Integer.parseInt(message.trim().replaceAll("[^0-9]", ""));
    }
    
    public static class Wareki {
    	private final String gengo;
    	
    	private final int year;
    	
    	public Wareki(String gengo, int year) {
    		this.gengo = gengo;
    		this.year = year;
    	}

		public String getGengo() {
			return gengo;
		}

		public int getYear() {
			return year;
		}

    }
}
