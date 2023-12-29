package org.testing.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {

	public static void drop(WebElement element,int string) {
  		Select s= new Select(element);
  		s.selectByIndex(string);
      }
      public static void drop1(WebElement element,String string) {
    		Select s1= new Select(element);
    		s1.selectByValue(string);
        }
      public static void drop2(WebElement element,String string) {
    		Select s2= new Select(element);
    		s2.selectByValue(string);
        }
}
