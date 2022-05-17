package commands;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import configs.Base;
import utilities.ExtentManager;

public class DateActions extends Base {
public static long  DiffBetweenDates(String date1, String date2) throws ParseException {

	
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(date1);
        Date secondDate = sdf.parse(date2);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        ExtentManager.childTest.pass("The difference in days is : "+diffrence);
        
        return diff;

		
		
	}

	public static String  addDaystoDate(String date1, int days) throws ParseException {

		
		  
		LocalDate date = LocalDate.parse(date1);
		
		LocalDate date2 = date.plusDays(days);
		ExtentManager.childTest.pass("Date "+date+" plus "+days+ "days is "+date2);
		String datestr=date2.toString();
		
		return datestr;
	}
	public static String  minusDaysFromDate(String date1, int days) throws ParseException {

		
       
		  
		LocalDate date = LocalDate.parse(date1);
		 
		
		LocalDate date2 = date.minusDays(days);
		ExtentManager.childTest.pass("Date "+date+" minus " +days+"days is "+date2);
		String datestr=date2.toString();
		
		return datestr;
	}
	
	

}
