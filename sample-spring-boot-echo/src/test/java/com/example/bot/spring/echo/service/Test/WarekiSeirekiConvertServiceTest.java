package com.example.bot.spring.echo.service.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bot.spring.echo.service.WarekiSeirekiConvertService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "line.bot.channel-token=testChannelToken", "line.bot.channelSecret=testChannelSecret" }) // ダミーのプロパティ値がないとテストが動かない
public class WarekiSeirekiConvertServiceTest{
	@Autowired
	WarekiSeirekiConvertService service;
	
	@Test
	public void warekiTest1() {
		assertEquals("1900", service.execute("明治33年"));
		assertEquals("1912", service.execute("明治45年"));
		assertEquals("1912", service.execute("大正1年"));
		assertEquals("1926", service.execute("大正15年"));
		assertEquals("1926", service.execute("昭和1年"));
		assertEquals("1989", service.execute("昭和64年"));
		assertEquals("1989", service.execute("平成1年"));
		assertEquals("2017", service.execute("平成29年"));
		assertEquals("2018", service.execute("平成30年"));
		assertEquals("2019", service.execute("平成31年"));
		assertEquals("2019", service.execute("令和1年"));
		assertEquals("2028", service.execute("令和10年"));
	}
	
	@Test
	public void seirekiTest1() {
		assertEquals("明治33", service.execute("1900"));
		assertEquals("明治45/大正1", service.execute("1912"));
		assertEquals("大正15/昭和1", service.execute("1926"));
		assertEquals("昭和64/平成1", service.execute("1989"));
		assertEquals("平成2", service.execute("1990"));
		assertEquals("平成3", service.execute("1991"));
		assertEquals("平成4", service.execute("1992"));
		assertEquals("平成5", service.execute("1993"));
		assertEquals("平成6", service.execute("1994"));
		assertEquals("平成7", service.execute("1995"));
		assertEquals("平成8", service.execute("1996"));
		assertEquals("平成9", service.execute("1997"));
		assertEquals("平成10", service.execute("1998"));
		assertEquals("平成11", service.execute("1999"));
		assertEquals("平成12", service.execute("2000"));
		assertEquals("平成13", service.execute("2001"));
		assertEquals("平成14", service.execute("2002"));
		assertEquals("平成15", service.execute("2003"));
		assertEquals("平成16", service.execute("2004"));
		assertEquals("平成17", service.execute("2005"));
		assertEquals("平成18", service.execute("2006"));
		assertEquals("平成19", service.execute("2007"));
		assertEquals("平成20", service.execute("2008"));
		assertEquals("平成21", service.execute("2009"));
		assertEquals("平成22", service.execute("2010"));
		assertEquals("平成23", service.execute("2011"));
		assertEquals("平成24", service.execute("2012"));
		assertEquals("平成25", service.execute("2013"));
		assertEquals("平成26", service.execute("2014"));
		assertEquals("平成27", service.execute("2015"));
		assertEquals("平成28", service.execute("2016"));
		assertEquals("平成29", service.execute("2017"));
		assertEquals("平成30", service.execute("2018"));
		assertEquals("平成31/令和1", service.execute("2019"));
		assertEquals("令和10", service.execute("2028"));
	}
	
	@Test
	public void nowTest1() {
		String nowSeireki = String.valueOf(LocalDateTime.now().getYear());
		String nowWareki = service.execute(nowSeireki);
		String expected = nowSeireki + " / " + nowWareki;
		
		assertEquals(expected, service.execute("いま"));
		assertEquals(expected, service.execute("今"));
		assertEquals(expected, service.execute("now"));
		assertEquals(expected, service.execute("Now"));
		assertEquals(expected, service.execute("NOW"));
	}
	
	@Test
	public void syntaxTest1() {
		assertEquals("1900", service.execute("明治33"));
		assertEquals("1912", service.execute("明治45年頃"));
		assertEquals("1912", service.execute("大正1年 あいうえお"));
		assertEquals("1926", service.execute("大正15 大正15"));
		assertEquals("1926", service.execute("昭和1\r\n"));
		assertEquals("1989", service.execute("昭和64年\n"));
		assertEquals("1989", service.execute("\r\n平成1　あいうえお"));
		assertEquals("2017", service.execute("\n平成29年　テスト"));
		assertEquals("2018", service.execute(" 平成30年 "));
		assertEquals("2019", service.execute("　平成31年　"));
		assertEquals("2019", service.execute("　令和1年　"));
		assertEquals("2028", service.execute("令和10"));
		
		assertEquals("明治33", service.execute("1900年"));
		assertEquals("明治45/大正1", service.execute("1912 年"));
		assertEquals("大正15/昭和1", service.execute(" 1926 "));
		assertEquals("昭和64/平成1", service.execute("　1989　"));
		assertEquals("平成26", service.execute("2014\r\n"));
		assertEquals("平成27", service.execute("2015\n"));
		assertEquals("平成28", service.execute("\r\n 2016 \r\n"));
		assertEquals("平成29", service.execute(" \n 2017 \n "));
		assertEquals("令和10", service.execute("2028年"));
	}
	
//	@Test
//	public void futureTest1() {
//		int nowSeireki = LocalDateTime.now().getYear();
//		String nowWareki = service.execute(String.valueOf(nowSeireki));
//		String nowGengo = nowWareki.substring(0, 2);
//		int nowWarekiYear = Integer.parseInt(nowWareki.substring(2, 4));
//		
//		int expectedWarekiYear = nowWarekiYear;
//		for (int i = nowSeireki; i <= 2099; i++) {
//			assertEquals(nowGengo + expectedWarekiYear, service.execute(String.valueOf(i)));
//			expectedWarekiYear++;
//		}
//	}
}
