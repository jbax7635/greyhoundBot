import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class robot {

	static WebDriver TabDriver;
	static WebDriver trainerDriver;
	static WebDriver dogsDriver;
	static WebDriver driver;
	static WebDriver driverette;
	static Double startBalance = 0.0;
	

	static ArrayList<tabRaces> raceArray;
	static ArrayList<String> lastRaceVenue;
	static ArrayList<String> trainers;
	static ArrayList<String> win;
	static ArrayList<String> place;
	static ArrayList<String> lastRaceNumber;
	static ArrayList<String> currentRaces;
	static ArrayList<String> locations = new ArrayList<String>();
	static ArrayList<String> locationsSymbol = new ArrayList<String>();
	static ArrayList<String> tabGrade = new ArrayList<String>();
	static ArrayList<String> dogsGrade = new ArrayList<String>();
	static int count = 0;
	static double remaining;
	static boolean racing = true;
	static int dogFaultCount = 0;
	static SimpleDateFormat twentyFourHourFormat = new SimpleDateFormat("mm");
	static SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
	static String hourTime;
	static String minuteTime;
	static boolean time = true;
	public static String simpleDateHyphens = "test";

	static ArrayList<ObjectRACE> todaysRaces;
	static ArrayList<ObjectRACE> bettingRaces = new ArrayList<ObjectRACE>();

	public static void main(String[] args) throws IOException {
		/*
		 * try { backTest.collectData(); } catch (ClassNotFoundException e2) {
		 * // TODO Auto-generated catch block e2.printStackTrace(); }
		 * 
		 * System.exit(0);
		 * 
		 * 
		 * 
		 * 
		 * //------------test current database against current stored
		 * probabilities(win and place with data) //makes complete obj
		 */
		//backTest.populateDatabase(); 
		//backTest.makeProbabilities();
		  //makes small obj 
		//backTest.makeSmallObj(); 
		//System.exit(0);
		//backTest.populateSmallDatabase();
		
		 /* 
		 * 
		 * 
		 */
		//System.out.println("1"); 
		//backTest.fillWithProbabilities();
		  //System.out.println("2");
		  
		  //double step=3; //for(int s=0;s<=30;s++){ //step=step-.1;
		
		 //double winMultiplyer = -.01; double placeMultiplyer=-.01;
		  
		 //for (int y=0;y<=100;y++) //{ 
		//placeMultiplyer=placeMultiplyer+.01;
		// winMultiplyer=winMultiplyer+.01; 
		//backTest.winBet(winMultiplyer);
		  //System.out.println("3");
		  
		// backTest.testAndReport(winMultiplyer); //System.out.println("4");
		// backTest.getTrackCondition();
		  
		//backTest.placeBet(placeMultiplyer);
		 //backTest.placeTestAndReport(placeMultiplyer); //} //
		 // System.exit(0);
		/* 
		 * 
		 * //backTest.makeProbabilities();
		 * 
		 * /*backTest.populateDatabase(); backTest.testAndReport();
		 * backTest.makeProbabilities(); backTest.bet();
		 * backTest.fillWithProbabilities();
		 * 
		 * //System.out.println("5"); System.exit(0); try {
		 * backTest.collectData(); } catch (ClassNotFoundException e2) { // TODO
		 * Auto-generated catch block e2.printStackTrace(); }
		 */
		for (int g = 0; g <= 100000; g++) {

			try {
				toop: for (int y = 0; y < 100; y++) {

					Calendar currentDate = Calendar.getInstance();

					minuteTime = twentyFourHourFormat.format(currentDate.getTime());
					double minute = Double.parseDouble(minuteTime);
					hourTime = hourFormat.format(currentDate.getTime());
					double hour = Double.parseDouble(hourTime);

					System.out.println(hour);
					if (hour < 7 || hour > 22) {
						try {
							Thread.sleep(3600000);

						} catch (Exception e) {
							Thread.currentThread().interrupt();
						}
					}
					if (hour >= 7 && hour <= 22) {
						break toop;
					}
				}
				startBalance = 0.0;

				/*
				 * profile.setPreference("browser.cache.disk.enable", false);
				 * profile.setPreference("browser.cache.memory.enable", false);
				 * profile.setPreference("browser.cache.offline.enable", false);
				 * profile.setPreference("network.http.use-cache", false);
				 * profile.setPreference("browser.ailprivate.browsing.autostart",
				 * true); //
				 * profile.setPreference("network.cookie.cookieBehavior", 2);
				 */
				// tab driver

				// dogsDriver = new FirefoxDriver(profile);
				// trainerDriver = new FirefoxDriver(profile);
				// trainer driver
				// driverette = new FirefoxDriver(profile);

				double totalMinutes = 0;

				Calendar currentDatee = Calendar.getInstance();
				SimpleDateFormat formatterForResultss = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateHyphens = formatterForResultss.format(currentDatee.getTime());

				lastRaceVenue = new ArrayList<String>();
				lastRaceNumber = new ArrayList<String>();
				todaysRaces = new ArrayList<ObjectRACE>();
				trainers = new ArrayList<String>();
				win = new ArrayList<String>();
				place = new ArrayList<String>();

				loop: for (int f = 0; f < 500; f++) {

					try {
						FirefoxProfile profile = new FirefoxProfile();
						profile.setPreference("webdriver.load.strategy", "unstable");
						profile.setPreference("dom.max_chrome_script_run_time", 0);
						profile.setPreference("dom.max_script_run_time", 0);
						profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
						profile.setPreference("startup.homepage_welcome_url.additional",  "about:blank");
						driver = new FirefoxDriver(profile);

						raceArray = new ArrayList<tabRaces>();

						System.out.println(todaysRaces.size()
								+ "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
						try {
							totalMinutes = initiate();

						} catch (Exception j) {
							j.printStackTrace();
							totalMinutes = 0;
						}

						// end day at certain time
						Calendar currentDate = Calendar.getInstance();
						minuteTime = twentyFourHourFormat.format(currentDate.getTime());
						double minute = Double.parseDouble(minuteTime);
						hourTime = hourFormat.format(currentDate.getTime());
						double hour = Double.parseDouble(hourTime);
						if (hour >= 0 && minute >= 0) {
							totalMinutes = 1.234;
						}

						/*
						 * if(totalMinutes>30) {
						 * 
						 * try { Thread.sleep((long)
						 * ((totalMinutes-10)*60*1000));
						 * 
						 * } catch (Exception e) {
						 * Thread.currentThread().interrupt(); } }
						 */
						boolean racesComplete = false;

						if (totalMinutes <= 120 && totalMinutes > 0) {

							for (int r = 0; r < currentRaces.size(); r++) {
								try {
									currentDate = Calendar.getInstance();
									minuteTime = twentyFourHourFormat.format(currentDate.getTime());
									minute = Double.parseDouble(minuteTime);
									hourTime = hourFormat.format(currentDate.getTime());
									hour = Double.parseDouble(hourTime);
									if (hour >= 23) {
										break;
									}
									driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
									driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
									driver.get(currentRaces.get(r));
								} catch (Exception k) {
									try {
										driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
										driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
										driver.get(currentRaces.get(r));
									} catch (Exception p) {
										driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
										driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
										driver.get(currentRaces.get(r));
									}
								}
								System.out.println(currentRaces.get(r));

								try {

									double refference = theRace();

									
									if (bettingRaces.size() > 0) {
										bet(bettingRaces);
									}

									if (r == (currentRaces.size() - 1)) {

										goop: for (int q = 0; q < 100000; q++) {
											
											if (bettingRaces.size() > 0) {
												bet(bettingRaces);
											}

											if (bettingRaces.size() == 0) {
												racesComplete = true;
												break goop;
											}
										}

									}

								} catch (Exception w) {
									w.printStackTrace();
									for (int q = 0; q < bettingRaces.size(); q++) {
										bettingRaces.get(q).raceDriver.close();
										bettingRaces.remove(q);

									}
									// totalMinutes = 0;
								}

							}
						}

						if (totalMinutes == 1.234) {

							for (int u = 0; u < 15; u++) {

								try {
									for (int q = 0; q < bettingRaces.size(); q++) {
										bettingRaces.get(q).raceDriver.close();

									}

									// for (String winHandle :
									// driver.getWindowHandles()) {
									// driver.switchTo().window(winHandle);
									driver.close();
									// }
								} catch (Exception i) {

								}

								try {
									// for (String winHandlee :
									// driver.getWindowHandles()) {
									// dogsDriver.switchTo().window(winHandlee);
									dogsDriver.close();
									// }
								} catch (Exception i) {

								}

								try {
									// for (String winHandleee :
									// driver.getWindowHandles()) {
									// driverette.switchTo().window(winHandleee);
									driverette.close();
									// }
								} catch (Exception i) {

								}

							}

							currentDate = Calendar.getInstance();
							minuteTime = twentyFourHourFormat.format(currentDate.getTime());
							minute = Double.parseDouble(minuteTime);
							hourTime = hourFormat.format(currentDate.getTime());
							hour = Double.parseDouble(hourTime);
							if (hour >= 24 || hour <= 7) {

								// report.go("Racing",robot.todaysRaces,winMultiplyer);
								// report.go("Harness",robot.todaysRaces,winMultiplyer);
								// report.go("Greyhounds",robot.todaysRaces,winMultiplyer);

								break loop;
							}
						}

					} catch (Exception l) {
						try{driver.close();}catch(Exception i){}

					}
				}

				for (int u = 0; u < 15; u++) {

					try {

						// for (String winHandle :
						// driver.getWindowHandles()) {
						// driver.switchTo().window(winHandle);
						driver.close();
						// }
					} catch (Exception i) {

					}

					try {
						// for (String winHandlee :
						// driver.getWindowHandles()) {
						// dogsDriver.switchTo().window(winHandlee);
						dogsDriver.close();
						// }
					} catch (Exception i) {

					}

					try {
						// for (String winHandleee :
						// driver.getWindowHandles()) {
						// driverette.switchTo().window(winHandleee);
						driverette.close();
						// }
					} catch (Exception i) {

					}

				}

				/*
				 * //to be deleted System.out.println(todaysRaces.size()
				 * +"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"
				 * ); if(robot.todaysRaces.size()>0) { try{ TAB.start();
				 * //atributeDevelopment.getAtributes();
				 * 
				 * atributeDevelopment.placePercentages();
				 * atributeDevelopment.winPercentages();
				 * //atributeDevelopment.PrintAtributes();
				 * 
				 * 
				 * System.exit(0); } catch(Exception s){s.printStackTrace();} }
				 */

			} catch (Exception k) {

			}
		}

	}

	public static void winProbabilitiesByRankAndPriceAndBox(ObjectRACE objectRACE) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		for (int r = 0; r < objectRACE.dogs.size(); r++) {
			int d = r + 1;
			ArrayList<Double> percentages = new ArrayList<Double>();
			// percentages.add(5.0);
			percentages.add(10.0);
			// percentages.add(15.0);
			percentages.add(20.0);
			//// percentages.add(25.0);
			percentages.add(30.0);
			// percentages.add(35.0);
			percentages.add(40.0);
			// percentages.add(45.0);
			percentages.add(50.0);
			// percentages.add(55.0);
			percentages.add(60.0);
			// percentages.add(65.0);
			percentages.add(70.0);
			// percentages.add(75.0);
			percentages.add(80.0);
			// percentages.add(85.0);
			percentages.add(90.0);
			// percentages.add(95.0);
			percentages.add(100.0);

			double winPercentage;

			winPercentage = (1 / objectRACE.dogs.get(r).winPay) * 100;
			int t;
			for (t = 0; t < percentages.size(); t++) {
				// System.out.println(t);
				if (winPercentage <= percentages.get(t)) {
					break;
				}
			}
int number=objectRACE.dogs.size()/2;
int size=number*2;



			double counts = 0;
			String[] arrays = null;
			String numbers = "0 0 0 0";
			double[] array = new double[5];

			try {

				DataInputStream dis = new DataInputStream(new FileInputStream(
						"c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + objectRACE.typeOfRace + "\\"
								+ size + "runners" + "\\" + "winProbabilitiesByRankAndPriceAndBox"
								+ "\\" + "rank" + d + "\\" + "box" + objectRACE.dogs.get(r).boxNumber + "\\"
								+ "percentage" + percentages.get(t) + ".txt"));

				numbers = dis.readLine();// + " " + dis.readLine();
				// System.out.println(numbers);
				dis.close();
				arrays = numbers.split(" ");
				counts = Double.parseDouble(arrays[4]);
				array[0] = Double.parseDouble(arrays[0]);
				array[1] = Double.parseDouble(arrays[1]);
				array[2] = Double.parseDouble(arrays[2]);
				array[3] = Double.parseDouble(arrays[3]);

			} catch (Exception o) {
				array[0] = 0.0;
				array[1] = 0;
				array[2] = 0;
				array[3] = 0;
				// o.printStackTrace();
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.firstPlace)) {
				array[0] = (array[0] * counts) + 1;
			} else {
				array[0] = (array[0] * counts);
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.secondPlace)) {
				array[1] = (array[1] * counts) + 1;
			} else {
				array[1] = (array[1] * counts);
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.thirdPlace)) {
				array[2] = (array[2] * counts) + 1;
			} else {
				array[2] = (array[2] * counts);
			}

			try {
				if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.fourthPlace)) {
					array[3] = (array[3] * counts) + 1;
				} else {
					array[3] = (array[3] * counts);
				}
			} catch (Exception u) {
			}

			counts++;

			File fileTwo = new File("c:\\users\\john\\desktop\\betagrays\\PricingprobabilitiesTest\\"
					+ objectRACE.typeOfRace + "\\" + size+ "runners" + "\\"
					+ "winProbabilitiesByRankAndPriceAndBox" + "\\" + "rank" + d + "\\" + "box"
					+ objectRACE.dogs.get(r).boxNumber + "\\" + "percentage" + percentages.get(t) + ".txt");
			fileTwo.getParentFile().mkdirs();
			PrintWriter outt = new PrintWriter(new FileWriter(fileTwo, true));

			File file = new File("c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + objectRACE.typeOfRace
					+ "\\" + size + "runners" + "\\" + "winProbabilitiesByRankAndPriceAndBox" + "\\"
					+ "rank" + d + "\\" + "box" + objectRACE.dogs.get(r).boxNumber + "\\" + "percentage"
					+ percentages.get(t) + ".txt");
			file.getParentFile().mkdirs();
			PrintWriter out = new PrintWriter(new FileWriter(file));
			double countss = counts;
			if (counts > 10) {
				countss = 10;
			}

			out.print(array[0] / counts + " " + array[1] / counts + " " + array[2] / counts + " " + array[3] / counts
					+ " " + counts);
			outt.println(array[0] / counts + " " + array[1] / counts + " " + array[2] / counts + " " + array[3] / counts
					+ " " + countss + " ");

			outt.close();
			out.close();

			// System.out.println(winPercentage+" winPercntage");

		}

	}

	public static void positionalProbabilitiesByrank(ObjectRACE objectRACE) throws IOException {
		// TODO Auto-generated method stub
		objectRACE.positioningComplete = true;
		double counts = 0;

		double t = 1;
		double p = 0;

		ArrayList<ArrayList<ArrayList<Double>>> dogs = new ArrayList<ArrayList<ArrayList<Double>>>();

		ArrayList<ArrayList<Double>> dogOne = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogTwo = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogThree = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogFour = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogFive = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogSix = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogSeven = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogEight = new ArrayList<ArrayList<Double>>();

		dogs.add(dogOne);
		dogs.add(dogTwo);
		dogs.add(dogThree);
		dogs.add(dogFour);
		dogs.add(dogFive);
		dogs.add(dogSix);
		dogs.add(dogSeven);
		dogs.add(dogEight);

		int number = 0;
		if (objectRACE.dogs.size() < 8) {
			number = objectRACE.dogs.size();

		}
		if (objectRACE.dogs.size() >= 8) {
			number = 8;
		}

		for (int i = 0; i < number; i++) {

			ArrayList<Double> first = new ArrayList<Double>();
			ArrayList<Double> second = new ArrayList<Double>();
			ArrayList<Double> third = new ArrayList<Double>();
			ArrayList<Double> fourth = new ArrayList<Double>();

			// System.out.println(objectRACE.dogs.get(i).getName());
			// System.out.println((objectRACE.firstPlace));

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.firstPlace)) == true)) {

				first.add(t);
			} else {

				first.add(p);
			}

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.secondPlace)) == true)) {
				second.add(t);
			} else {
				second.add(p);
			}

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.thirdPlace)) == true)) {
				third.add(t);
			} else {
				third.add(p);
			}

			try {
				if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.fourthPlace)) == true)) {
					fourth.add(t);
				} else {
					fourth.add(p);
				}
			} catch (Exception d) {
			}

			dogs.get(i).add(first);
			dogs.get(i).add(second);
			dogs.get(i).add(third);
			dogs.get(i).add(fourth);

		}
		double placeNumber = 0;

		for (int r = 0; r < number; r++) {
			String[] arrays = null;
			String numbers = "0 0 0 0";
			double[] array = new double[5];
			try {
				try {

					DataInputStream dis = new DataInputStream(
							new FileInputStream("c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\"
									+ objectRACE.typeOfRace + "\\" + objectRACE.dogs.size() + "runners" + "\\"
									+ "positionalProbabilitiesByrank" + "\\" + (r + 1) + ".txt"));
					numbers = dis.readLine();// + " " + dis.readLine();
					// System.out.println(numbers);
					dis.close();
					arrays = numbers.split(" ");
					counts = Double.parseDouble(array[4]);
					placeNumber = counts;

				} catch (Exception o) {
					array[0] = 0;
					array[1] = 0;
					array[2] = 0;
					array[3] = 0;
					// o.printStackTrace();
				}

				File file = new File("c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\"
						+ objectRACE.typeOfRace + "\\" + objectRACE.dogs.size() + "runners" + "\\"
						+ "positionalProbabilitiesByrank" + "\\" + (r + 1) + ".txt");
				file.getParentFile().mkdirs();
				PrintWriter out = new PrintWriter(new FileWriter(file));

				out.println((((getAverage(dogs.get(r).get(0))) + (Double.parseDouble(array[0]) * placeNumber))
						/ (1 + placeNumber))
						+ " "
						+ (((getAverage(dogs.get(r).get(1))) + (Double.parseDouble(array[1]) * placeNumber))
								/ (1 + placeNumber))
						+ " "
						+ (((getAverage(dogs.get(r).get(2))) + (Double.parseDouble(array[2]) * placeNumber))
								/ (1 + placeNumber))
						+ " " + ((((getAverage(dogs.get(r).get(3)))) + (Double.parseDouble(array[3]) * placeNumber))
								/ (1 + placeNumber))
						+ " " + (counts + 1));

				out.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		// TODO Auto-generated method stub

	}

	public static void winProbabilitiesByRankAndPrice(ObjectRACE objectRACE) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		for (int r = 0; r < objectRACE.dogs.size(); r++) {
			ArrayList<Double> percentages = new ArrayList<Double>();
			int d = r + 1;
			// percentages.add(5.0);
			percentages.add(10.0);
			// percentages.add(15.0);
			percentages.add(20.0);
			//// percentages.add(25.0);
			percentages.add(30.0);
			// percentages.add(35.0);
			percentages.add(40.0);
			// percentages.add(45.0);
			percentages.add(50.0);
			// percentages.add(55.0);
			percentages.add(60.0);
			// percentages.add(65.0);
			percentages.add(70.0);
			// percentages.add(75.0);
			percentages.add(80.0);
			// percentages.add(85.0);
			percentages.add(90.0);
			// percentages.add(95.0);
			percentages.add(100.0);

			double winPercentage;
			// System.out.println(objectRACE.dogs.get(r).winPay);
			winPercentage = (1 / objectRACE.dogs.get(r).winPay) * 100;
			int t;
			for (t = 0; t < percentages.size(); t++) {
				// System.out.println(t+"t");
				// System.out.println("winPercentage "+winPercentage+"
				// percentages "+percentages.get(t));
				if (winPercentage <= percentages.get(t)) {
					break;
				}
			}
			int number=objectRACE.dogs.size()/2;
			int size=number*2;
			double counts = 0;
			String[] arrays = null;
			String numbers = "0 0 0 0";
			double[] array = new double[5];

			try {

				DataInputStream dis = new DataInputStream(new FileInputStream(
						"c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + objectRACE.typeOfRace + "\\"
								+ size + "runners" + "\\" + "winProbabilitiesByRankAndPrice" + "\\"
								+ "rank" + (d) + "percentage" + percentages.get(t) + ".txt"));
				numbers = dis.readLine();// + " " + dis.readLine();
				// System.out.println(numbers);
				dis.close();
				arrays = numbers.split(" ");
				counts = Double.parseDouble(arrays[4]);
				array[0] = Double.parseDouble(arrays[0]);
				array[1] = Double.parseDouble(arrays[1]);
				array[2] = Double.parseDouble(arrays[2]);
				array[3] = Double.parseDouble(arrays[3]);

			} catch (Exception o) {
				array[0] = 0.0;
				array[1] = 0;
				array[2] = 0;
				array[3] = 0;
				// o.printStackTrace();
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.firstPlace)) {
				array[0] = (array[0] * counts) + 1;
			} else {
				array[0] = (array[0] * counts);
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.secondPlace)) {
				array[1] = (array[1] * counts) + 1;
			} else {
				array[1] = (array[1] * counts);
			}

			if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.thirdPlace)) {
				array[2] = (array[2] * counts) + 1;
			} else {
				array[2] = (array[2] * counts);
			}

			try {
				if (objectRACE.dogs.get(r).getName().trim().equalsIgnoreCase(objectRACE.fourthPlace)) {
					array[3] = (array[3] * counts) + 1;
				} else {
					array[3] = (array[3] * counts);
				}
			} catch (Exception u) {
			}

			counts++;

			File file = new File("c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + objectRACE.typeOfRace
					+ "\\" + size + "runners" + "\\" + "winProbabilitiesByRankAndPrice" + "\\"
					+ "rank" + (d) + "percentage" + percentages.get(t) + ".txt");
			file.getParentFile().mkdirs();
			PrintWriter out = new PrintWriter(new FileWriter(file));

			out.print(array[0] / counts + " " + array[1] / counts + " " + array[2] / counts + " " + array[3] / counts
					+ " " + counts);

			out.close();

			// System.out.println(winPercentage+" winPercntage");

		}
	}

	private static void positioning(ObjectRACE objectRACE, String string, int size) throws IOException {
		// TODO Auto-generated method stub
		objectRACE.positioningComplete = true;
		double counts = 0;
		try {
			try {
				DataInputStream diss = new DataInputStream(
						new FileInputStream("c:\\users\\john\\desktop\\betagrays\\outcomeProbabilty\\"
								+ objectRACE.typeOfRace + "\\" + string + "\\" + objectRACE.raceVenue
								+ objectRACE.distanceOfRace + size + "count" + ".txt"));
				counts = Double.parseDouble(diss.readLine());// + " " +
																// dis.readLine();
				diss.close();
			} catch (NullPointerException j) {
				// j.printStackTrace();
			}
		} catch (FileNotFoundException u) {
			u.printStackTrace();
		}

		try {
			PrintWriter outt = new PrintWriter(new FileWriter(
					"c:\\users\\john\\desktop\\betagrays\\outcomeProbabilty\\" + objectRACE.typeOfRace + "\\" + string
							+ "\\" + objectRACE.raceVenue + objectRACE.distanceOfRace + size + "count" + ".txt"));
			double run = (counts + 1);
			outt.print(run);
			outt.close();
		} catch (Exception j) {
			// j.printStackTrace();
		}
		double t = 1;
		double p = 0;

		ArrayList<ArrayList<ArrayList<Double>>> dogs = new ArrayList<ArrayList<ArrayList<Double>>>();

		ArrayList<ArrayList<Double>> dogOne = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogTwo = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogThree = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogFour = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogFive = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogSix = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogSeven = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> dogEight = new ArrayList<ArrayList<Double>>();

		dogs.add(dogOne);
		dogs.add(dogTwo);
		dogs.add(dogThree);
		dogs.add(dogFour);
		dogs.add(dogFive);
		dogs.add(dogSix);
		dogs.add(dogSeven);
		dogs.add(dogEight);

		int number = 0;
		if (objectRACE.dogs.size() < 8) {
			number = objectRACE.dogs.size();

		}
		if (objectRACE.dogs.size() >= 8) {
			number = 8;
		}

		for (int i = 0; i < number; i++) {

			ArrayList<Double> first = new ArrayList<Double>();
			ArrayList<Double> second = new ArrayList<Double>();
			ArrayList<Double> third = new ArrayList<Double>();
			ArrayList<Double> fourth = new ArrayList<Double>();

			System.out.println(objectRACE.dogs.get(i).getName());
			System.out.println((objectRACE.firstPlace));

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.firstPlace)) == true)) {
				first.add(t);
			} else {
				first.add(p);
			}

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.secondPlace)) == true)) {
				second.add(t);
			} else {
				second.add(p);
			}

			if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.thirdPlace)) == true)) {
				third.add(t);
			} else {
				third.add(p);
			}

			try {
				if (((objectRACE.dogs.get(i).getName().equalsIgnoreCase(objectRACE.fourthPlace)) == true)) {
					fourth.add(t);
				} else {
					fourth.add(p);
				}
			} catch (Exception d) {
			}

			dogs.get(i).add(first);
			dogs.get(i).add(second);
			dogs.get(i).add(third);
			dogs.get(i).add(fourth);

		}
		double placeNumber = counts;

		for (int r = 0; r < number; r++) {
			String[] array;
			String numbers = "0 0 0 0";
			try {
				try {

					DataInputStream dis = new DataInputStream(
							new FileInputStream("c:\\users\\john\\desktop\\betagrays\\outcomeProbabilty\\"
									+ objectRACE.typeOfRace + "\\" + string + "\\" + objectRACE.raceVenue
									+ objectRACE.distanceOfRace + size + r + ".txt"));
					numbers = dis.readLine();// + " " + dis.readLine();
					// System.out.println(numbers);
					dis.close();

				} catch (Exception o) {
					o.printStackTrace();
				}

				array = numbers.split(" ");

				PrintWriter out = new PrintWriter(
						new FileWriter("c:\\users\\john\\desktop\\betagrays\\outcomeProbabilty\\"
								+ objectRACE.typeOfRace + "\\" + string + "\\" + objectRACE.raceVenue
								+ objectRACE.distanceOfRace + size + r + ".txt"));

				out.println((((getAverage(dogs.get(r).get(0))) + (Double.parseDouble(array[0]) * placeNumber))
						/ (1 + placeNumber))
						+ " "
						+ (((getAverage(dogs.get(r).get(1))) + (Double.parseDouble(array[1]) * placeNumber))
								/ (1 + placeNumber))
						+ " "
						+ (((getAverage(dogs.get(r).get(2))) + (Double.parseDouble(array[2]) * placeNumber))
								/ (1 + placeNumber))
						+ " " + ((((getAverage(dogs.get(r).get(3)))) + (Double.parseDouble(array[3]) * placeNumber))
								/ (1 + placeNumber)));

				out.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	private static double getAverage(ArrayList<Double> one) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int d = 0; d < one.size(); d++) {
			sum = sum + one.get(d);
		}
		System.out.println(sum / one.size());
		return ((sum / one.size()));
	}

	private static double initiate() throws IOException {
		try {
			try {
				driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://www.google.com.au");
				driver.get("https://www.tab.com.au/racing/meetings/today/G");
			} catch (Exception u) {
				try {
					driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					driver.get("https://www.google.com.au");
					driver.get("https://www.tab.com.au/racing/meetings/today/G");
				} catch (Exception f) {
					driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					driver.get("https://www.google.com.au");
					driver.get("https://www.tab.com.au/racing/meetings/today/G");
				}
			}

			WebDriverWait twaitt = new WebDriverWait(driver, 60);
			WebDriverWait twaitttt = new WebDriverWait(driver, 4);
			
			try {
				twaitttt.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
			} catch (Exception k) {

			}
			
			
			WebDriverWait twait = new WebDriverWait(driver, 60);
			twait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
			
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// twait.until(ExpectedConditions
			// .visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")));
			/*
			driver.navigate().refresh();
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
			*/
			
			// driver.get("https://www.tab.com.au/racing/meetings/today/G");

			// twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			// "html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[2]/div[1]/span[1]")));

			ArrayList<String> urlArray = new ArrayList<String>();
			urlArray.add("https://www.tab.com.au/racing/meetings/today/G");
			urlArray.add("https://www.tab.com.au/racing/meetings/today/R");
			urlArray.add("https://www.tab.com.au/racing/meetings/today/H");
			for (int u = 0; u < urlArray.size(); u++) {

				try {
					driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
					driver.get(urlArray.get(u));
				} catch (Exception k) {
					try {
						driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
						driver.get(urlArray.get(u));
					} catch (Exception f) {
						driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
						driver.get(urlArray.get(u));
					}
				}

				WebDriverWait twaittt = new WebDriverWait(driver, 4);
				try {
					twaittt.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
				} catch (Exception k) {

				}
				twaitt.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));

				// twaitt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				// "html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[2]/div[1]/span[1]")));

				for (int e = 1; e <= 25; e++) {

					for (int r = 1; r <= 15; r++) {
						try {
							tabRaces currentRace = new tabRaces();
							String state = ((driver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[3]/div/div[1]/span["
											+ e + "]/span"))).getText().replace("(", "").replace(")", "").trim());

							currentRace.raceVenue = ((driver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[3]/div/div[1]/span["
											+ e + "]/em"))).getText());
							currentRace.raceNumber = ((driver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[3]/div/div[2]/div["
											+ e + "]/race-brief[" + r + "]/a/span[1]"))).getText().replace("R", ""));
							String text = ((driver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[3]/div/div[2]/div["
											+ e + "]/race-brief[" + r + "]/a/time[2]/span"))).getText().replace("R",
													""));
							currentRace.raceXpath = "html/body/ui-view/main/div[1]/ui-view/div/ui-view/ui-view/ui-view/section/div/div[3]/div/div[2]/div["
									+ e + "]/race-brief[" + r + "]/a";
							currentRace.URL = driver.findElement(By.xpath(currentRace.raceXpath)).getAttribute("href");

							double minutes = 0;
							String[] array = text.split(" ");

							for (int i = 0; i < array.length; ++i) {
								try {
									if ((array[i].charAt(array[i].length() - 1) + "").equals("m")) {
										minutes = minutes + Double.parseDouble(array[i].replace("m", ""));
									}
								} catch (Exception q) {
									q.getStackTrace();
									;
								}

								try {
									if ((array[i].charAt(array[i].length() - 1) + "").equals("h")) {
										minutes = minutes + ((Double.parseDouble(array[i].replace("h", ""))) * 60);
										if (minutes == 0) {
											minutes++;
										}
									}
								} catch (Exception h) {
									h.printStackTrace();
								}
							}

							currentRace.timeRemaining = minutes;
							if (state.equalsIgnoreCase("nsw") || state.equalsIgnoreCase("vic")
									|| state.equalsIgnoreCase("tas") || state.equalsIgnoreCase("qld")
									|| state.equalsIgnoreCase("WA") || state.equalsIgnoreCase("nzl")
									|| state.equalsIgnoreCase("SA")) {
								raceArray.add(currentRace);
							}

						} catch (Exception o) {// o.printStackTrace();

						}

					}

				}
			}

			if (raceArray.size() == 0) {

				return 0;
			}

			Calendar currentDate = Calendar.getInstance();
			String minuteTimee = twentyFourHourFormat.format(currentDate.getTime());
			double minute = Double.parseDouble(minuteTimee);

			String hourTimee = hourFormat.format(currentDate.getTime());
			double hour = Double.parseDouble(hourTimee);
			if (hour == 0 && minute >= 30) {
				return 0;
			}

			Collections.sort(raceArray, tabRaces.timeOrder);

			currentRaces = new ArrayList<String>();
			double number = 0;
			double w = 0;
			for (int p = 0; p < raceArray.size(); p++) {

				boolean check = false;
				for (int t = 0; t < lastRaceVenue.size(); t++) {
					if ((raceArray.get(p).raceNumber.equals(lastRaceNumber.get(t))) == true
							&& (raceArray.get(p).raceVenue.equals(lastRaceVenue.get(t))) == true) {
						check = true;
						break;
					}
				}

				if ((raceArray.get(p).timeRemaining > 2 && raceArray.get(p).timeRemaining < 60 && check == false)) {
					lastRaceVenue.add(raceArray.get(p).raceVenue);
					lastRaceNumber.add(raceArray.get(p).raceNumber);

					if (w == 0) {
						number = raceArray.get(p).timeRemaining;

						w++;
					}

					currentRaces.add(raceArray.get(p).URL);

					// System.out.println(raceArray.get(p).timeRemaining);

					/*
					 * if (todaysRaces.size() > 0) { number = 0; }
					 * 
					 * break;
					 */

				}
			}
			for (int r = 0; r < currentRaces.size(); r++) {
				System.out.println(currentRaces.get(r));
			}
			return number;

		} catch (Exception q) {
			q.printStackTrace();
			return 0;
		}
	}

	private static double theRace() throws IOException {
		// TODO Auto-generated method stub

		WebDriverWait twait = new WebDriverWait(driver, 4);
		WebDriverWait twwait = new WebDriverWait(driver, 60);
		boolean tipsComplete = true;
		try {
			twait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
		} catch (Exception k) {
		}
		twwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
		

		ObjectRACE currentRace = new ObjectRACE();

		

		twait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[1]/div[1]/div/div/div[1]")));
		twait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[2]/div[1]")));
		

		currentRace.raceNumber = driver
				.findElement(By 
						.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[2]/div[1]"))
				.getText().replace("R", "");

		currentRace.typeOfRace = driver.findElement(
				By.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[1]/div[1]/div/div/div[1]"))

		.getText();

		currentRace.raceVenue = (driver
				.findElement(By
						.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[1]/div[1]/div/div/div[2]"))
				.getText());

		currentRace.URL = driver.getCurrentUrl();
		/*
		 * String grade = (driver .findElement(By .xpath(
		 * "html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[3]/ul/li[3]"
		 * )) .getText());
		 * 
		 * 
		 * for (int y = 0; y < tabGrade.size(); y++) { if
		 * (tabGrade.get(y).equalsIgnoreCase(grade)) { currentRace.gradeOfRace =
		 * dogsGrade.get(y); } }
		 */

		currentRace.distanceOfRace = (driver
				.findElement(By
						.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[3]/ul/li[2]"))
				.getText()).replace("m", "").replace("|", "");

		for (int l = 1; l <= 20; l++) {
			try {

				if (((driver.findElement(By
						.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[7]"))).getText()).equals("SCR") == false) {
						
					if (((driver.findElement(By
							.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[7]"))).getText()).equals("(L)SCR") == false) {

						String name = driver
								.findElement(By
										.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[2]/div/div/div"))
								.getText().replace(")", "").replace("(", "").trim();
						// System.out.println(name.replaceAll("\\d",""));
						// System.out.println(name);
						// System.out.println("printed");
						ObjectDOG currentDog = new ObjectDOG(name.replaceAll("\\d", "").trim());
						try {
							double number = Double.parseDouble(name.charAt(name.length() - 1) + "") / 2;
							currentDog.boxNumber = name.replaceAll("[^\\d.]", "");
							;
						} catch (Exception x) {
							currentDog.boxNumber = driver.findElement(By
									.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
											+ l + "]/div[1]"))
									.getText();
						}

						// System.out.println(currentRace.typeOfRace);

						if (currentRace.typeOfRace.equalsIgnoreCase("harness") == true) {
							currentDog.boxNumber = (driver.findElement(By
									.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
											+ l + "]/div[1]"))
									.getText());
						}

						if (currentRace.typeOfRace.equalsIgnoreCase("greyhounds")) {
							try {					
								currentDog.winxpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[5]";
								// System.out.println(currentDog.winPay);
								
								currentDog.placexpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[6]";

								// System.out.println(currentDog.placePay);

							} catch (Exception f) {// System.out.println("race
													// removed");//f.printStackTrace();
							}
						}

						if (currentRace.typeOfRace.equalsIgnoreCase("racing")) {
							try {
								currentDog.winxpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[6]";
								// System.out.println(currentDog.winPay);
								
								currentDog.placexpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[7]";


								// System.out.println(currentDog.placePay);

							} catch (Exception f) {// System.out.println("race
													// removed");//f.printStackTrace();
							}
						}

						if (currentRace.typeOfRace.equalsIgnoreCase("harness")) {
							try {
								currentDog.winxpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[5]";
								// System.out.println(currentDog.winPay);
								
								currentDog.placexpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[6]";


								// System.out.println(currentDog.placePay);

							} catch (Exception f) {// System.out.println("race
													// removed");//f.printStackTrace();
							}
						}

						

						if (currentRace.typeOfRace.equalsIgnoreCase("racing") == true) {
							
							currentDog.winxpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[6]";
							// System.out.println(currentDog.winPay);
							
							currentDog.placexpath = "/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["+l+"]/div[7]";


						}

						// System.out.println(name + " " +
						// currentDog.boxNumber);

						currentRace.dogs.add(currentDog);

					}
				}
			} catch (Exception j) {

			}

		}

		// System.out.println(currentRace.dogs.get(y).placeChance);
		// System.out.println(currentRace.dogs.get(y).winChance);
		double count = 0;

		/*
		 * if(count>0){ Collections.sort(currentRace.dogs,
		 * ObjectDOG.FIXEDODDPLACEPRICE); fillRaceWithOdds(currentRace); }
		 */

		bettingRaces.add(currentRace);

		/*
		 * if (count >=
		 * 80&&currentRace.typeOfRace.equalsIgnoreCase("greyhounds"))
		 * 
		 * { fillRaceWithOdds(currentRace); bettingRaces.add(currentRace); }
		 * 
		 * if (count >= 50&&currentRace.typeOfRace.equalsIgnoreCase("racing"))
		 * 
		 * { fillRaceWithOdds(currentRace); bettingRaces.add(currentRace); }
		 * 
		 * if (count >= 50&&currentRace.typeOfRace.equalsIgnoreCase("harness"))
		 * 
		 * { fillRaceWithOdds(currentRace); bettingRaces.add(currentRace); }
		 */

		todaysRaces.add(currentRace);

		return 100;

	}

	public static void fillRaceWithOdds(ObjectRACE currentRace) throws IOException {
		// TODO Auto-generated method stub
		// System.out.println("method entered");
		/// need to find a way to fill races with odds

		int number = currentRace.dogs.size();

		foop: for (int i = 0; i < number; ++i) {
			ArrayList<Double> percentages = new ArrayList<Double>();
			percentages.add(5.0);
			percentages.add(10.0);
			percentages.add(15.0);
			percentages.add(20.0);
			percentages.add(25.0);
			percentages.add(30.0);
			percentages.add(35.0);
			percentages.add(40.0);
			percentages.add(45.0);
			percentages.add(50.0);
			percentages.add(55.0);
			percentages.add(60.0);
			percentages.add(65.0);
			percentages.add(70.0);
			percentages.add(75.0);
			percentages.add(80.0);
			percentages.add(85.0);
			percentages.add(90.0);
			percentages.add(95.0);
			percentages.add(100.0);

			double winPercentage;

			winPercentage = (1 / currentRace.dogs.get(i).winPay) * 100;
			int t;
			for (t = 0; t < percentages.size(); t++) {
				// System.out.println(t);
				if (winPercentage <= percentages.get(t)) {
					break;
				}
			}

			DataInputStream dis;

			int d = i + 1;
			try {
				dis = new DataInputStream(new FileInputStream(
						"c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + currentRace.typeOfRace + "\\"
								+ currentRace.dogs.size() + "runners" + "\\" + "winProbabilitiesByRankAndPriceAndBox"
								+ "\\" + "rank" + d + "\\" + "box" + currentRace.dogs.get(i).boxNumber + "\\"
								+ "percentage" + percentages.get(t) + ".txt"));
			} catch (Exception k) {
				break foop;
			}
			String numbers = dis.readLine();// + " " + dis.readLine();
			dis.close();
			String[] array = numbers.split(" ");
			// System.out.println("file read");

			if (Double.parseDouble(array[0]) == 0) {
				currentRace.dogs.remove(i);
				break foop;
			}

			if (currentRace.dogs.size() >= 8) {
				// System.out.println("loop entered");

				// handle inputInteger here...
				currentRace.dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
						+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]) + Double.parseDouble(array[3]);
				currentRace.dogs.get(i).trifectaPercentage = Double.parseDouble(array[0]) + Double.parseDouble(array[1])
						+ Double.parseDouble(array[2]);
				currentRace.dogs.get(i).placePercentage = Double.parseDouble(array[0]) + Double.parseDouble(array[1])
						+ Double.parseDouble(array[2]);
				currentRace.dogs.get(i).winPercentage = Double.parseDouble(array[0]);
			}

			if (currentRace.dogs.size() < 8) {

				// handle inputInteger here...
				currentRace.dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
						+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]) + Double.parseDouble(array[3]);
				currentRace.dogs.get(i).trifectaPercentage = Double.parseDouble(array[0]) + Double.parseDouble(array[1])
						+ Double.parseDouble(array[2]);
				currentRace.dogs.get(i).placePercentage = Double.parseDouble(array[0]) + Double.parseDouble(array[1]);
				currentRace.dogs.get(i).winPercentage = Double.parseDouble(array[0]);
			}

		}

	}

	public static void bet(ArrayList<ObjectRACE> races) throws IOException {
		// TODO Auto-generated method stub

		for (int t = 0; t < races.size(); t++) {
			if (races.get(t).webDriverPresence == false) {
				System.out.println("getting into loop");
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("webdriver.load.strategy", "unstable");
				profile.setPreference("dom.max_chrome_script_run_time", 0);
				profile.setPreference("dom.max_script_run_time", 0);
				races.get(t).raceDriver = new FirefoxDriver(profile);
				System.out.println("gettingdriver");
				races.get(t).raceDriver.get(races.get(t).URL);
				races.get(t).webDriverPresence = true;

				WebDriverWait twait = new WebDriverWait(races.get(t).raceDriver, 60);
				try {

					twait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[3]/ul/li[1]/time/span")));
				} catch (Exception u) {
					u.printStackTrace();
				}
				/*double H;
				try {

					H = Double.parseDouble((races.get(t).raceDriver
							.findElement(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")).getText())
									.replace("$", ""));

					double f = H / 2;

				} catch (Exception e) {
					login(races.get(t).raceDriver);
				}*/
			}

		}

		do {
			

			for (int w = 0; w < races.size(); w++) {
				try{
				goop:{
				
				String[] url =null;
				 url = races.get(w).URL.split("/");
				 String[] date=null;
				 date=url[4].split("-");
				 String dateString = date[2]+"/"+date[1]+"/"+date[0];		
	DateFormat formatter ; 
	java.util.Date theDate = null ; 
	   formatter = new SimpleDateFormat("dd/MM/yyyy");
	   try {
		theDate = formatter.parse(dateString);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 Calendar c = Calendar.getInstance();
				 c.setTime(theDate);
				 int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				// System.out.println(dayOfWeek);
				 
				 
				 
				 String txt=null;
				
				WebDriverWait ttwait = new WebDriverWait(races.get(w).raceDriver, 6);
				try{								
					ttwait.until(ExpectedConditions	
						.visibilityOfElementLocated(By.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[3]/ul/li[1]/time/span")));
					 txt = races.get(w).raceDriver
							.findElement(By
									.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[3]/ul/li[1]/time/span"))
							.getText().trim();
				}catch(Exception k){
					
					
					
					
					 txt = races.get(w).raceDriver
							.findElement(By
									.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div/div[3]/ul/li[1]"))
							.getText().trim();
				}
					System.out.println(txt);
				
				double time = 15;
				if(races.get(w).typeOfRace.equalsIgnoreCase("greyhounds"))
				{
					time=10;
				}
				
				if (txt.length() == 3 && txt.charAt(2) == 'm'
						&& Double.parseDouble(txt.charAt(0)+""+txt.charAt(1)) == time) {
					if(races.get(w).teirOneError==true){
					races.get(w).teirOneError=false;
					for (int y = 0; y < races.get(w).dogs.size(); y++) {
						if((races.get(w).raceDriver
														.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText()).equalsIgnoreCase("(L)SCR")==false||races.get(w).raceDriver
														.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText().equalsIgnoreCase("SCR")==false)
						{
							
try{System.out.println("Entered---------------------------------------------------------");
												races.get(w).dogs.get(y).addSP((races.get(w).raceDriver
														.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText()));}catch(Exception g){g.printStackTrace();}
System.out.println(races.get(w).dogs.get(y).getSP());
												}
						else{
							races.get(w).dogs.remove(y);
							y--;
											} }
					
					
				}}
				int go=0;
			
				if (txt.length() == 3 && txt.charAt(2) == 's'&& txt.charAt(0) == '-'
						&& Double.parseDouble(txt.charAt(1)+"" ) <= 60) {go=1;}
				
				if (txt.length() == 4 && txt.charAt(3) == 's'&& txt.charAt(0) == '-'
						&& Double.parseDouble(txt.charAt(1)+""+txt.charAt(2) ) <= 60) {go=1;}

				if (txt.length() == 2 && txt.charAt(1) == 's'
						&& Double.parseDouble(txt.charAt(0)+"" ) <= 60) {go=1;}
				
				if (txt.length() == 3 && txt.charAt(2) == 's'
						&& Double.parseDouble(txt.charAt(0)+""+txt.charAt(1) ) <= 30) {go=1;}
				
				if (go==1) {
					if( races.get(w).teirOneError==false&&races.get(w).rave==false){
						races.get(w).rave=true;
					
					for (int y = 0; y < races.get(w).dogs.size(); y++) {
						try{
							System.out.println("ENTERED++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							double old = 1/races.get(w).dogs.get(y).getSP();
							System.out.println("old"+old);
							double newer = 1/(Double.parseDouble(races.get(w).raceDriver.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText()));
							System.out.println("newer"+newer);
							double newSP=old-newer;
							
								races.get(w).dogs.get(y).addSPP(newSP);
							
								System.out.println(races.get(w).dogs.get(y).getSP());
							
							}catch(Exception k){k.printStackTrace();
							races.get(w).dogs.remove(y);
								y--;}

												

												
						}
					
					Collections.sort(races.get(w).dogs, ObjectDOG.STARTINGPRICE);
					PrintWriter out = null;
					if(races.get(w).typeOfRace.equalsIgnoreCase("greyhounds"))
					{ out = new PrintWriter(
							new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\priceMoversGreys.txt", true));}
					if(races.get(w).typeOfRace.equalsIgnoreCase("racing"))
					{ out = new PrintWriter(
							new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\priceMoversRacing.txt", true));}
					if(races.get(w).typeOfRace.equalsIgnoreCase("harness"))
					{ out = new PrintWriter(
							new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\priceMoversHarness.txt", true));}
					
					try{
					out.println(races.get(w).dogs.get(0).name()+" "+races.get(w).dogs.get(0).getSP()+" "+races.get(w).URL);}catch(Exception k){}
					out.close();
					
					
				} }
				
				
				
				if (txt.charAt(0) == 'A' || txt.charAt(0) == 'I' || txt.charAt(0) == 'C') {
					races.get(w).raceDriver.close();
					races.remove(w);
					w--;
					break goop;

				}
				

				
					

				// Make this "if time equals 10 seconds remaining"
				if (go==1) {
					
					if(races.get(w).typeOfRace.equalsIgnoreCase("harness")||
							races.get(w).typeOfRace.equalsIgnoreCase("greyhounds"))
					{
					 races.get(w).raceDriver.close();
						races.remove(w);
						w--;
						break goop;
					}

					boolean finish=false;
					System.out.println("Entered bet cycle");

					for (int y = 0; y < races.get(w).dogs.size(); y++) {
if((races.get(w).raceDriver
								.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText()).equalsIgnoreCase("(L)SCR")==false||races.get(w).raceDriver
								.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText().equalsIgnoreCase("SCR")==false)
{
	

						races.get(w).dogs.get(y).winPay = (Double.parseDouble(races.get(w).raceDriver
								.findElement(By.xpath(races.get(w).dogs.get(y).winxpath)).getText()));

						races.get(w).dogs.get(y).placePay = (Double.parseDouble(races.get(w).raceDriver
								.findElement(By.xpath(races.get(w).dogs.get(y).placexpath)).getText()));}
else{
	races.get(w).dogs.remove(y);
	y--;
					}}

					assignProbabilities(races.get(w));

					double WINsumOfProbabilities = 0;
					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						WINsumOfProbabilities = WINsumOfProbabilities + races.get(w).dogs.get(f).winPercentage;
					}
					double sumOfProbabilities = 0;
					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						sumOfProbabilities = sumOfProbabilities + races.get(w).dogs.get(f).placePercentage;
						// System.out.println("average percentage
						// "+obj.races.get(w).dogs.get(f).placePercentage+" real
						// Odds "+1/(obj.races.get(w).dogs.get(f).placePay));
					}
					double WINsumOfRealProbabilities = 0;
					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						WINsumOfRealProbabilities = WINsumOfRealProbabilities + (1 / (races.get(w).dogs.get(f).winPay));

					}
					double sumOfRealProbabilities = 0;
					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						sumOfRealProbabilities = sumOfRealProbabilities + (1 / (races.get(w).dogs.get(f).placePay));

					}
					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						races.get(w).dogs.get(
								f).winPercentage = (races.get(w).dogs.get(f).winPercentage / WINsumOfProbabilities) * 1;
						// System.out.println("new average percentage
						// "+obj.races.get(w).dogs.get(f).winPercentage);
					}

					double r = 3;
					if (races.get(w).dogs.size() < 8) {
						r = r - 1;
					}

					for (int f = 0; f < races.get(w).dogs.size(); f++) {
						races.get(w).dogs.get(
								f).placePercentage = (races.get(w).dogs.get(f).placePercentage / sumOfProbabilities)
										* r;
						// System.out.println("new average percentage
						// "+obj.races.get(w).dogs.get(f).placePercentage);
					}

					try {
						double upperbounds = 0;
						double lowerbounds = 0;
						double runners = 0;
						double runners2 = 0;

						if (races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
							upperbounds = 3;//
							lowerbounds = 1.0;// LOCKED
							runners = 1;//

						}
						if (races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
							upperbounds = 3;//
							lowerbounds = 1.05; // LOCKED
							runners = 1;//
						}
						if (races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
							upperbounds = 2;//
							lowerbounds = 1.35;// LOCKED
							runners = 2;//
						}
						// --------------------------------------------------------adds
						// runners to selection array
						// int f=winMultiplyer;
						// Collections.sort(obj.races.get(w).dogs,
						// ObjectDOG.TRAINERWINS);
						Collections.sort(races.get(w).dogs, ObjectDOG.FIXEDODDWINPRICE);
						for (int u = 0; u < races.get(w).dogs.size(); u++) {
							System.out.print(races.get(w).dogs.get(u).name() + races.get(w).dogs.get(u).getBox() + " ");
							System.out.print(races.get(w).dogs.get(u).winPay + " ");
							System.out.print(races.get(w).dogs.get(u).winPercentage + " ");
							System.out.print(races.get(w).dogs.get(u).placePay + " ");
							System.out.print(races.get(w).dogs.get(u).placePercentage + " ");
							System.out.println();

						}
						// Collections.sort(obj.races.get(w).dogs,
						// ObjectDOG.FIXEDODDWINPRICEREAL);
						for (int f = 0; f <= runners - 1; f++) {
							if(f==0&&races.get(w).typeOfRace.equalsIgnoreCase("racing")){
								lowerbounds = 1.15;
								
							}
							if(f==1&&races.get(w).typeOfRace.equalsIgnoreCase("racing")){
								lowerbounds = 1.25;
							}
							// System.out.println(obj.races.get(w).dogs.get(f).winPercentage+"
							// "+1/obj.races.get(w).dogs.get(f).winPay);
							double y = 1;
							if (races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
								y = 1;
							}
							if (races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
								y = 1;
							}

							if (races.get(w).typeOfRace.equalsIgnoreCase("racing")
									|| races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
								if (races.get(w).dogs
										.get(f).winPercentage > ((races.get(w).dogs.get(f + 1).winPercentage) * y)) {
									if (races.get(w).dogs.get(f).winPercentage
											/ (1 / races.get(w).dogs.get(f).winPay) > lowerbounds
											&& races.get(w).dogs.get(f).winPercentage
													/ (1 / races.get(w).dogs.get(f).winPay) < upperbounds) {
										// System.out.println("ADDING");
										races.get(w).dogs.get(f).TABFormRating = races.get(w).dogs.get(f).winPercentage
												/ (1 / races.get(w).dogs.get(f).winPay);

										races.get(w).selections.add(races.get(w).dogs.get(f));
									}
								}
							}
							/*if (races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
								y = 1.7;
							}
							if(races.get(w).typeOfRace.equalsIgnoreCase("harness"))
							{
								y=2.5;
							}

							if (races.get(w).typeOfRace.equalsIgnoreCase("racing")
									|| races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
								if (races.get(w).dogs
										.get(f).winPercentage < ((races.get(w).dogs.get(f + 1).winPercentage) * y)) {
									if(races.get(w).typeOfRace.equalsIgnoreCase("harness")&&races.get(w).dogs.get(f).winPercentage<((races.get(w).dogs.get(f+1).winPercentage)*1.5))
									{
										break;
									}
									if (races.get(w).dogs.get(f).winPercentage
											/ (1 / races.get(w).dogs.get(f).winPay) > lowerbounds
											&& races.get(w).dogs.get(f).winPercentage
													/ (1 / races.get(w).dogs.get(f).winPay) < upperbounds) {
										// System.out.println("ADDING");
										races.get(w).dogs.get(f).TABFormRating = races.get(w).dogs.get(f).winPercentage
												/ (1 / races.get(w).dogs.get(f).winPay);

										races.get(w).selections.add(races.get(w).dogs.get(f));
									}
								}
							}*/
						}
					} catch (Exception j) {
					}
					try {
						Collections.sort(races.get(w).selections, ObjectDOG.TABFORMRATING);
						races.get(w).WIN = races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
						).name();
						races.get(w).WINPAY = races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
						).winPay;
					}

					catch (Exception v) {
					}
					
					//makeBet(races.get(w).dogs.get(0), "place", races.get(w));
					if (races.get(w).WIN != null) {
						//try{makeBet(races.get(w).selections.get(0), "win", races.get(w));}catch(Exception q){}
						finish=true;
					}
					races.get(w).selections.clear();

					double upperbounds = 0;
					double lowerbounds = 0;
					double runners = 0;

					if (races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
						upperbounds = 3;// 3
						lowerbounds = 1.0; // 1.1
						runners = 1;// 2

						/*
						 * upperbounds = 3;//3 lowerbounds= 1.1; //1.1 runners =
						 * 2;//3
						 */
					}
					if (races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
						upperbounds = 3;// 3
						lowerbounds = 1.1;// 1.4
						runners = 1;// 2
					}
					if (races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
						upperbounds = 3;// 3
						lowerbounds = 1.1;// 1.2
						runners = 1;// 3
						/*
						 * upperbounds = 3;//3 lowerbounds= 1.2;// 1.2 runners =
						 * 3;//3
						 */
					}
					// --------------------------------------------------------adds
					// runners to selection array
					double p = 1.9;
					if (races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
						p = 1.6;
					}
					if (races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
						p = 2.3;
					}

					Collections.sort(races.get(w).dogs, ObjectDOG.TRAINERPLACE);
					for (int u = 0; u < races.get(w).dogs.size(); u++) {
						System.out.print(races.get(w).dogs.get(u).name() + races.get(w).dogs.get(u).getBox() + " ");
						System.out.print(races.get(w).dogs.get(u).winPay + " ");
						System.out.print(races.get(w).dogs.get(u).winPercentage + " ");
						System.out.print(races.get(w).dogs.get(u).placePay + " ");
						System.out.print(races.get(w).dogs.get(u).placePercentage + " ");
						System.out.println();

					}
					for (int f = 0; f <= runners - 1; f++) {

						if (races.get(w).dogs.get(f).placePercentage > ((races.get(w).dogs.get(f + 1).placePercentage)
								* p)&&races.get(w).typeOfRace.equalsIgnoreCase("racing")==false )   {
							// System.out.println(obj.races.get(w).dogs.get(f).placePercentage+"
							// "+1/obj.races.get(w).dogs.get(f).placePay);
							if (races.get(w).dogs.get(f).placePercentage
									/ (1 / races.get(w).dogs.get(f).placePay) > lowerbounds
									&& races.get(w).dogs.get(f).placePercentage
											/ (1 / races.get(w).dogs.get(f).placePay) < upperbounds) {
								// System.out.println("ADDING");
								races.get(w).dogs.get(f).TABFormRating = races.get(w).dogs.get(f).placePercentage
										/ (1 / races.get(w).dogs.get(f).placePay);

								//races.get(w).selections.add(races.get(w).dogs.get(f));
							}
						}
					}
					try {
						Collections.sort(races.get(w).selections, ObjectDOG.TABFORMRATING);
						races.get(w).PLACE = races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
						).name();
						races.get(w).PLACEPAY = races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
						).placePay;
					} catch (Exception v) {
					}

					if (races.get(w).PLACE != null) {
						makeBet(races.get(w).selections.get(0), "place", races.get(w));
					}
if(finish==true){
					races.get(w).raceDriver.close();
					races.remove(w);}
				}

			}}catch(Exception j){System.out.println();j.printStackTrace();//races.remove(w);
			
			}}
		} while (races.size() == 7);

	}

	private static void makeBet(ObjectDOG objectDOG, String string, ObjectRACE objectRACE) throws IOException {
		// TODO Auto-generated method stub
		try{
		double betAmount= loginBetSize(objectRACE,string);
		WebDriverWait twait = new WebDriverWait(objectRACE.raceDriver, 60);
	

		objectRACE.raceDriver.manage().window().maximize();
		
		
		
		String str1 = new BigDecimal(betAmount).toString();
		

		PrintWriter out = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\BetsMade\\BetaReport.txt", true));
		try {
		// out.println(string+" Race Report " + simpleDateHyphens);
		// out.println();
		double printable = 0;
		if (string.equalsIgnoreCase("win")) {
			printable = objectDOG.winPay;

			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectDOG.winxpath)));
			objectRACE.raceDriver.findElement(By.xpath(objectDOG.winxpath)).click();
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/div/form/ul/li[1]/div/fixed-odds-bet-amount/div/stake-input/span/input")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/div/form/ul/li[1]/div/fixed-odds-bet-amount/div/stake-input/span/input")).sendKeys(str1);
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[3]/footer/menu/button[2]")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[3]/footer/menu/button[2]")).click();
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")).click();
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")).click();
		}
		if (string.equalsIgnoreCase("place")) {
			printable = objectDOG.placePay;
			
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectDOG.placexpath)));
			objectRACE.raceDriver.findElement(By.xpath(objectDOG.placexpath)).click();
																				
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/div/form/ul/li[2]/div/fixed-odds-bet-amount/div/stake-input/span/input")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/div/form/ul/li[2]/div/fixed-odds-bet-amount/div/stake-input/span/input")).sendKeys(str1);
																				
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[3]/footer/menu/button[2]")));
			
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[3]/footer/menu/button[2]")).click();
																				
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")).click();
			
			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")));
			objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/div/ng-include/div[2]/footer/menu/button[3]")).click();
		}
		out.println(objectRACE.URL + " " + string + ": " + printable);
		} catch (Exception u) {
			u.printStackTrace();
			out.println("error");
			System.exit(0);
		}
		out.close();
		
	}catch(Exception q){}}

	

	private static double loginBetSize(ObjectRACE objectRACE, String string) {
		// TODO Auto-generated method stub
		double H;
		double betAmount=0;
		WebDriverWait twait = new WebDriverWait(objectRACE.raceDriver, 60);
		twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")));
		try {

			H = Double.parseDouble(
					(objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")).getText())
							.replace("$", ""));

			double f = H / 2;

		} catch (Exception e) {
			login(objectRACE.raceDriver);
		}
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")));
		
			double balance = Double.parseDouble(
					(objectRACE.raceDriver.findElement(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")).getText())
							.replace("$", ""));
			
			double PSuccess = 0;
			double odds = 0;
			if(string.equalsIgnoreCase("win")){
			 PSuccess= objectRACE.dogs.get(0).winPercentage;
			 odds = objectRACE.dogs.get(0).winPay-1;
			}
			if(string.equalsIgnoreCase("place")){
				 PSuccess= objectRACE.dogs.get(0).placePercentage;
				 odds = objectRACE.dogs.get(0).placePay-1;
				}
			
			double multiplyer = ((PSuccess*odds)-(1-PSuccess))/odds;
			
			
			

			DecimalFormat df = new DecimalFormat("####.");

			betAmount = Double.parseDouble(df.format((balance*.7)*multiplyer))*.4;

			if (betAmount < 1) {
				betAmount = 1;
			}
			
			System.out.println("Bet Amount: " + betAmount);

			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
			
			
		return betAmount;
	}

	private static void assignProbabilities(ObjectRACE objectRACE) {
		// TODO Auto-generated method stub

		for (int f = 0; f < objectRACE.dogs.size(); f++) {
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("1") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("2") == true) {
				objectRACE.dogs.get(f).boxNumber = "1";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("3") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("4") == true) {
				objectRACE.dogs.get(f).boxNumber = "2";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("5") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("6") == true) {
				objectRACE.dogs.get(f).boxNumber = "3";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("7") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("8") == true) {
				objectRACE.dogs.get(f).boxNumber = "4";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("9") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("10") == true) {
				objectRACE.dogs.get(f).boxNumber = "5";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("11") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("12") == true) {
				objectRACE.dogs.get(f).boxNumber = "6";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("13") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("14") == true) {
				objectRACE.dogs.get(f).boxNumber = "7";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("15") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("16") == true) {
				objectRACE.dogs.get(f).boxNumber = "8";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("17") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("18") == true) {
				objectRACE.dogs.get(f).boxNumber = "9";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("19") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("20") == true) {
				objectRACE.dogs.get(f).boxNumber = "10";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("21") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("22") == true) {
				objectRACE.dogs.get(f).boxNumber = "11";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("23") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("24") == true) {
				objectRACE.dogs.get(f).boxNumber = "12";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("25") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("26") == true) {
				objectRACE.dogs.get(f).boxNumber = "13";
			}
			if (objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("27") == true
					|| objectRACE.dogs.get(f).boxNumber.trim().equalsIgnoreCase("28") == true) {
				objectRACE.dogs.get(f).boxNumber = "14";
			}
		}

		int number = objectRACE.dogs.size();

		Collections.sort(objectRACE.dogs, ObjectDOG.FIXEDODDWINPRICE);

		for (int i = 0; i < objectRACE.dogs.size(); ++i) {
			foop: {
				ArrayList<Double> percentages = new ArrayList<Double>();
				// percentages.add(5.0);
				percentages.add(10.0);
				// percentages.add(15.0);
				percentages.add(20.0);
				// percentages.add(25.0);
				percentages.add(30.0);
				// percentages.add(35.0);
				percentages.add(40.0);
				// percentages.add(45.0);
				percentages.add(50.0);
				// percentages.add(55.0);
				percentages.add(60.0);
				// percentages.add(65.0);
				percentages.add(70.0);
				// percentages.add(75.0);
				percentages.add(80.0);
				// percentages.add(85.0);
				percentages.add(90.0);
				// percentages.add(95.0);
				percentages.add(100.0);

				double winPercentage;

				winPercentage = (1 / objectRACE.dogs.get(i).winPay) * 100;
				int t;
				for (t = 0; t < percentages.size(); t++) {
					// System.out.println(t);
					if (winPercentage <= percentages.get(t)) {
						break;
					}
				}

				DataInputStream dis = null;
				String numbers = "0 0 0 0";
				int d = i + 1;
				try {
					/*
					 * //not with boxes dis = new DataInputStream( new
					 * FileInputStream(
					 * "c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\"
					 * + obj.races.get(r).typeOfRace +
					 * "\\"+ obj.races.get(r).dogs.size()+"runners"+ "\\" +"
					 * winProbabilitiesByRankAndPrice"+ "\\" + "rank"+(d)
					 * +"percentage"+percentages.get(t)+ ".txt"));
					 */
					int e=objectRACE.dogs.size()/2;
					int size=e*2;

					// with boxes
					dis = new DataInputStream(new FileInputStream(
							"c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\" + objectRACE.typeOfRace + "\\"
									+ size + "runners" + "\\" + "winProbabilitiesByRankAndPriceAndBox"
									+ "\\" + "rank" + d + "\\" + "box" + objectRACE.dogs.get(i).boxNumber + "\\"
									+ "percentage" + percentages.get(t) + ".txt"));

					numbers = dis.readLine();// + " " + dis.readLine();
					dis.close();
				} catch (Exception k) {
				}

				String[] array = numbers.split(" ");
				// System.out.println("file read");

				// if(Double.parseDouble(array[0])==0){
				// obj.races.get(r).dogs.remove(i);
				// i--;
				// break foop;
				// }

				if (number >= 8) {
					// System.out.println("loop entered");

					// handle inputInteger here...
					objectRACE.dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
							+ Double.parseDouble(array[1]) + Double.parseDouble(array[2])
							+ Double.parseDouble(array[3]);
					objectRACE.dogs.get(i).trifectaPercentage = Double.parseDouble(array[0])
							+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]);
					objectRACE.dogs.get(i).placePercentage = Double.parseDouble(array[0]) + Double.parseDouble(array[1])
							+ Double.parseDouble(array[2]);
					objectRACE.dogs.get(i).winPercentage = Double.parseDouble(array[0]);
				}

				if (number < 8) {

					// handle inputInteger here...
					objectRACE.dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
							+ Double.parseDouble(array[1]) + Double.parseDouble(array[2])
							+ Double.parseDouble(array[3]);
					objectRACE.dogs.get(i).trifectaPercentage = Double.parseDouble(array[0])
							+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]);
					objectRACE.dogs.get(i).placePercentage = Double.parseDouble(array[0])
							+ Double.parseDouble(array[1]);
					objectRACE.dogs.get(i).winPercentage = Double.parseDouble(array[0]);
				}
				// System.out.println(obj.races.get(r).dogs.get(i).winPercentage);

			}

		}
	}

	/*private static void winBet(ObjectDOG objectDOG, ObjectRACE objectRACE) {
		// TODO Auto-generated method stub

		objectRACE.raceDriver.findElement(By.xpath(objectDOG.winxpath)).click();

		WebDriverWait twait = new WebDriverWait(objectRACE.raceDriver, 10);
		try {

			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/section/form/ul/li[1]/div/fixed-odds-bet-amount/div/stake-input/span/input")));
		} catch (Exception u) {
			u.printStackTrace();
		}

		objectRACE.raceDriver
				.findElement(By
						.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/section/form/ul/li[1]/div/fixed-odds-bet-amount/div/stake-input/span/input"))
				.sendKeys(Double.toString(betAmount));

		objectRACE.raceDriver
				.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[3]/footer/menu/button"))
				.click();
		twait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/footer/menu/button[3]")));

		objectRACE.raceDriver
				.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/footer/menu/button[3]"))
				.click();

	}

	private static void placeBet(ObjectDOG objectDOG, ObjectRACE objectRACE) {
		// TODO Auto-generated method stub
		objectRACE.raceDriver.findElement(By.xpath(objectDOG.placexpath)).click();

		WebDriverWait twait = new WebDriverWait(objectRACE.raceDriver, 10);
		try {

			twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/section/form/ul/li[2]/div/fixed-odds-bet-amount/div/stake-input/span/input")));
		} catch (Exception u) {
			u.printStackTrace();
		}

		objectRACE.raceDriver
				.findElement(By
						.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/div/div[2]/div/div/fixed-odds-bet-card/section/section/form/ul/li[2]/div/fixed-odds-bet-amount/div/stake-input/span/input"))
				.sendKeys(Double.toString(betAmount));

		objectRACE.raceDriver
				.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[3]/footer/menu/button"))
				.click();
		twait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/footer/menu/button[3]")));

		objectRACE.raceDriver
				.findElement(By.xpath("html/body/ui-view/main/div[2]/div/div/ng-include/div[2]/footer/menu/button[3]"))
				.click();

	}
*/
	public static void login(WebDriver driver2) {
		// TODO Auto-generated method stub
		WebDriverWait waits = new WebDriverWait(driver2, 60);
		// driver.get("https://www.tab.com.au/");
		// waits.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[1]")));
		// waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[1]")));
		double number = 0;
		try {
			number = Double.parseDouble(
					(driver2.findElement(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[2]")).getText())
							.replace("$", ""));
		} catch (Exception h) {
		}
		if (number == 0) {
			hoop: for (int e = 0; e < 20; e++) {
				try {

					driver2.findElement(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[1]")).click();

					waits.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("html/body/ui-view/main/div[4]/div/div/form/div[1]/div/input")));

					WebElement usernameElement = driver2
							.findElement(By.xpath("html/body/ui-view/main/div[4]/div/div/form/div[1]/div/input"));
					usernameElement.sendKeys("1674681");
					WebElement passwordElement = driver2
							.findElement(By.xpath("html/body/ui-view/main/div[4]/div/div/form/div[2]/input"));
					passwordElement.sendKeys("kmKpDV9m");

					driver2.findElement(By.xpath("html/body/ui-view/main/div[4]/div/div/form/div[2]/input"))
							.sendKeys(Keys.ENTER);
					waits.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("html/body/ui-view/header/div/div[2]/div[2]/a[3]")));

					break hoop;
				} catch (Exception h) {
				}
			}
		}
	}
/*
	private static void addTicks(ObjectRACE currentRace) throws IOException {
		System.out.println();
		try {
			Collections.sort(currentRace.dogs, ObjectDOG.TABFORMRATING);

			for (int p = 0; p < currentRace.dogs.size(); p++) {
				try {
					DataInputStream dis = new DataInputStream(
							new FileInputStream("c:\\users\\john\\desktop\\betagrays\\outcomeProbabilty\\"
									+ currentRace.typeOfRace + "\\" + currentRace.raceVenue + currentRace.distanceOfRace
									+ currentRace.dogs.size() + p + ".txt"));
					String numbers = dis.readLine();// + " " + dis.readLine();
					String[] array = numbers.split(" ");
					ArrayList<Double> values = new ArrayList<Double>();

					for (int i = 0; i < array.length; ++i) {
						// System.out.println(array[i]);
						values.add(Double.parseDouble(array[i]));

						// handle inputInteger here...

					}

					dis.close();
				} catch (Exception t) {
				}

				/*
				 * System.out.println("TABForm"); for (int u = 0; u <
				 * currentRace.dogs.size(); u++) {
				 * System.out.println(currentRace.dogs.get(u).getBox() + " " +
				 * currentRace.dogs.get(u).getName() + " " +
				 * currentRace.dogs.get(u).TABFormRating);
				 * 
				 * }
				 */

			/*	currentRace.dogs.get(p).TF = (double) (8 - p);

				currentRace.dogs.get(p).TABFormRank = (double) p + 1;

			}

			// total ticks

			for (int p = 0; p < currentRace.dogs.size(); p++) {

				ArrayList<Double> tickArray = new ArrayList<Double>();
				
				 * tickArray.add(currentRace.dogs.get(p).StartP);
				 * tickArray.add(currentRace.dogs.get(p).LR);
				 * tickArray.add(currentRace.dogs.get(p).TP);
				 * tickArray.add(currentRace.dogs.get(p).TW);
				 * tickArray.add(currentRace.dogs.get(p).DW);
				 * tickArray.add(currentRace.dogs.get(p).LTF);
				 * tickArray.add(currentRace.dogs.get(p).WAT);
				 * tickArray.add(currentRace.dogs.get(p).GA);
				 * tickArray.add(currentRace.dogs.get(p).FST);
				 * tickArray.add(currentRace.dogs.get(p).FT);
				 */
				//tickArray.add(currentRace.dogs.get(p).TF);

				/*
				 * currentRace.dogs.get(p).totalTicks =
				 * currentRace.dogs.get(p).StartP /**
				 * currentRace.dogs.get(p).runningLane
				 */
				// + currentRace.dogs.get(p).LR + currentRace.dogs.get(p).TP +
				// currentRace.dogs.get(p).TW
				// + currentRace.dogs.get(p).DW + currentRace.dogs.get(p).LTF +
				// currentRace.dogs.get(p).WAT
				// + currentRace.dogs.get(p).GA + currentRace.dogs.get(p).FST +
				// currentRace.dogs.get(p).FT
				// + currentRace.dogs.get(p).TF;

				/*Collections.sort(tickArray);
				Collections.reverse(tickArray);
				currentRace.dogs.get(p).totalTicks = tickArray.get(0);

			}

			// Collections.sort(currentRace.dogs, ObjectDOG.TOTALTICKS);

			Collections.sort(currentRace.dogs, ObjectDOG.TABFORMRATING);

			PrintWriter out = new PrintWriter(new FileWriter(
					"c:\\users\\john\\desktop\\betagrays\\tickAlocation\\" + simpleDateHyphens + "TickAlocation.txt",
					true));
			out.println(currentRace.raceVenue + " " + currentRace.typeOfRace + " " + currentRace.raceNumber);
			out.println();
			int d = 0;
			if (currentRace.dogs.size() > 8) {
				d = 8;
			}

			if (currentRace.dogs.size() <= 8) {
				d = currentRace.dogs.size();
			}
			for (int p = 0; p < d; p++) {

				out.println(currentRace.dogs.get(p).getName() + " " + currentRace.dogs.get(p).TABFormRating);

			}
			out.println();
			out.println();
			out.println();
			out.close();
		} catch (Exception j) {
			j.printStackTrace();
		}
	}*/

}
