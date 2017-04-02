package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;


public class RobotTest {

	public static void main(String[] args){
/*
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c","start firefox http://www.youtube.com"});
			 
				Thread.sleep(20000);
			    System.out.println("1");
				Robot r = new Robot();
		
				r.delay(1500); 
				r.keyPress(KeyEvent.VK_M);
				r.keyRelease(KeyEvent.VK_M);
				
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);
				
				r.keyPress(KeyEvent.VK_H);
				r.keyRelease(KeyEvent.VK_H);
				
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				
				r.keyPress(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_S);
				
				r.keyPress(KeyEvent.VK_H);
				r.keyRelease(KeyEvent.VK_H);
				
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				
				System.out.println("2");
			 
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 */
		WebDriver driver = new FirefoxDriver();	
        driver.manage().window().maximize();	
        driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url	
        Robot robot = new Robot();	
        robot.mouseMove(630, 420); // move mouse point to specific location	
        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
        robot.delay(1500);	
        robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_ENTER);
	

	}
	 
}
