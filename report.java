import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class report {

	
	
	
	
	
	
	
	
	public static void go(String string, ArrayList<ObjectRACE> todaysRaces, double winMultiplyer) throws IOException {
		// TODO Auto-generated method stub
		
		 ArrayList<Double> winROI = new ArrayList<Double>();
		 
		 ArrayList<Double> placeROI = new ArrayList<Double>();
		 ArrayList<Double> quinellaROI = new ArrayList<Double>();
		 ArrayList<Double> trifectaROI = new ArrayList<Double>();
		 ArrayList<Double> firstFourROI = new ArrayList<Double>();
		 winROI.clear();
		 placeROI.clear();
		 
		String simpleDateHyphens = robot.simpleDateHyphens;
		 
		System.out.println("got to report");
		//try {
		
		
		    
		
			PrintWriter out = new PrintWriter(
					new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\" + simpleDateHyphens +string+ "WinReport.txt", true));
			//out.println(string+" Race Report " + simpleDateHyphens);
			//out.println();
			
			PrintWriter draw = new PrintWriter(
					new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\" + simpleDateHyphens +string+ "WindrawDown.txt"));
			
			PrintWriter winURL = new PrintWriter(
					new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\" + simpleDateHyphens +string+ "WindrawDown.txt"));
			
			
			
		/*	for(int q = 0; q< todaysRaces.size(); q++ )
			{try{if(todaysRaces.get(q).typeOfRace.equalsIgnoreCase(string)==true)
			{
				if(todaysRaces.get(q).WIN!=null&&todaysRaces.get(q).PLACE!=null)
				{
				out.println(todaysRaces.get(q).raceVenue + " "+todaysRaces.get(q).raceNumber);
				if(todaysRaces.get(q).WIN!=null)
				{out.println("Win: "+todaysRaces.get(q).WIN);}
				if(todaysRaces.get(q).PLACE!=null)
				{out.println("Place: "+todaysRaces.get(q).PLACE);}
				out.println("Runners:" + System.lineSeparator()+todaysRaces.get(q).firstPlace+ System.lineSeparator()+todaysRaces.get(q).secondPlace+ System.lineSeparator()+todaysRaces.get(q).thirdPlace);
				try{out.println(" "+todaysRaces.get(q).fourthPlace);}catch(Exception o){};
				}
				out.println();
			}
			}catch(Exception o){}
			}*/
		
		
			//out.println();out.println();out.println();
		
		
		
		
		
		/*
	
		for(int h = 0; h< todaysRaces.size();h++)
		{
			if(todaysRaces.get(h).typeOfRace.equalsIgnoreCase(string)==true)
			{
			
		if(todaysRaces.get(h).PLACE!=null)try{	
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true)
			{
				robot.todaysRaces.get(h).win = robot.todaysRaces.get(h).winDiv ;
			}
			
			winROI.add(robot.todaysRaces.get(h).win);
			
			if(todaysRaces.get(h).PLACE.equalsIgnoreCase(todaysRaces.get(h).secondPlace)==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			if(todaysRaces.get(h).dogs.size()>=8)
			{
			if(todaysRaces.get(h).PLACE.equalsIgnoreCase(todaysRaces.get(h).thirdPlace)==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}}
			
			if(todaysRaces.get(h).PLACE.equalsIgnoreCase(todaysRaces.get(h).firstPlace)==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			
			placeROI.add(todaysRaces.get(h).place);}catch(Exception w){}}
		
		
		
		}*/
for(int h = 0; h< todaysRaces.size();h++)
	
{
	
	if(todaysRaces.get(h).typeOfRace.equalsIgnoreCase(string)==true)
	{	
		if(todaysRaces.get(h).WIN!=null&&todaysRaces.get(h).WIN.equalsIgnoreCase("empty")==false)
		{
			
			try{	
			
				todaysRaces.get(h).win=0;
			if(todaysRaces.get(h).WIN.trim().equalsIgnoreCase(todaysRaces.get(h).firstPlace.trim())==true)
			{
				todaysRaces.get(h).win=todaysRaces.get(h).WINPAY ;
			//	winURL.println(todaysRaces.get(h).URL);
			}
			
			winROI.add(todaysRaces.get(h).win);
			}catch(Exception w){}}}
}
winURL.close();
			/*
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true)
				{robot.todaysRaces.get(h).quinella=robot.todaysRaces.get(h).quinellaDiv ;}
			}
			quinellaROI.add((robot.todaysRaces.get(h).quinella));
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
				{
					if(robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
			
			{trifectaROI.add((robot.todaysRaces.get(h).trifecta)/6);}
		}
		}
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
				{
					if(robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
			
			{
				if(robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
				firstFourROI.add((robot.todaysRaces.get(h).firstFour)/24);}}
		}
		}
		
	
	
	
		double count = 0;
		double sum = 0;
		for(int i = 0; i<winROI.size();i++)
		{
			sum = sum + winROI.get(i);
			if(winROI.get(i)>0)
			{count++;}
		}
		
		//make report
		out.println("Total Number of races: "+winROI.size());

		if(winROI.size()>0)
		{out.println("Win ROI: "+ (((sum-winROI.size()) / winROI.size())*100 )+ " win%: "+((count/winROI.size())*100));}
		*/
		
		double count = 0;
	double 	sum = 0;
		
		/*for(int i = 0; i<placeROI.size();i++)
		{
			sum = sum + placeROI.get(i);
			if(placeROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(placeROI.size()>0)
			
		{out.println("number of races: "+placeROI.size());
			out.println("Place ROI: "+ (((sum-placeROI.size()) / placeROI.size())*100 )+ " place%: "+((count/placeROI.size())*100)) ;}
		*/
		count = 0;
		sum = 0;
			
			for(int i = 0; i<winROI.size();i++)
			{
				if(winROI.get(i)==0)
				{
					draw.println("-1");
				}
				if(winROI.get(i)>0)
				{
					draw.println((winROI.get(i)-1));
				}
				sum = sum + winROI.get(i);
				if(winROI.get(i)>0)
				{count++;}
			}
			draw.close();
			
			//make report
			if(winROI.size()>0)
			
			
				
				
			{out.println("number of races: "+winROI.size()+" "+ winMultiplyer);
				out.println("Win ROI: "+ (((sum-winROI.size()) / winROI.size())*100 )+ " win%: "+((count/winROI.size())*100));}
				
		/*count = 0;
		sum = 0;
		for(int i = 0; i<quinellaROI.size();i++)
		{
			sum = sum + quinellaROI.get(i);
			if(quinellaROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(quinellaROI.size()>0)
		{out.println("Quinella ROI: "+ (((sum-quinellaROI.size()) / quinellaROI.size())*100 )+ " win%: "+((count/quinellaROI.size())*100));}
		count = 0;
		sum = 0;
		for(int i = 0; i<trifectaROI.size();i++)
		{
			sum = sum + trifectaROI.get(i);
			if(trifectaROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(trifectaROI.size()>0)
		{out.println("Trifecta ROI: "+ (((sum-trifectaROI.size()) / trifectaROI.size())*100 )+ " win%: "+((count/trifectaROI.size())*100));}
		count = 0;
		sum = 0;
		for(int i = 0; i<firstFourROI.size();i++)
		{
			sum = sum + firstFourROI.get(i);
			if(firstFourROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(firstFourROI.size()>0)
		{out.println("First Four ROI: "+ (((sum-firstFourROI.size()) / firstFourROI.size())*100 )+ " win%: "+((count/firstFourROI.size())*100));}
		
		*/
		
	//}catch(Exception o){}
		out.close();
}
	public static void goPlace(String string, ArrayList<ObjectRACE> todaysRaces, double placeMultiplyer) throws IOException {
		// TODO Auto-generated method stub
		
		 ArrayList<Double> winROI = new ArrayList<Double>();
		 ArrayList<Double> placeROI = new ArrayList<Double>();
		 ArrayList<Double> quinellaROI = new ArrayList<Double>();
		 ArrayList<Double> trifectaROI = new ArrayList<Double>();
		 ArrayList<Double> firstFourROI = new ArrayList<Double>();
		String simpleDateHyphens = robot.simpleDateHyphens;
		 winROI.clear();
		 placeROI.clear();
		 
		System.out.println("got to report");
		//try {
		
		
			PrintWriter out = new PrintWriter(
					new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\" + simpleDateHyphens +string+ "PlaceReport.txt", true));
			//out.println(string+" Race Report " + simpleDateHyphens);
			//out.println();
			
			PrintWriter draw = new PrintWriter(
					new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\" + simpleDateHyphens +string+ "PlacedrawDown.txt"));
			
			
			
			
			
		/*	for(int q = 0; q< todaysRaces.size(); q++ )
			{try{if(todaysRaces.get(q).typeOfRace.equalsIgnoreCase(string)==true)
			{
				if(todaysRaces.get(q).WIN!=null&&todaysRaces.get(q).PLACE!=null)
				{
				out.println(todaysRaces.get(q).raceVenue + " "+todaysRaces.get(q).raceNumber);
				if(todaysRaces.get(q).WIN!=null)
				{out.println("Win: "+todaysRaces.get(q).WIN);}
				if(todaysRaces.get(q).PLACE!=null)
				{out.println("Place: "+todaysRaces.get(q).PLACE);}
				out.println("Runners:" + System.lineSeparator()+todaysRaces.get(q).firstPlace+ System.lineSeparator()+todaysRaces.get(q).secondPlace+ System.lineSeparator()+todaysRaces.get(q).thirdPlace);
				try{out.println(" "+todaysRaces.get(q).fourthPlace);}catch(Exception o){};
				}
				out.println();
			}
			}catch(Exception o){}
			}*/
		
		
		//	out.println();out.println();out.println();
		
		
		
		
		
		
	
		for(int h = 0; h< todaysRaces.size();h++)
		{
			
			if(todaysRaces.get(h).typeOfRace.equalsIgnoreCase(string)==true)
			{
			
		if(todaysRaces.get(h).PLACE!=null&&todaysRaces.get(h).PLACE.equalsIgnoreCase("empty")==false)
		{
			
			
			try{	
			//System.out.println(todaysRaces.get(h).PLACE.trim()+" "+todaysRaces.get(h).firstPlace.trim()+" "+todaysRaces.get(h).secondPlace.trim()+" "+todaysRaces.get(h).thirdPlace.trim());
			if(todaysRaces.get(h).dogs.size()<8)
			{
			if(todaysRaces.get(h).PLACE.trim().equalsIgnoreCase(todaysRaces.get(h).firstPlace.trim())==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			
			
			if(todaysRaces.get(h).PLACE.trim().equalsIgnoreCase(todaysRaces.get(h).secondPlace.trim())==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}}
			
			
			
			if(todaysRaces.get(h).dogs.size()>=8)
			{
			if(todaysRaces.get(h).PLACE.trim().equalsIgnoreCase(todaysRaces.get(h).thirdPlace.trim())==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			
			if(todaysRaces.get(h).PLACE.trim().equalsIgnoreCase(todaysRaces.get(h).firstPlace.trim())==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			if(todaysRaces.get(h).PLACE.trim().equalsIgnoreCase(todaysRaces.get(h).secondPlace.trim())==true)
			{
				todaysRaces.get(h).place=todaysRaces.get(h).PLACEPAY ;
			}
			}
			placeROI.add(todaysRaces.get(h).place);
			}catch(Exception w){}
			}
			}
		
		
		
		}

			/*
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true)
				{robot.todaysRaces.get(h).quinella=robot.todaysRaces.get(h).quinellaDiv ;}
			}
			quinellaROI.add((robot.todaysRaces.get(h).quinella));
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
				{
					if(robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)==true)
			
			{trifectaROI.add((robot.todaysRaces.get(h).trifecta)/6);}
		}
		}
			
			if(robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(0).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
			{
				if(robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(1).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
				{
					if(robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(2).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
			
			{
				if(robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).firstPlace)==true||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).secondPlace)==true||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).thirdPlace)||robot.todaysRaces.get(h).dogs.get(3).boxNumber.equals(robot.todaysRaces.get(h).fourthPlace)==true)
				firstFourROI.add((robot.todaysRaces.get(h).firstFour)/24);}}
		}
		}
		
	
	
	
		double count = 0;
		double sum = 0;
		for(int i = 0; i<winROI.size();i++)
		{
			sum = sum + winROI.get(i);
			if(winROI.get(i)>0)
			{count++;}
		}
		
		//make report
		out.println("Total Number of races: "+winROI.size());

		if(winROI.size()>0)
		{out.println("Win ROI: "+ (((sum-winROI.size()) / winROI.size())*100 )+ " win%: "+((count/winROI.size())*100));}
		*/
		
		double count = 0;
	double 	sum = 0;
		
		for(int i = 0; i<placeROI.size();i++)
		{
		if(placeROI.get(i)==0)
				{
					draw.println("-1");
				}
				if(placeROI.get(i)>0)
				{
					draw.println((placeROI.get(i)-1));
				}
		
		
		
			sum = sum + placeROI.get(i);
			if(placeROI.get(i)>0)
			{count++;}
		}
		draw.close();
		
		//make report
		if(placeROI.size()>0)
			
		{out.println("number of races: "+placeROI.size()+ "  "+placeMultiplyer);
			out.println("Place ROI: "+ (((sum-placeROI.size()) / placeROI.size())*100 )+ " place%: "+((count/placeROI.size())*100));
			}
		
		
	
	
		/*count = 0;
		sum = 0;
		for(int i = 0; i<quinellaROI.size();i++)
		{
			sum = sum + quinellaROI.get(i);
			if(quinellaROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(quinellaROI.size()>0)
		{out.println("Quinella ROI: "+ (((sum-quinellaROI.size()) / quinellaROI.size())*100 )+ " win%: "+((count/quinellaROI.size())*100));}
		count = 0;
		sum = 0;
		for(int i = 0; i<trifectaROI.size();i++)
		{
			sum = sum + trifectaROI.get(i);
			if(trifectaROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(trifectaROI.size()>0)
		{out.println("Trifecta ROI: "+ (((sum-trifectaROI.size()) / trifectaROI.size())*100 )+ " win%: "+((count/trifectaROI.size())*100));}
		count = 0;
		sum = 0;
		for(int i = 0; i<firstFourROI.size();i++)
		{
			sum = sum + firstFourROI.get(i);
			if(firstFourROI.get(i)>0)
			{count++;}
		}
		
		//make report
		if(firstFourROI.size()>0)
		{out.println("First Four ROI: "+ (((sum-firstFourROI.size()) / firstFourROI.size())*100 )+ " win%: "+((count/firstFourROI.size())*100));}
		
		*/
		
	//}catch(Exception o){}
		out.close();
}
	
}
	
