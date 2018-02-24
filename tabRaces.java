import java.util.Comparator;

public class tabRaces {
	public tabRaces() {
        super();
        // TODO Auto-generated constructor stub
    }
	 public static Comparator<tabRaces> timeOrder = new Comparator<tabRaces>() {
			public int compare(tabRaces arg0, tabRaces arg1) {
				// TODO Auto-generated method stub
				double p1 = ((tabRaces) arg0).timeRemaining;
			       double p2 = ((tabRaces) arg1).timeRemaining;

			       if (p1 > p2) {
			           return 1;
			       } else if (p1 < p2){
			           return -1;
			       } else {
			           return 0;
			       }
			    }};
	


public void tabRACE() {}

public String raceVenue;
public String raceNumber;
public String URL;
public double timeRemaining;
public String raceXpath;
public String gradeOfRace;


}