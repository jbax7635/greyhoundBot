import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class ObjectDOG implements java.io.Serializable {
	public ObjectDOG(String name) {
		
		// TODO Auto-generated constructor stub

				dogName = name;
		
			
		
		}
	
	public static Comparator<ObjectDOG> DISTANCEWINS = new Comparator<ObjectDOG>() {
		public int compare(ObjectDOG arg0, ObjectDOG arg1) {
			// TODO Auto-generated method stub
			double p1 = ((ObjectDOG) arg0).getDistanceWins();
		       double p2 = ((ObjectDOG) arg1).getDistanceWins();

		       if (p1 < p2) {
		           return 1;
		       } else if (p1 > p2){
		           return -1;
		       } else {
		           return 0;
		       }
		    }};
		    
		    public static Comparator<ObjectDOG> TRAINERWINS = new Comparator<ObjectDOG>() {
				public int compare(ObjectDOG arg0, ObjectDOG arg1) {
					// TODO Auto-generated method stub
					
					double p1 = ((ObjectDOG) arg0).getWinPercentage();
				       double p2 = ((ObjectDOG) arg1).getWinPercentage();

				       if (p1 < p2) {
				           return 1;
				       } else if (p1 > p2){
				           return -1;
				       } else {
				           return 0;
				       }
				    }};
				    
				    public static Comparator<ObjectDOG> TRAINERPLACE = new Comparator<ObjectDOG>() {
				    	
						public int compare(ObjectDOG arg0, ObjectDOG arg1) {
							// TODO Auto-generated method stub
							
							
							
							double p1 = ((ObjectDOG) arg0).getPlacePercentage();
						       double p2 = ((ObjectDOG) arg1).getPlacePercentage();

						       if (p1 < p2) {
						           return 1;
						       } else if (p1 > p2){
						           return -1;
						       } else {
						           return 0;
						       }
						    }};
		    
	public static Comparator<ObjectDOG> WINSATTRACK = new Comparator<ObjectDOG>() {
		public int compare(ObjectDOG arg0, ObjectDOG arg1) {
			// TODO Auto-generated method stub
			double p1 = ((ObjectDOG) arg0).getTrackWins();
		       double p2 = ((ObjectDOG) arg1).getTrackWins();

		       if (p1 < p2) {
		           return 1;
		       } else if (p1 > p2){
		           return -1;
		       } else {
		           return 0;
		       }
		    }};
		    
		    public static Comparator<ObjectDOG> TOTALTICKS = new Comparator<ObjectDOG>() {
				public int compare(ObjectDOG arg0, ObjectDOG arg1) {
					// TODO Auto-generated method stub
					double p1 = ((ObjectDOG) arg0).totalTicks;
				       double p2 = ((ObjectDOG) arg1).totalTicks;

				       if (p1 < p2) {
				           return 1;
				       } else if (p1 > p2){
				           return -1;
				       } else {
				           return 0;
				       }
				    }};
				    
				    public static Comparator<ObjectDOG> TABFORMRATING = new Comparator<ObjectDOG>() {
						public int compare(ObjectDOG arg0, ObjectDOG arg1) {
							// TODO Auto-generated method stub
							double p1 = ((ObjectDOG) arg0).TABFormRating;
						       double p2 = ((ObjectDOG) arg1).TABFormRating;

						       if (p1 < p2) {
						           return 1;
						       } else if (p1 > p2){
						           return -1;
						       } else {
						           return 0;
						       }
						    }};
						    public static Comparator<ObjectDOG> FIXEDODDPLACEPRICE = new Comparator<ObjectDOG>() {
								public int compare(ObjectDOG arg0, ObjectDOG arg1) {
									// TODO Auto-generated method stub
									double p1 = ((ObjectDOG) arg0).fixedOddPlacePrice;
								       double p2 = ((ObjectDOG) arg1).fixedOddPlacePrice;

								       if (p1 > p2) {
								           return 1;
								       } else if (p1 < p2){
								           return -1;
								       } else {
								           return 0;
								       }
								    }};
								    
								    public static Comparator<ObjectDOG> FIXEDODDWINPRICE = new Comparator<ObjectDOG>() {
										public int compare(ObjectDOG arg0, ObjectDOG arg1) {
											// TODO Auto-generated method stub
											double p1 = ((ObjectDOG) arg0).winPay;
										       double p2 = ((ObjectDOG) arg1).winPay;

										       if (p1 > p2) {
										           return 1;
										       } else if (p1 < p2){
										           return -1;
										       } else {
										           return 0;
										       }
										    }};
										    
										    
						    
				    
				    public static Comparator<ObjectDOG> PRICEPLACE = new Comparator<ObjectDOG>() {
						public int compare(ObjectDOG arg0, ObjectDOG arg1) {
							// TODO Auto-generated method stub
							double p1 = ((ObjectDOG) arg0).placePay;
						       double p2 = ((ObjectDOG) arg1).placePay;

						       if (p1 < p2) {
						           return 1;
						       } else if (p1 > p2){
						           return -1;
						       } else {
						           return 0;
						       }
						    }};
						    
						    public static Comparator<ObjectDOG> PRICEWIN = new Comparator<ObjectDOG>() {
								public int compare(ObjectDOG arg0, ObjectDOG arg1) {
									// TODO Auto-generated method stub
									double p1 = ((ObjectDOG) arg0).winPay;
								       double p2 = ((ObjectDOG) arg1).winPay;

								       if (p1 < p2) {
								           return 1;
								       } else if (p1 > p2){
								           return -1;
								       } else {
								           return 0;
								       }
								    }};
		    
		    public static Comparator<ObjectDOG> LASTTHREEFINISHES = new Comparator<ObjectDOG>() {
				public int compare(ObjectDOG arg0, ObjectDOG arg1) {
					// TODO Auto-generated method stub
					double p1 = ((ObjectDOG) arg0).getLastThreeFinishes();
				       double p2 = ((ObjectDOG) arg1).getLastThreeFinishes();

				       if (p1 > p2) {
				           return 1;
				       } else if (p1 < p2){
				           return -1;
				       } else {
				           return 0;
				       }
				    }};
	
	public static Comparator<ObjectDOG> FINISHTIME = new Comparator<ObjectDOG>() {
		public int compare(ObjectDOG arg0, ObjectDOG arg1) {
			// TODO Auto-generated method stub
			double p1 = ((ObjectDOG) arg0).getFinishTime();
		       double p2 = ((ObjectDOG) arg1).getFinishTime();

		       if (p1 > p2) {
		           return 1;
		       } else if (p1 < p2){
		           return -1;
		       } else {
		           return 0;
		       }
		    }};
		    public static Comparator<ObjectDOG> BOX = new Comparator<ObjectDOG>() {
				public int compare(ObjectDOG arg0, ObjectDOG arg1) {
					// TODO Auto-generated method stub
					double p1 = ((ObjectDOG) arg0).getFinishTime();
				       double p2 = ((ObjectDOG) arg1).getFinishTime();

				       if (p1 > p2) {
				           return 1;
				       } else if (p1 < p2){
				           return -1;
				       } else {
				           return 0;
				       }
				    }};
				    
				   
		    
		    public static Comparator<ObjectDOG> FIRSTSECTIONTIME = new Comparator<ObjectDOG>() {
				public int compare(ObjectDOG arg0, ObjectDOG arg1) {
					// TODO Auto-generated method stub
					double p1 = ((ObjectDOG) arg0).getFirstSectionTimes();
				       double p2 = ((ObjectDOG) arg1).getFirstSectionTimes();

				       if (p1 > p2) {
				           return 1;
				       } else if (p1 < p2){
				           return -1;
				       } else {
				           return 0;
				       }
				    }};
				    
				    public static Comparator<ObjectDOG> GRADEAVERAGE = new Comparator<ObjectDOG>() {
						public int compare(ObjectDOG arg0, ObjectDOG arg1) {
							// TODO Auto-generated method stub
							double p1 = ((ObjectDOG) arg0).getGradeAverage();
						       double p2 = ((ObjectDOG) arg1).getGradeAverage();

						       if (p1 > p2) {
						           return 1;
						       } else if (p1 < p2){
						           return -1;
						       } else {
						           return 0;
						       }
						    }};
						    
						    public static Comparator<ObjectDOG> STARTINGPRICE = new Comparator<ObjectDOG>() {
								public int compare(ObjectDOG arg0, ObjectDOG arg1) {
									// TODO Auto-generated method stub
									double p1 = ((ObjectDOG) arg0).getSP();
								       double p2 = ((ObjectDOG) arg1).getSP();

								       if (p1 > p2) {
								           return 1;
								       } else if (p1 < p2){
								           return -1;
								       } else {
								           return 0;
								       }
								    }};
	
	
	
	
	public ObjectDOG() {
        super();
        // TODO Auto-generated constructor stub
    }
	public String placexpath="";
	public String winxpath="";
	private int winsAtTrack =100;
	public double winPercentage=0;
	public double placePercentage=0;
	public double trifectaPercentage=0;
	public double firstFourPercentage=0;
	public double lastRun=100;
	public double placeChance = 0;
	
	public double TABFormRating = 0;

	public double winChance = 0;
	private int runcount =0;
	private int winsAtDistance=100;
	private boolean timeAlert = false;
	private String prefferedLane="100";
	private String dogName="100";
	public double wager=0;
	
	private double startingPrice =10;
	private  ArrayList<Double> firstSectionalTimes = new ArrayList<Double>();
	private  ArrayList<Double> raceTime = new ArrayList<Double>();
	private  ArrayList<Double> gradeRunnings = new ArrayList<Double>();
	private  ArrayList<Double> outsideBoxes = new ArrayList<Double>();
	private  ArrayList<Double> middleBoxes = new ArrayList<Double>();
	private  ArrayList<Double> threeFinishes = new ArrayList<Double>();
	
	public Double finishTimeRank =(double) 0;
	public Double firstSectionTimeRank=(double) 0;
	public Double gradeAverageRank=(double) 0;
	public Double winsAtTrackRank=(double) 0;
	public Double lastThreeFinishesRank=(double) 0;
	public Double distanceWinsRank=(double) 0;
	public Double trainerWinRank=(double) 0;
	public Double lastRaceDaysRank=(double) 0;
	public Double StartingPriceRank=(double) 0;
	public Double TABFormRank=(double) 0;

	public Double trainerPlaceRank=(double) 0;
	
	
	public Double fixedOddWinPrice=(double) 0;
	public Double fixedOddPlacePrice=(double) 0;
	public Double winPay= 0.0;
	public Double placePay= 0.0;
	
	
	
	public String boxNumber = "0";
	private String trainer="100";	
	

	public String name() {
		// TODO Auto-generated method stub
		return dogName;
	}

	public void giveBox(int e) {
		// TODO Auto-generated method stub
		if(boxNumber.equals("0"))
		{
			int num = e-1;
			boxNumber = ""+ num;
		}
		else{//do nothing}
		
	}

}

	public String getBox() {
		// TODO Auto-generated method stub
		return boxNumber;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return dogName;
	}


	public void giveTrainer(String text) {
		// TODO Auto-generated method stub
		trainer = text;
		
	}

	public String getTrainer() {
		// TODO Auto-generated method stub
		return trainer;
	}

	public void insideLane() {
		// TODO Auto-generated method stub
		prefferedLane = "insideLane";
	}

	public void insideMiddleLane() {
		// TODO Auto-generated method stub
		prefferedLane = "insideMiddleLane";
	}
	public void outsideMiddleLane() {
		// TODO Auto-generated method stub
		prefferedLane = "outsideMiddleLane";
	}

	public void outsideLane() {
		// TODO Auto-generated method stub
		prefferedLane = "outsideLane";
	}
	public String getPrefferedLane() {
		// TODO Auto-generated method stub
		return prefferedLane;
	}

	public void addGrade(String finishPosition) {
		// TODO Auto-generated method stub
		double number = Double.parseDouble(finishPosition);
		if (gradeRunnings.size()< 4)
		{
		gradeRunnings.add(number);
		}
		
	}
	public double getGradeAverage() {
		// TODO Auto-generated method stub
		double sum=0;
		if (gradeRunnings.size()==0)
				{
			return 100;
				}
		for(int q =0; q< gradeRunnings.size(); q++ )
		{
		sum = sum + gradeRunnings.get(q);	
		}
		return (sum/gradeRunnings.size());
	}

	public void addFirstSection(String firstSection) {
		// TODO Auto-generated method stub
		if(firstSectionalTimes.size()<=3){
			
		firstSectionalTimes.add(Double.parseDouble(firstSection));
		}
		
	}
	public double getFirstSectionTimes() {
		// TODO Auto-generated method stub
		if(firstSectionalTimes.size()==0)
		{return 100;}
		
		double sum=0;
		for(int q =0; q< firstSectionalTimes.size(); q++ )
		{
		sum = sum + firstSectionalTimes.get(q);	
		}
		return (sum/firstSectionalTimes.size());
	}

	public void addFinishTime(String timeOfRace, String box) {
		// TODO Auto-generated method stub
		if(raceTime.size()<=3){
		double time = Double.parseDouble(timeOfRace);
		if(box.equals("2")== true)
		{
			time = time - .02;
		}
		if(box.equals("3") == true)
		{
			time = time -.03 ;
		}
		if(box.equals("4")== true)
		{
			time = time -.06 ;
		}
		if(box.equals("5")== true)
		{
			time = time - .07;
		}
		if(box.equals("6")== true)
		{
			time = time - .07;
		}
		if(box.equals("7")== true)
		{
			time = time -.05 ;
		}
		if(box.equals("8")== true)
		{
			time = time - .02;
		}
		
		if(boxNumber.equals("2")== true)
		{
			time = time + .02;
		}
		if(boxNumber.equals("3") == true)
		{
			time = time +.03 ;
		}
		if(boxNumber.equals("4")== true)
		{
			time = time +.06 ;
		}
		if(boxNumber.equals("5")== true)
		{
			time = time + .07;
		}
		if(boxNumber.equals("6")== true)
		{
			time = time + .07;
		}
		if(boxNumber.equals("7")== true)
		{
			time = time +.05 ;
		}
		if(boxNumber.equals("8")== true)
		{
			time = time + .02;
		}
		
		
		
		
		
		raceTime.add(time);
		
		}
		
	}
	public double getFinishTime() {
		// TODO Auto-generated method stub
		
		if(raceTime.size()==0)
		{
			timeAlert = true;
		return 100;
		}
		
		double sum=0;
		for(int q =0; q< raceTime.size(); q++ )
		{
		sum = sum + raceTime.get(q);	
		}
		return (sum/raceTime.size());
	}

	public void addSP(String Price) {
		// TODO Auto-generated method stub
		if (startingPrice == 10)
		{
			startingPrice = Double.parseDouble(Price); 
		}
		
	}
	public double getSP( ) {
		// TODO Auto-generated method stub
		return startingPrice;
		
	}

	public void lastThreeFinishes(String finishPosition) {
		// TODO Auto-generated method stub
		if(threeFinishes.size()<4)
		{
			threeFinishes.add(Double.parseDouble(finishPosition));
		}
		
	}
	public double getLastThreeFinishes() {
		// TODO Auto-generated method stub
		
		double sum=0;
		if (threeFinishes.size()==0)
		{
			return 100;
		}
		for(int q =0; q< threeFinishes.size(); q++ )
		{
		sum = sum + threeFinishes.get(q);	
		}
		return (sum/threeFinishes.size());
	}

	public void distanceWins(String finishPosition) {
		// TODO Auto-generated method stub
		if(finishPosition.equals("1"))
		{
			
			winsAtDistance++;
		}
	}
	
	public int getDistanceWins() {
		// TODO Auto-generated method stub
		
			return winsAtDistance;
		
	}
	public void trackWins(String finishPosition) {
		// TODO Auto-generated method stub
		if(finishPosition.equals("1"))
		{
			
			winsAtTrack++;
		}
	}
	
	public int getTrackWins() {
		// TODO Auto-generated method stub
		
			return winsAtTrack;
		
	}

	public void giveWinPercentage(String string) {
		// TODO Auto-generated method stub
		winPercentage = Double.parseDouble(string);
		
	}

	public double getWinPercentage() {
		// TODO Auto-generated method stub
		
			return winPercentage;
		
	}
	public double getPlacePercentage() {
		// TODO Auto-generated method stub
		
			return placePercentage;
		
	}

	public void givePlacePercentage(String string) {
		// TODO Auto-generated method stub
		
		placePercentage = Double.parseDouble(string);
		
	}

	public void lastRun(String dateOfRace, String dateSlashes) {
		// TODO Auto-generated method stub
		
		if (runcount <1){
		lastRun=0;
		lastRun = (Double.parseDouble(dateSlashes.charAt(6)+""+dateSlashes.charAt(7)+""+dateSlashes.charAt(8)+dateSlashes.charAt(9))*365)- (Double.parseDouble(dateOfRace.charAt(6)+""+dateOfRace.charAt(7)+""+dateOfRace.charAt(8)+""+dateOfRace.charAt(9))*365);
		lastRun = lastRun +(Double.parseDouble(dateSlashes.charAt(3)+""+dateSlashes.charAt(4))*30)- (Double.parseDouble(dateOfRace.charAt(3)+""+dateOfRace.charAt(4))*30);
		lastRun = lastRun +Double.parseDouble(dateSlashes.charAt(0)+""+dateSlashes.charAt(1))- (Double.parseDouble(dateOfRace.charAt(0)+""+dateOfRace.charAt(1)));
		runcount++;
		}}
	
	public double getlastRun() {
		return lastRun;
		
		}
	
	
	public Double runningLane=(double) 0;
	public Double FT=(double) 0;
	public Double FST=(double) 0;
	public Double GA=(double) 0;
	public Double WAT=(double) 0;
	public Double LTF=(double) 0;
	public Double DW=(double) 0;
	public Double TF=(double) 0;
	public Double LR=(double) 0;
	public Double PRL=(double) 0;
	public Double StartP=(double) 0;
	public Double totalTicks =(double) 0;
	public Double TW=(double) 0;
	public Double TP=(double) 0;
	
		
	public double getLastRun() {
		return lastRun;
		// TODO Auto-generated method stub
		
		
		}
	public double getTW() {
		return TW;
		// TODO Auto-generated method stub
		
		
		}

	public double getFT() {
		// TODO Auto-generated method stub
		return FT;
	}

	public double getFST() {
		// TODO Auto-generated method stub
		return FST;
	}
	public double getGA() {
		// TODO Auto-generated method stub
		return GA;
	}

	public double getWAT() {
		// TODO Auto-generated method stub
		return WAT;
	}

	public double getLTF() {
		// TODO Auto-generated method stub
		return LTF;
	}

	public double getDW() {
		// TODO Auto-generated method stub
		return DW;
	}

	public double getLR() {
		// TODO Auto-generated method stub
		return LR;
	}

	public double getPRL() {
		// TODO Auto-generated method stub
		return PRL;
	}

	
	public double getTotalTicks() {
		// TODO Auto-generated method stub
		return totalTicks;
	}

	public void addSPP(double newSP) {
		// TODO Auto-generated method stub
		startingPrice = newSP; 
	}
	
	
}


	

	
	
		
		
	
