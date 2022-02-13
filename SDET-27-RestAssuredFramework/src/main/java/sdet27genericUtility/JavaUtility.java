package sdet27genericUtility;

import java.util.Random;

/**
 * 
 * @author anils
 *
 */

public class JavaUtility {

	
	/**
	 * this method will generate random number for every run
	 * @return
	 */
	
	  public int getRandomNumber() {
		  
		  Random ran = new Random();
		  int randomNum=ran.nextInt(500);
		  
		  return randomNum;
	  }
}
