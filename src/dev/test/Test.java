/**
 * 
 */
package dev.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author IKANE
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BAB00001".substring(2));
		
		Calendar cal = Calendar.getInstance();
		
		Calendar cal0101 = Calendar.getInstance();
		cal0101.set(Calendar.MONTH, Calendar.JANUARY);
		cal0101.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar cal3102 = Calendar.getInstance();
		cal3102.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal3102.set(Calendar.DAY_OF_MONTH, 28);
		
		if((cal.getTime().getTime() >= cal0101.getTime().getTime()) && (cal.getTime().getTime() <= cal3102.getTime().getTime())) {
			//...
		}
		
		
		/*
		cal.setTime(new Date());
		String Annee = String.valueOf(cal.get(Calendar.YEAR)); 
		String semaine_glissante1 = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)); 
		String semaine_glissante2 = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - 10);
		
		System.out.println(String.valueOf(cal.get(Calendar.YEAR)));
		System.out.println(String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)));
		System.out.println(String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - 10));
		*/
		System.out.println(cal.getTime());
		System.out.println(cal0101.getTime());
		System.out.println(cal3102.getTime());
	}

}
