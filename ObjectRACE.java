import java.util.ArrayList;
import java.util.Comparator;

import org.openqa.selenium.WebDriver;

public class ObjectRACE  implements java.io.Serializable {
	public static Comparator<ObjectRACE> timeDoubleOrder = new Comparator<ObjectRACE>() {
		public int compare(ObjectRACE arg0, ObjectRACE arg1) {
			// TODO Auto-generated method stub
			double p1 = ((ObjectRACE) arg0).timeDouble;
		       double p2 = ((ObjectRACE) arg1).timeDouble;

		       if (p1 > p2) {
		           return 1;
		       } else if (p1 < p2){
		           return -1;
		       } else {
		           return 0;
		       }
		    }};
	
	public ObjectRACE() {}
	public boolean positioningComplete = false;
	public boolean bettingComplete = false;
	public boolean teirOneError = true;
	public String dateSlashes;
	public String raceVenue;
	public String URL="empty";
	public String URLSecondSection;
	public String raceNumber;
	public String raceTime;
	public String fullRaceTime;
	public WebDriver raceDriver;
	boolean webDriverPresence=false;
	boolean rave = false;
	boolean wwin = false;
	
	public double timeDouble;
	public String distanceOfRace;
	public String gradeOfRace;
	public String raceXpath;
	public String raceVenueLocation;
	public double timeRemaining;
	
	public String firstPlace="0";
	public String secondPlace="0";
	public String thirdPlace="0";
	public String fourthPlace="0";
	
	public double winDiv;
	public double fixedOddwinDiv;
	public String typeOfRace;
	
	public String PLACE=null;
	public double PLACEPAY;
	public String WIN=null;
	public double WINPAY;
	
	public double secondplaceDiv;
	public double thirdplaceDiv;
	public double firstplaceDiv;
	public double fixedsecondplaceDiv;
	public double fixedthirdplaceDiv;
	public double fixedfirstplaceDiv;
	public double quinellaDiv;
	public double trifectaDiv;
	public double firstFourDiv;
	
	public double win=0;
	public double place=0;
	public double quinella=0;
	public double trifecta=0;
	public double firstFour=0;
	
		
	
	public ArrayList<ObjectDOG> dogs = new ArrayList<ObjectDOG>();
	
	public ArrayList<ObjectDOG> selections = new ArrayList<ObjectDOG>();
	
	


}
