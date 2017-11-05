package com.example.bot.spring.echo.repository;

import org.springframework.stereotype.Component;

@Component
public interface WarekiSeirekiRepository {

	String findSeirekiText(String warekiGengo, int warekiYear);
	
	String findWarekiText(int seirekiYear);
}
