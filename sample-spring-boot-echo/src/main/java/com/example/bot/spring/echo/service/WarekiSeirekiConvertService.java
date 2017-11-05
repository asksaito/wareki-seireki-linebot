package com.example.bot.spring.echo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WarekiSeirekiConvertService {
	private static final Map<String, String> WAREKI_TO_SEIREKI_MAP = new HashMap<>();
	private static final Map<Integer, String> SEIREKI_TO_WAREKI_MAP = new HashMap<>();
	
	static {
		WAREKI_TO_SEIREKI_MAP.put("明治33", "1900");
		WAREKI_TO_SEIREKI_MAP.put("明治34", "1901");
		WAREKI_TO_SEIREKI_MAP.put("明治35", "1902");
		WAREKI_TO_SEIREKI_MAP.put("明治36", "1903");
		WAREKI_TO_SEIREKI_MAP.put("明治37", "1904");
		WAREKI_TO_SEIREKI_MAP.put("明治38", "1905");
		WAREKI_TO_SEIREKI_MAP.put("明治39", "1906");
		WAREKI_TO_SEIREKI_MAP.put("明治40", "1907");
		WAREKI_TO_SEIREKI_MAP.put("明治41", "1908");
		WAREKI_TO_SEIREKI_MAP.put("明治42", "1909");
		WAREKI_TO_SEIREKI_MAP.put("明治43", "1910");
		WAREKI_TO_SEIREKI_MAP.put("明治44", "1911");
		WAREKI_TO_SEIREKI_MAP.put("明治45", "1912");
		WAREKI_TO_SEIREKI_MAP.put("大正1", "1912");
		WAREKI_TO_SEIREKI_MAP.put("大正2", "1913");
		WAREKI_TO_SEIREKI_MAP.put("大正3", "1914");
		WAREKI_TO_SEIREKI_MAP.put("大正4", "1915");
		WAREKI_TO_SEIREKI_MAP.put("大正5", "1916");
		WAREKI_TO_SEIREKI_MAP.put("大正6", "1917");
		WAREKI_TO_SEIREKI_MAP.put("大正7", "1918");
		WAREKI_TO_SEIREKI_MAP.put("大正8", "1919");
		WAREKI_TO_SEIREKI_MAP.put("大正9", "1920");
		WAREKI_TO_SEIREKI_MAP.put("大正10", "1921");
		WAREKI_TO_SEIREKI_MAP.put("大正11", "1922");
		WAREKI_TO_SEIREKI_MAP.put("大正12", "1923");
		WAREKI_TO_SEIREKI_MAP.put("大正13", "1924");
		WAREKI_TO_SEIREKI_MAP.put("大正14", "1925");
		WAREKI_TO_SEIREKI_MAP.put("大正15", "1926");
		WAREKI_TO_SEIREKI_MAP.put("昭和1", "1926");
		WAREKI_TO_SEIREKI_MAP.put("昭和2", "1927");
		WAREKI_TO_SEIREKI_MAP.put("昭和3", "1928");
		WAREKI_TO_SEIREKI_MAP.put("昭和4", "1929");
		WAREKI_TO_SEIREKI_MAP.put("昭和5", "1930");
		WAREKI_TO_SEIREKI_MAP.put("昭和6", "1931");
		WAREKI_TO_SEIREKI_MAP.put("昭和7", "1932");
		WAREKI_TO_SEIREKI_MAP.put("昭和8", "1933");
		WAREKI_TO_SEIREKI_MAP.put("昭和9", "1934");
		WAREKI_TO_SEIREKI_MAP.put("昭和10", "1935");
		WAREKI_TO_SEIREKI_MAP.put("昭和11", "1936");
		WAREKI_TO_SEIREKI_MAP.put("昭和12", "1937");
		WAREKI_TO_SEIREKI_MAP.put("昭和13", "1938");
		WAREKI_TO_SEIREKI_MAP.put("昭和14", "1939");
		WAREKI_TO_SEIREKI_MAP.put("昭和15", "1940");
		WAREKI_TO_SEIREKI_MAP.put("昭和16", "1941");
		WAREKI_TO_SEIREKI_MAP.put("昭和17", "1942");
		WAREKI_TO_SEIREKI_MAP.put("昭和18", "1943");
		WAREKI_TO_SEIREKI_MAP.put("昭和19", "1944");
		WAREKI_TO_SEIREKI_MAP.put("昭和20", "1945");
		WAREKI_TO_SEIREKI_MAP.put("昭和21", "1946");
		WAREKI_TO_SEIREKI_MAP.put("昭和22", "1947");
		WAREKI_TO_SEIREKI_MAP.put("昭和23", "1948");
		WAREKI_TO_SEIREKI_MAP.put("昭和24", "1949");
		WAREKI_TO_SEIREKI_MAP.put("昭和25", "1950");
		WAREKI_TO_SEIREKI_MAP.put("昭和26", "1951");
		WAREKI_TO_SEIREKI_MAP.put("昭和27", "1952");
		WAREKI_TO_SEIREKI_MAP.put("昭和28", "1953");
		WAREKI_TO_SEIREKI_MAP.put("昭和29", "1954");
		WAREKI_TO_SEIREKI_MAP.put("昭和30", "1955");
		WAREKI_TO_SEIREKI_MAP.put("昭和31", "1956");
		WAREKI_TO_SEIREKI_MAP.put("昭和32", "1957");
		WAREKI_TO_SEIREKI_MAP.put("昭和33", "1958");
		WAREKI_TO_SEIREKI_MAP.put("昭和34", "1959");
		WAREKI_TO_SEIREKI_MAP.put("昭和35", "1960");
		WAREKI_TO_SEIREKI_MAP.put("昭和36", "1961");
		WAREKI_TO_SEIREKI_MAP.put("昭和37", "1962");
		WAREKI_TO_SEIREKI_MAP.put("昭和38", "1963");
		WAREKI_TO_SEIREKI_MAP.put("昭和39", "1964");
		WAREKI_TO_SEIREKI_MAP.put("昭和40", "1965");
		WAREKI_TO_SEIREKI_MAP.put("昭和41", "1966");
		WAREKI_TO_SEIREKI_MAP.put("昭和42", "1967");
		WAREKI_TO_SEIREKI_MAP.put("昭和43", "1968");
		WAREKI_TO_SEIREKI_MAP.put("昭和44", "1969");
		WAREKI_TO_SEIREKI_MAP.put("昭和45", "1970");
		WAREKI_TO_SEIREKI_MAP.put("昭和46", "1971");
		WAREKI_TO_SEIREKI_MAP.put("昭和47", "1972");
		WAREKI_TO_SEIREKI_MAP.put("昭和48", "1973");
		WAREKI_TO_SEIREKI_MAP.put("昭和49", "1974");
		WAREKI_TO_SEIREKI_MAP.put("昭和50", "1975");
		WAREKI_TO_SEIREKI_MAP.put("昭和51", "1976");
		WAREKI_TO_SEIREKI_MAP.put("昭和52", "1977");
		WAREKI_TO_SEIREKI_MAP.put("昭和53", "1978");
		WAREKI_TO_SEIREKI_MAP.put("昭和54", "1979");
		WAREKI_TO_SEIREKI_MAP.put("昭和55", "1980");
		WAREKI_TO_SEIREKI_MAP.put("昭和56", "1981");
		WAREKI_TO_SEIREKI_MAP.put("昭和57", "1982");
		WAREKI_TO_SEIREKI_MAP.put("昭和58", "1983");
		WAREKI_TO_SEIREKI_MAP.put("昭和59", "1984");
		WAREKI_TO_SEIREKI_MAP.put("昭和60", "1985");
		WAREKI_TO_SEIREKI_MAP.put("昭和61", "1986");
		WAREKI_TO_SEIREKI_MAP.put("昭和62", "1987");
		WAREKI_TO_SEIREKI_MAP.put("昭和63", "1988");
		WAREKI_TO_SEIREKI_MAP.put("昭和64", "1989");
		WAREKI_TO_SEIREKI_MAP.put("平成1", "1989");
		WAREKI_TO_SEIREKI_MAP.put("平成2", "1990");
		WAREKI_TO_SEIREKI_MAP.put("平成3", "1991");
		WAREKI_TO_SEIREKI_MAP.put("平成4", "1992");
		WAREKI_TO_SEIREKI_MAP.put("平成5", "1993");
		WAREKI_TO_SEIREKI_MAP.put("平成6", "1994");
		WAREKI_TO_SEIREKI_MAP.put("平成7", "1995");
		WAREKI_TO_SEIREKI_MAP.put("平成8", "1996");
		WAREKI_TO_SEIREKI_MAP.put("平成9", "1997");
		WAREKI_TO_SEIREKI_MAP.put("平成10", "1998");
		WAREKI_TO_SEIREKI_MAP.put("平成11", "1999");
		WAREKI_TO_SEIREKI_MAP.put("平成12", "2000");
		WAREKI_TO_SEIREKI_MAP.put("平成13", "2001");
		WAREKI_TO_SEIREKI_MAP.put("平成14", "2002");
		WAREKI_TO_SEIREKI_MAP.put("平成15", "2003");
		WAREKI_TO_SEIREKI_MAP.put("平成16", "2004");
		WAREKI_TO_SEIREKI_MAP.put("平成17", "2005");
		WAREKI_TO_SEIREKI_MAP.put("平成18", "2006");
		WAREKI_TO_SEIREKI_MAP.put("平成19", "2007");
		WAREKI_TO_SEIREKI_MAP.put("平成20", "2008");
		WAREKI_TO_SEIREKI_MAP.put("平成21", "2009");
		WAREKI_TO_SEIREKI_MAP.put("平成22", "2010");
		WAREKI_TO_SEIREKI_MAP.put("平成23", "2011");
		WAREKI_TO_SEIREKI_MAP.put("平成24", "2012");
		WAREKI_TO_SEIREKI_MAP.put("平成25", "2013");
		WAREKI_TO_SEIREKI_MAP.put("平成26", "2014");
		WAREKI_TO_SEIREKI_MAP.put("平成27", "2015");
		WAREKI_TO_SEIREKI_MAP.put("平成28", "2016");
		WAREKI_TO_SEIREKI_MAP.put("平成29", "2017");
		WAREKI_TO_SEIREKI_MAP.put("平成30", "2018");
		WAREKI_TO_SEIREKI_MAP.put("平成31", "2019");
		WAREKI_TO_SEIREKI_MAP.put("平成32", "2020");
		
		SEIREKI_TO_WAREKI_MAP.put(1900, "明治33");
		SEIREKI_TO_WAREKI_MAP.put(1901, "明治34");
		SEIREKI_TO_WAREKI_MAP.put(1902, "明治35");
		SEIREKI_TO_WAREKI_MAP.put(1903, "明治36");
		SEIREKI_TO_WAREKI_MAP.put(1904, "明治37");
		SEIREKI_TO_WAREKI_MAP.put(1905, "明治38");
		SEIREKI_TO_WAREKI_MAP.put(1906, "明治39");
		SEIREKI_TO_WAREKI_MAP.put(1907, "明治40");
		SEIREKI_TO_WAREKI_MAP.put(1908, "明治41");
		SEIREKI_TO_WAREKI_MAP.put(1909, "明治42");
		SEIREKI_TO_WAREKI_MAP.put(1910, "明治43");
		SEIREKI_TO_WAREKI_MAP.put(1911, "明治44");
		SEIREKI_TO_WAREKI_MAP.put(1912, "明治45/大正1");
		SEIREKI_TO_WAREKI_MAP.put(1913, "大正2");
		SEIREKI_TO_WAREKI_MAP.put(1914, "大正3");
		SEIREKI_TO_WAREKI_MAP.put(1915, "大正4");
		SEIREKI_TO_WAREKI_MAP.put(1916, "大正5");
		SEIREKI_TO_WAREKI_MAP.put(1917, "大正6");
		SEIREKI_TO_WAREKI_MAP.put(1918, "大正7");
		SEIREKI_TO_WAREKI_MAP.put(1919, "大正8");
		SEIREKI_TO_WAREKI_MAP.put(1920, "大正9");
		SEIREKI_TO_WAREKI_MAP.put(1921, "大正10");
		SEIREKI_TO_WAREKI_MAP.put(1922, "大正11");
		SEIREKI_TO_WAREKI_MAP.put(1923, "大正12");
		SEIREKI_TO_WAREKI_MAP.put(1924, "大正13");
		SEIREKI_TO_WAREKI_MAP.put(1925, "大正14");
		SEIREKI_TO_WAREKI_MAP.put(1926, "大正15/昭和1");
		SEIREKI_TO_WAREKI_MAP.put(1927, "昭和2");
		SEIREKI_TO_WAREKI_MAP.put(1928, "昭和3");
		SEIREKI_TO_WAREKI_MAP.put(1929, "昭和4");
		SEIREKI_TO_WAREKI_MAP.put(1930, "昭和5");
		SEIREKI_TO_WAREKI_MAP.put(1931, "昭和6");
		SEIREKI_TO_WAREKI_MAP.put(1932, "昭和7");
		SEIREKI_TO_WAREKI_MAP.put(1933, "昭和8");
		SEIREKI_TO_WAREKI_MAP.put(1934, "昭和9");
		SEIREKI_TO_WAREKI_MAP.put(1935, "昭和10");
		SEIREKI_TO_WAREKI_MAP.put(1936, "昭和11");
		SEIREKI_TO_WAREKI_MAP.put(1937, "昭和12");
		SEIREKI_TO_WAREKI_MAP.put(1938, "昭和13");
		SEIREKI_TO_WAREKI_MAP.put(1939, "昭和14");
		SEIREKI_TO_WAREKI_MAP.put(1940, "昭和15");
		SEIREKI_TO_WAREKI_MAP.put(1941, "昭和16");
		SEIREKI_TO_WAREKI_MAP.put(1942, "昭和17");
		SEIREKI_TO_WAREKI_MAP.put(1943, "昭和18");
		SEIREKI_TO_WAREKI_MAP.put(1944, "昭和19");
		SEIREKI_TO_WAREKI_MAP.put(1945, "昭和20");
		SEIREKI_TO_WAREKI_MAP.put(1946, "昭和21");
		SEIREKI_TO_WAREKI_MAP.put(1947, "昭和22");
		SEIREKI_TO_WAREKI_MAP.put(1948, "昭和23");
		SEIREKI_TO_WAREKI_MAP.put(1949, "昭和24");
		SEIREKI_TO_WAREKI_MAP.put(1950, "昭和25");
		SEIREKI_TO_WAREKI_MAP.put(1951, "昭和26");
		SEIREKI_TO_WAREKI_MAP.put(1952, "昭和27");
		SEIREKI_TO_WAREKI_MAP.put(1953, "昭和28");
		SEIREKI_TO_WAREKI_MAP.put(1954, "昭和29");
		SEIREKI_TO_WAREKI_MAP.put(1955, "昭和30");
		SEIREKI_TO_WAREKI_MAP.put(1956, "昭和31");
		SEIREKI_TO_WAREKI_MAP.put(1957, "昭和32");
		SEIREKI_TO_WAREKI_MAP.put(1958, "昭和33");
		SEIREKI_TO_WAREKI_MAP.put(1959, "昭和34");
		SEIREKI_TO_WAREKI_MAP.put(1960, "昭和35");
		SEIREKI_TO_WAREKI_MAP.put(1961, "昭和36");
		SEIREKI_TO_WAREKI_MAP.put(1962, "昭和37");
		SEIREKI_TO_WAREKI_MAP.put(1963, "昭和38");
		SEIREKI_TO_WAREKI_MAP.put(1964, "昭和39");
		SEIREKI_TO_WAREKI_MAP.put(1965, "昭和40");
		SEIREKI_TO_WAREKI_MAP.put(1966, "昭和41");
		SEIREKI_TO_WAREKI_MAP.put(1967, "昭和42");
		SEIREKI_TO_WAREKI_MAP.put(1968, "昭和43");
		SEIREKI_TO_WAREKI_MAP.put(1969, "昭和44");
		SEIREKI_TO_WAREKI_MAP.put(1970, "昭和45");
		SEIREKI_TO_WAREKI_MAP.put(1971, "昭和46");
		SEIREKI_TO_WAREKI_MAP.put(1972, "昭和47");
		SEIREKI_TO_WAREKI_MAP.put(1973, "昭和48");
		SEIREKI_TO_WAREKI_MAP.put(1974, "昭和49");
		SEIREKI_TO_WAREKI_MAP.put(1975, "昭和50");
		SEIREKI_TO_WAREKI_MAP.put(1976, "昭和51");
		SEIREKI_TO_WAREKI_MAP.put(1977, "昭和52");
		SEIREKI_TO_WAREKI_MAP.put(1978, "昭和53");
		SEIREKI_TO_WAREKI_MAP.put(1979, "昭和54");
		SEIREKI_TO_WAREKI_MAP.put(1980, "昭和55");
		SEIREKI_TO_WAREKI_MAP.put(1981, "昭和56");
		SEIREKI_TO_WAREKI_MAP.put(1982, "昭和57");
		SEIREKI_TO_WAREKI_MAP.put(1983, "昭和58");
		SEIREKI_TO_WAREKI_MAP.put(1984, "昭和59");
		SEIREKI_TO_WAREKI_MAP.put(1985, "昭和60");
		SEIREKI_TO_WAREKI_MAP.put(1986, "昭和61");
		SEIREKI_TO_WAREKI_MAP.put(1987, "昭和62");
		SEIREKI_TO_WAREKI_MAP.put(1988, "昭和63");
		SEIREKI_TO_WAREKI_MAP.put(1989, "昭和64/平成1");
		SEIREKI_TO_WAREKI_MAP.put(1990, "平成2");
		SEIREKI_TO_WAREKI_MAP.put(1991, "平成3");
		SEIREKI_TO_WAREKI_MAP.put(1992, "平成4");
		SEIREKI_TO_WAREKI_MAP.put(1993, "平成5");
		SEIREKI_TO_WAREKI_MAP.put(1994, "平成6");
		SEIREKI_TO_WAREKI_MAP.put(1995, "平成7");
		SEIREKI_TO_WAREKI_MAP.put(1996, "平成8");
		SEIREKI_TO_WAREKI_MAP.put(1997, "平成9");
		SEIREKI_TO_WAREKI_MAP.put(1998, "平成10");
		SEIREKI_TO_WAREKI_MAP.put(1999, "平成11");
		SEIREKI_TO_WAREKI_MAP.put(2000, "平成12");
		SEIREKI_TO_WAREKI_MAP.put(2001, "平成13");
		SEIREKI_TO_WAREKI_MAP.put(2002, "平成14");
		SEIREKI_TO_WAREKI_MAP.put(2003, "平成15");
		SEIREKI_TO_WAREKI_MAP.put(2004, "平成16");
		SEIREKI_TO_WAREKI_MAP.put(2005, "平成17");
		SEIREKI_TO_WAREKI_MAP.put(2006, "平成18");
		SEIREKI_TO_WAREKI_MAP.put(2007, "平成19");
		SEIREKI_TO_WAREKI_MAP.put(2008, "平成20");
		SEIREKI_TO_WAREKI_MAP.put(2009, "平成21");
		SEIREKI_TO_WAREKI_MAP.put(2010, "平成22");
		SEIREKI_TO_WAREKI_MAP.put(2011, "平成23");
		SEIREKI_TO_WAREKI_MAP.put(2012, "平成24");
		SEIREKI_TO_WAREKI_MAP.put(2013, "平成25");
		SEIREKI_TO_WAREKI_MAP.put(2014, "平成26");
		SEIREKI_TO_WAREKI_MAP.put(2015, "平成27");
		SEIREKI_TO_WAREKI_MAP.put(2016, "平成28");
		SEIREKI_TO_WAREKI_MAP.put(2017, "平成29");
		SEIREKI_TO_WAREKI_MAP.put(2018, "平成30");
		SEIREKI_TO_WAREKI_MAP.put(2019, "平成31");
		SEIREKI_TO_WAREKI_MAP.put(2020, "平成32");
	}
	
	public String execute(String inputText) {
		System.out.println("[DEBUG] inputText = " + inputText);
		
		String outputText = "";
		
		if (isWarekiText(inputText)) { // 和暦入力か？
			String wareki = parseWarekiText(inputText);
			System.out.println("[DEBUG] isWarekiText wareki = " + wareki);
			
			outputText = WAREKI_TO_SEIREKI_MAP.getOrDefault(wareki, "？？");
		}
		else if (isSeirekiText(inputText)) { // 西暦入力か？
        	int seireki = parseSeirekiText(inputText);
        	System.out.println("[DEBUG] isSeirekiText seireki = " + seireki);
        	
        	outputText = SEIREKI_TO_WAREKI_MAP.getOrDefault(seireki, "？？");
        }
		
		System.out.println("[DEBUG] outputText = " + outputText);
		return outputText;
	}
	
	private boolean isWarekiText(String inputText) {
		return parseWarekiText(inputText) != null;
	}
	
	private boolean isSeirekiText(String inputText) {
		if (StringUtils.isEmpty(inputText)) {
			return false;
		}
		
    	try {
    		int seireki = parseSeirekiText(inputText);
    		if (1900 <= seireki && seireki <= 2099) {
    			return true;
    		}
    	} catch(NumberFormatException e) {
    		//e.printStackTrace();
    	}
    	return false;
    }
    
	// 平成29年
	// 昭和31
	// 大正12年ごろ
	// 明治42年
	
	private String parseWarekiText(String message) {
		String result = null;
		
		if (!StringUtils.isEmpty(message)) {
			String regex = "^(明治|大正|昭和|平成)(\\d+).*";
			Pattern p = Pattern.compile(regex);
			
			System.out.println("[DEBUG] regexText = " + regex);
			Matcher m = p.matcher(message);
			if (m.matches()) {
				System.out.println("[DEBUG] matches!!");
				
				String matchstr = m.group();
				System.out.println("マッチ文字列 : " + matchstr);
				System.out.println("元号 : " + m.group(1));
				System.out.println("年  : " + m.group(2));
  
				result = m.group(1) + m.group(2);
			}
		}
		
		return result;
    }
	
	// 2017年
	// 2018

    private int parseSeirekiText(String message) {
    	return Integer.parseInt(message.trim().replaceAll("[^0-9]", ""));
    }
}
