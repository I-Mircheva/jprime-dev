package site.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import site.facade.VideoSanitizerService;

public class VideoSanitizerServiceTest {
	
	private VideoSanitizerService videoSanitizerService = new VideoSanitizerService();
	
	@Test
	public void formatStringTest() {
		  String testString = "Sometext.With,Alot of;punctuation\twhichshould\nbesplitted";
		  String testString2 = "Some,text,some , text";
		  String formatedString = videoSanitizerService.formatString(testString);
		  String formatedString2 = videoSanitizerService.formatString(testString2);
		  
		  assertTrue(formatedString.split(" ").length == 6);
		  assertTrue(formatedString2.split(" ").length == 4);
		  
		  assertFalse(formatedString.contains(",") && formatedString2.contains(","));
		  assertFalse(formatedString.contains(";") && formatedString2.contains(";"));
		  assertFalse(formatedString.contains("\n") && formatedString2.contains("\n"));
		  assertFalse(formatedString.contains("\t") && formatedString2.contains("\t"));
	}
}
