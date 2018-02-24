import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class backTest {

	static WebDriver backTestDriver;
	static ArrayList<ObjectRACE> todaysRaces;
	static String raceTypes = "RHG";
	static database obj;
	static database smallObj;
	static ArrayList<ObjectRACE> tempRaces;

	public static void collectData() throws IOException, ClassNotFoundException {

		try {
			// read from disk using FileInputStream
			FileInputStream f_in = new FileInputStream("myobject.data");

			// read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// read the object
			obj = (database) obj_in.readObject();
		} catch (Exception r) {
			obj = new database();
		}

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.load.strategy", "unstable");
		backTestDriver = new FirefoxDriver(profile);

		for (int a = 2015; a <= 2016; a++) {
			// month loop

			for (double e = 1; e <= 6; e++) {
				if (a == 2015 && e < 10) {
					e = 10;
				}
				NumberFormat formatter = new DecimalFormat("00");
				String m = formatter.format(e); // ----> 01
				// day loop
				for (double q = 1; q <= 31; q++) {

					String x = formatter.format(q); // ----> 01
					// raceType loop{
					tempRaces = new ArrayList<ObjectRACE>();

					for (int w = 0; w < 3; w++) {
						try {
							String tempString = "https://www.tab.com.au/racing/meetings/results/" + a + "-" + m + "-"
									+ x + "/" + raceTypes.charAt(w);
							boolean racePresent = false;
							for (int s = 0; s < obj.raceStrings.size(); s++) {
								if (obj.raceStrings.get(s).equalsIgnoreCase(tempString)) {
									racePresent = true;
								}
							}
							if (racePresent == false) {

								backTestDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
								backTestDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
								backTestDriver.get(tempString);

								WebDriverWait twaitt = new WebDriverWait(backTestDriver, 30);
								try {
									twaitt.until(ExpectedConditions.invisibilityOfElementLocated(
											By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));
								} catch (Exception k) {
								}
								twaitt.until(ExpectedConditions.visibilityOfElementLocated(
										By.xpath("html/body/ui-view/header/div/ng-switch/a/i[1]")));

								collectRaces();
								// System.out.println(tempRaces.size());

								obj.raceStrings.add(tempString);

							}
						} catch (Exception j) {
							w--;// j.printStackTrace();
						}

					}
					if (tempRaces.size() > 0) {
						collectRace();
						Collections.sort(tempRaces, ObjectRACE.timeDoubleOrder);

						for (int y = 0; y < tempRaces.size(); y++) {

							obj.races.add(tempRaces.get(y));
						}

						System.out.println("size of obj.races: " + obj.races.size());
						// write to disk with fileOutputStream
						FileOutputStream f_out = new FileOutputStream("myobject.data");
						// write object with ObjectOutputStream
						ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
						// write object out to disk
						obj_out.writeObject(obj);

					}

				}
			}
		}

		backTestDriver.close();

	}

	private static void collectRace() {
		// TODO Auto-generated method stub
		for (int o = 0; o < tempRaces.size(); o++) {

			if (tempRaces.get(o).URL.equalsIgnoreCase("https://www.tab.com.au/racing/2015-11-01/KILMORE/E/R/2")
					|| tempRaces.get(o).URL
							.equalsIgnoreCase("https://www.tab.com.au/racing/2016-05-11/ANGLE-PARK/A/G/1")) {
				tempRaces.remove(o);

			}

			loop: {
				try {
					backTestDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
					backTestDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					backTestDriver.get(tempRaces.get(o).URL);
					WebDriverWait twait = new WebDriverWait(backTestDriver, 60);
					twait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr[1]/td[1]")));
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}

					tempRaces.get(o).typeOfRace = (backTestDriver
							.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[1]/div[1]/div/div/div[1]"))
							.getText());
					try {
						tempRaces.get(o).distanceOfRace = (backTestDriver
								.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[1]/div[3]/ul/li[2]"))
								.getText().replace("m", "").replace("|", ""));

						tempRaces.get(o).gradeOfRace = (backTestDriver
								.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[1]/div[3]/ul/li[3]"))
								.getText().replace("|", ""));
					} catch (Exception j) {
					}
					String[] array;

					String firstString = (backTestDriver
							.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[1]/td[3]"))
							.getText());
					array = firstString.split("\n");
					// .replaceAll("[^\\d.]", "").replace(".","");
					tempRaces.get(o).firstPlace = array[0].replaceAll("\\d", "").replace(".", "").trim();

					try {
						String secondString = (backTestDriver
								.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[2]/td[3]"))
								.getText());
						array = secondString.split("\n");
						// .replaceAll("[^\\d.]", "").replace(".","");
						tempRaces.get(o).secondPlace = array[0].replaceAll("\\d", "").replace(".", "").trim();
					} catch (Exception e) {
					}
					try {
						String thirdString = backTestDriver
								.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[3]/td[3]"))
								.getText();
						array = thirdString.split("\n");
						// .replaceAll("[^\\d.]", "").replace(".","");
						tempRaces.get(o).thirdPlace = array[0].replaceAll("\\d", "").replace(".", "").trim();
					} catch (Exception e) {
					}
					try {
						String fourthString = backTestDriver
								.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[4]/td[3]"))
								.getText();
						array = fourthString.split("\n");
						// .replaceAll("[^\\d.]", "").replace(".","");
						tempRaces.get(o).fourthPlace = array[0].replaceAll("\\d", "").replace(".", "").trim();
					} catch (Exception s) {
					}

					// System.out.println("here");

					for (int p = 1; p < 11; p++) {
						try {

							if (backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
											+ p + "]/td[1]"))
									.getText().equalsIgnoreCase("Quinella") == true) {
								tempRaces.get(o).quinellaDiv = Double.parseDouble(backTestDriver
										.findElement(By
												.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
														+ p + "]/td[3]/div/div"))
										.getText().replace("$", "").replace(",", ""));
							}
							if (backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
											+ p + "]/td[1]"))
									.getText().equalsIgnoreCase("Trifecta") == true) {
								tempRaces.get(o).trifectaDiv = Double.parseDouble(backTestDriver
										.findElement(By
												.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
														+ p + "]/td[3]/div/div"))
										.getText().replace("$", "").replace(",", ""));
							}
							if (backTestDriver
									.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
													+ p + "]/td[1]"))
									.getText().equalsIgnoreCase("First Four") == true) {
								tempRaces.get(o).firstFourDiv = Double.parseDouble(backTestDriver
										.findElement(By
												.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["
														+ p + "]/td[3]/div/div"))
										.getText().replace("$", "").replace(",", ""));

							}
						} catch (Exception v) {
						}

					}

					for (int p = 1; p <= 25; p++) {
						// System.out.println("here1");
						try {
							String scrCheck = backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
											+ p + "]/div[5]/span"))
									.getText();
							if (scrCheck.equalsIgnoreCase("SCR") || scrCheck.equalsIgnoreCase("(L)SCR")
									|| scrCheck.equalsIgnoreCase("0.00")) {
								throw new EmptyStackException();
							}

							String name = backTestDriver
									.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[2]/div/div/div"))
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
								currentDog.boxNumber = backTestDriver.findElement(By
										.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
												+ p + "]/div[1]"))
										.getText();
							}

							// System.out.println("here2");

							if (tempRaces.get(o).typeOfRace.equalsIgnoreCase("greyhounds")) {
								try {
									currentDog.winPay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[4]/span"))
											.getText());
									// System.out.println(currentDog.winPay);
									double amount = currentDog.winPay / 2;
									currentDog.placePay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[5]/span"))
											.getText());
									amount = currentDog.placePay / 2;
									// System.out.println(currentDog.placePay);
									tempRaces.get(o).dogs.add(currentDog);
								} catch (Exception f) {
									tempRaces.remove(o);
									o--;// System.out.println("race
										// removed");//f.printStackTrace();
									break;
								}
							}

							if (tempRaces.get(o).typeOfRace.equalsIgnoreCase("racing")) {
								try {
									currentDog.winPay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[5]/span"))
											.getText());
									// System.out.println(currentDog.winPay);
									double amount = currentDog.winPay / 2;
									currentDog.placePay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[6]/span"))
											.getText());
									amount = currentDog.placePay / 2;
									// System.out.println(currentDog.placePay);
									tempRaces.get(o).dogs.add(currentDog);
								} catch (Exception f) {
									tempRaces.remove(o);
									o--;// System.out.println("race
										// removed");//f.printStackTrace();
									break;
								}
							}

							if (tempRaces.get(o).typeOfRace.equalsIgnoreCase("harness")) {
								try {
									currentDog.winPay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[4]/span"))
											.getText());
									// System.out.println(currentDog.winPay);
									double amount = currentDog.winPay / 2;
									currentDog.placePay = Double.parseDouble(backTestDriver.findElement(By
											.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/race-runners/div/div[2]/div[2]/div["
													+ p + "]/div[5]/span"))
											.getText());
									amount = currentDog.placePay / 2;
									// System.out.println(currentDog.placePay);

									tempRaces.get(o).dogs.add(currentDog);
								} catch (Exception f) {
									tempRaces.remove(o);
									o--;// System.out.println("race
										// removed");//f.printStackTrace();
									break;
								}
							}

						} catch (Exception j) {// j.printStackTrace();

						}
					}
				} catch (Exception k) {
					o--;
					try {
						backTestDriver.close();
					} catch (Exception z) {
					}
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("webdriver.load.strategy", "unstable");
					backTestDriver = new FirefoxDriver(profile);

				}
			}
		}
	}

	private static void collectRaces() {
		// TODO Auto-generated method stub
		for (int e = 1; e <= 25; e++) {

			for (int r = 1; r <= 15; r++) {
				try {
					String raceLocation = ((backTestDriver.findElement(By
							.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[1]/span["
									+ e + "]/span"))).getText().replace("(", "").replace(")", ""));
					if (raceLocation.equalsIgnoreCase("nsw") || raceLocation.equalsIgnoreCase("vic")
							|| raceLocation.equalsIgnoreCase("tas") || raceLocation.equalsIgnoreCase("qld")
							|| raceLocation.equalsIgnoreCase("WA ") || raceLocation.equalsIgnoreCase("nzl")
							|| raceLocation.equalsIgnoreCase("SA ")) {

						String checkIfAbandoned = ((backTestDriver.findElement(By
								.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[2]/div["
										+ e + "]/race-brief[" + r + "]/a/em"))).getText());
						if (checkIfAbandoned.equalsIgnoreCase("abnd") == false) {
							// System.out.println("entered");

							ObjectRACE currentRace = new ObjectRACE();

							currentRace.raceVenue = ((backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[1]/span["
											+ e + "]/em"))).getText());

							currentRace.raceNumber = ((backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[2]/div["
											+ e + "]/race-brief[1]/a/span[1]"))).getText().replace("R", ""));

							String text = ((backTestDriver.findElement(By
									.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[2]/div["
											+ e + "]/race-brief[" + r + "]/a/time"))).getText());

							currentRace.raceXpath = "html/body/ui-view/main/div[1]/ui-view/div/ui-view/section/div/div/div/div[2]/div["
									+ e + "]/race-brief[" + r + "]/a";
							currentRace.URL = backTestDriver.findElement(By.xpath(currentRace.raceXpath))
									.getAttribute("href");

							double minutes = 0;
							String[] array = text.split(":");
							// System.out.println(array[0]+""+array[1]);
							minutes = (Double.parseDouble(array[0]) * 60) + Double.parseDouble(array[1]);

							currentRace.timeRemaining = minutes;

							tempRaces.add(currentRace);
							// System.out.println("raceAdded");
						}
					}
				} catch (Exception o) {// o.printStackTrace();

				}

			}

		}

	}

	public static void populateDatabase() {
		// TODO Auto-generated method stub

		try {
			// read from disk using FileInputStream
			FileInputStream f_in = new FileInputStream("myobject.data");

			// read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// read the object
			obj = (database) obj_in.readObject();
			obj_in.close();
		} catch (Exception r) {
		}

		System.out.println("database size: " + obj.races.size() + " races");
		/*
		 * for(int y = 0; y<obj.races.size();y++) { if
		 * (obj.races.get(y).dogs.size()==0) {
		 * 
		 * obj.races.remove(y); }
		 * System.out.println(obj.races.get(y).dogs.get(0).boxNumber); }
		 */

	}

	public static void testAndReport(double winMultiplyer) throws IOException {
		// TODO Auto-generated method stub

		report.go("Racing", obj.races, winMultiplyer);
		report.go("Harness", obj.races, winMultiplyer);
		report.go("Greyhounds", obj.races, winMultiplyer);
	}

	public static void placeTestAndReport(double placeMultiplyer) throws IOException {
		// TODO Auto-generated method stub

		report.goPlace("Racing", obj.races, placeMultiplyer);
		report.goPlace("Harness", obj.races, placeMultiplyer);
		report.goPlace("Greyhounds", obj.races, placeMultiplyer);

		ArrayList<ArrayList<Double>> dailyBreakdown = new ArrayList<ArrayList<Double>>();

		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		dailyBreakdown.add(new ArrayList<Double>());
		// dailyBreakdown.add(days);
int sat=0;
		for (int u = 0; u < obj.races.size(); u++) {
			String[] url = null;
			url = obj.races.get(u).URL.split("/");
			String[] date = null;
			date = url[4].split("-");
			String dateString = date[2] + "/" + date[1] + "/" + date[0];

			DateFormat formatter;
			java.util.Date theDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				theDate = formatter.parse(dateString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//

			Calendar c = Calendar.getInstance();
			c.setTime(theDate);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			System.out.println(dayOfWeek);
			
			if(obj.races.get(u).typeOfRace.equalsIgnoreCase("Racing"))
			{sat++;}
			
			double r = 0;
			if (obj.races.get(u).PLACE != null) {
				
				
				
				 r = -1;
				if (obj.races.get(u).dogs.size() < 8) {
					if (obj.races.get(u).PLACE.trim().equalsIgnoreCase(obj.races.get(u).firstPlace.trim()) == true) {
						r = r + obj.races.get(u).PLACEPAY;
					}

					if (obj.races.get(u).PLACE.trim().equalsIgnoreCase(obj.races.get(u).secondPlace.trim()) == true) {
						r = r + obj.races.get(u).PLACEPAY;
					}

				}

				if (obj.races.get(u).dogs.size() >= 8) {
					if (obj.races.get(u).PLACE.trim().equalsIgnoreCase(obj.races.get(u).thirdPlace.trim()) == true) {
						r = r + obj.races.get(u).PLACEPAY;
					}

					if (obj.races.get(u).PLACE.trim().equalsIgnoreCase(obj.races.get(u).firstPlace.trim()) == true) {
						r = r + obj.races.get(u).PLACEPAY;
					}

					if (obj.races.get(u).PLACE.trim().equalsIgnoreCase(obj.races.get(u).secondPlace.trim()) == true) {
						r = r + obj.races.get(u).PLACEPAY;

					}

				}
				dailyBreakdown.get(dayOfWeek - 1).add(r);

			}
			
			
			
			if (obj.races.get(u).WIN != null) {
				
				if (obj.races.get(u).WIN.trim().equalsIgnoreCase(obj.races.get(u).firstPlace.trim()) == true) {
					dailyBreakdown.get(dayOfWeek - 1).add(obj.races.get(u).WINPAY - 1);
				} else {
					dailyBreakdown.get(dayOfWeek - 1).add(-1.0);
				}
				
			}
		}

		PrintWriter out = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\DayReport.txt", true));

		for (int y = 0; y < dailyBreakdown.size(); y++) {

			double sum = 0;
			for (int o = 0; o < dailyBreakdown.get(y).size(); o++) {
				sum = sum + dailyBreakdown.get(y).get(o);
			}

			out.println("ROI: " + (((sum / dailyBreakdown.get(y).size()) * 100)));
		}
		out.println(sat);
		out.close();

		PrintWriter draw = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\TotalWindrawDown.txt"));
		PrintWriter chanceOfWin = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\oddDrawDown.txt"));
		PrintWriter pay = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\pay.txt"));
		PrintWriter url = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\url.txt"));
		for (int g = 0; g < obj.races.size(); g++) {
			if (obj.races.get(g).WIN != null) {

				if (obj.races.get(g).win == 0) {
					draw.println("-1");
				}
				if (obj.races.get(g).win > 0) {
					draw.println((obj.races.get(g).win - 1));
				}
				chanceOfWin.println(obj.races.get(g).fixedOddwinDiv);
				pay.println(obj.races.get(g).WINPAY);
				url.println(obj.races.get(g).URL);
			}
			if (obj.races.get(g).PLACE != null) {
				if (obj.races.get(g).place == 0) {
					draw.println("-1");
				}
				if (obj.races.get(g).place > 0) {
					draw.println((obj.races.get(g).place - 1));
				}
				chanceOfWin.println(obj.races.get(g).winDiv);
				pay.println(obj.races.get(g).PLACEPAY);
				url.println(obj.races.get(g).URL);
			}

		}
		url.close();
		pay.close();
		chanceOfWin.close();
		draw.close();

	}

	public static void makeProbabilities() throws IOException {
		// TODO Auto-generated method stub
		for (int y = 20000; y < obj.races.size() - 10000; y++) {

			for (int f = 0; f < obj.races.get(y).dogs.size(); f++) {
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("1") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("2") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "1";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("3") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("4") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "2";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("5") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("6") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "3";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("7") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("8") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "4";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("9") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("10") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "5";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("11") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("12") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "6";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("13") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("14") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "7";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("15") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("16") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "8";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("17") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("18") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "9";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("19") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("20") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "10";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("21") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("22") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "11";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("23") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("24") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "12";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("25") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("26") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "13";
				}
				if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("27") == true
						|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("28") == true) {
					obj.races.get(y).dogs.get(f).boxNumber = "14";
				}
			}

			Collections.sort(obj.races.get(y).dogs, ObjectDOG.FIXEDODDWINPRICE);

			// robot.positionalProbabilitiesByrank(obj.races.get(y));

			robot.winProbabilitiesByRankAndPrice(obj.races.get(y));
			robot.winProbabilitiesByRankAndPriceAndBox(obj.races.get(y));
		}
	}

	public static void winBet(double winMultiplyer) {
		// TODO Auto-generated method stub
		for (int w = 0; w < obj.races.size(); w++) {
			loop: {
				obj.races.get(w).WIN = null;
				obj.races.get(w).WINPAY = 0;
				obj.races.get(w).win = 0;
				obj.races.get(w).selections.clear();

				String[] url = null;
				url = obj.races.get(w).URL.split("/");
				String[] date = null;
				date = url[4].split("-");
				String dateString = date[2] + "/" + date[1] + "/" + date[0];
				DateFormat formatter;
				java.util.Date theDate = null;
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
				System.out.println(dayOfWeek);
				if(dayOfWeek==7){
					break loop;
				}
				if(obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")||
						obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds"))
				{
					break loop;
				}


				// System.out.println((obj.races.get(w).URL));
				// IDEA: whole race bet/lay
				// sum of real probabilities must equal 1,
				// dogprobability/sumofprobabilities *1= corrected probability
				// add rake correctedProbability+correctedProbability*.22=
				// corrected probability > than 1/odds then add to selections
				// staking plan

				// --------------------------------------------------------finds
				// sum of average probabilities
				double sumOfProbabilities = 0;
				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					sumOfProbabilities = sumOfProbabilities + obj.races.get(w).dogs.get(f).winPercentage;
					// System.out.println("average percentage
					// "+obj.races.get(w).dogs.get(f).winPercentage+" real Odds
					// "+1/(obj.races.get(w).dogs.get(f).winPay));
				}

				// System.out.println("sum of average percentage
				// "+sumOfProbabilities);

				// --------------------------------------------------------finds
				// sum of real probabilities
				double sumOfRealProbabilities = 0;
				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					sumOfRealProbabilities = sumOfRealProbabilities + (1 / (obj.races.get(w).dogs.get(f).winPay));

				}
				// System.out.println("sum of real odds
				// "+sumOfRealProbabilities);

				// --------------------------------------------------------correct
				// probabilities
				// about .65-.75 worked well for in box analysis

				// not sure what works for non box analysis tried, .65,1,.8 non
				// box analysis may not work at all, need more work
				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					obj.races.get(w).dogs.get(
							f).winPercentage = (obj.races.get(w).dogs.get(f).winPercentage / sumOfProbabilities) * 1;
					// System.out.println("new average percentage
					// "+obj.races.get(w).dogs.get(f).winPercentage);
				}

				try {
					double upperbounds = 0;
					double lowerbounds = 0;
					double runners = 0;
					double runners2 = 0;

					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
						upperbounds = 3;//
						lowerbounds = 1.1;// LOCKED
						runners = 1;//

					}
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
						upperbounds = 3;//
						lowerbounds = 1.2; // LOCKED
						runners = 1;//
					}
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
						upperbounds = 2;//
						lowerbounds = 1.35;// LOCKED
						runners = 2;//
					}
					// --------------------------------------------------------adds
					// runners to selection array
					// int f=winMultiplyer;
					// Collections.sort(obj.races.get(w).dogs,
					// ObjectDOG.TRAINERWINS);
					Collections.sort(obj.races.get(w).dogs, ObjectDOG.FIXEDODDWINPRICE);
					// Collections.sort(obj.races.get(w).dogs,
					// ObjectDOG.FIXEDODDWINPRICEREAL);
					for (int f = 0; f <= runners - 1; f++) {
						// System.out.println(obj.races.get(w).dogs.get(f).winPercentage+"
						// "+1/obj.races.get(w).dogs.get(f).winPay);
						if(f==0&&obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")){
							lowerbounds = 1.15;
							
						}
						if(f==1&&obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")){
							lowerbounds = 1.25;
						}
						if(f==0&&obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")){
							upperbounds = 1.15;
							lowerbounds = 1.1;
							
						}
						if(f==1&&obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")){
							lowerbounds = 1.3;
						}
						
						
						double y = 1;
						if (obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
							y = 1.6;
						}
						if (obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
							y = 1;
						}
						//if(f>0){
						//lowerbounds=lowerbounds+.05;
						//}
						//if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")
								//|| obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
							if (obj.races.get(w).dogs
									.get(f).winPercentage > ((obj.races.get(w).dogs.get(f + 1).winPercentage) * y)) {
								if (obj.races.get(w).dogs.get(f).winPercentage
										/ (1 / obj.races.get(w).dogs.get(f).winPay) > lowerbounds
										&& obj.races.get(w).dogs.get(f).winPercentage
												/ (1 / obj.races.get(w).dogs.get(f).winPay) < upperbounds) {
									// System.out.println("ADDING");
									obj.races.get(w).dogs
											.get(f).TABFormRating = obj.races.get(w).dogs.get(f).winPercentage
													/ (1 / obj.races.get(w).dogs.get(f).winPay);

									obj.races.get(w).selections.add(obj.races.get(w).dogs.get(f));
								}
							}
						//}
							/*
						if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
							y = 1.7;
						}
						if (obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
							y = 2.5;
						}

						if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")
								|| obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
							if (obj.races.get(w).dogs
									.get(f).winPercentage < ((obj.races.get(w).dogs.get(f + 1).winPercentage) * y)) {
								if (obj.races.get(w).typeOfRace.equalsIgnoreCase("harness") && obj.races.get(w).dogs
										.get(f).winPercentage < ((obj.races.get(w).dogs.get(f + 1).winPercentage)
												* 1.5)) {
									break;
								}
								if (obj.races.get(w).dogs.get(f).winPercentage
										/ (1 / obj.races.get(w).dogs.get(f).winPay) > lowerbounds
										&& obj.races.get(w).dogs.get(f).winPercentage
												/ (1 / obj.races.get(w).dogs.get(f).winPay) < upperbounds) {
									// System.out.println("ADDING");
									obj.races.get(w).dogs
											.get(f).TABFormRating = obj.races.get(w).dogs.get(f).winPercentage
													/ (1 / obj.races.get(w).dogs.get(f).winPay);

									obj.races.get(w).selections.add(obj.races.get(w).dogs.get(f));
								}
							}
						}*/
					}
				} catch (Exception j) {
				}

				/*
				 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")
				 * ) { upperbounds = 2;// lowerbounds= 1.05;//LOCKED runners =
				 * 1;//
				 * 
				 * 
				 * } if(obj.races.get(w).typeOfRace.equalsIgnoreCase("harness"))
				 * { upperbounds = 2;// lowerbounds= 1.2; //LOCKED runners =
				 * 1;// }
				 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
				 * upperbounds = 2;// lowerbounds= 1.2;//LOCKED runners = 1;// }
				 * //--------------------------------------------------------
				 * adds runners to selection array //int f=winMultiplyer;
				 * //Collections.sort(obj.races.get(w).dogs,
				 * ObjectDOG.TRAINERWINS);
				 * Collections.sort(obj.races.get(w).dogs,
				 * ObjectDOG.FIXEDODDWINPRICE); //
				 * Collections.sort(obj.races.get(w).dogs,
				 * ObjectDOG.FIXEDODDWINPRICEREAL); for(int f = 0; f <=
				 * runners-1; f++) {
				 * //System.out.println(obj.races.get(w).dogs.get(f).
				 * winPercentage+" "+1/obj.races.get(w).dogs.get(f).winPay);
				 * double y=1.3;
				 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
				 * y=1.5; }
				 * 
				 * 
				 * if(obj.races.get(w).dogs.get(f).winPercentage>((obj.races.get
				 * (w).dogs.get(f+1).winPercentage+obj.races.get(w).dogs.get(f+2
				 * ).winPercentage)*y))
				 * if(obj.races.get(w).dogs.get(f).winPercentage/(1/obj.races.
				 * get(w).dogs.get(f).winPay)>lowerbounds&&
				 * obj.races.get(w).dogs.get(f).winPercentage/(1/obj.races.get(w
				 * ).dogs.get(f).winPay)<upperbounds) {{
				 * //System.out.println("ADDING");
				 * obj.races.get(w).dogs.get(f).TABFormRating=obj.races.get(w).
				 * dogs.get(f).winPercentage/(1/obj.races.get(w).dogs.get(f).
				 * winPay);
				 * 
				 * obj.races.get(w).selections.add(obj.races.get(w).dogs.get(f))
				 * ; }} } }catch(Exception j){}
				 */

				// --------------------------------------------------------finds
				// highest return runner and bets $1
				try {
					Collections.sort(obj.races.get(w).selections, ObjectDOG.TABFORMRATING);
					obj.races.get(w).WIN = obj.races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
					).name();
					obj.races.get(w).WINPAY = obj.races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
					).winPay;
					obj.races.get(w).fixedOddwinDiv=obj.races.get(w).selections.get(0).winPercentage;
				} catch (Exception v) {
				}

				// not needed yet, only going to bet on one dog, bellow will be
				// needed when multiple win bets are used
				// --------------------------------------------------------assigns
				// bet amount to other dogs

				// --------------------------------------------------------add
				// up total wager

				/*
				 * for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
				 * obj.races.get(w).dogs.get(f).fixedOddWinPrice =
				 * Double.parseDouble(
				 * obj.races.get(w).raceDriver.findElement(By.xpath(obj.races.
				 * get(w).dogs.get(f).winxpath)).getText());
				 * obj.races.get(w).dogs.get(f).winPay =
				 * (obj.races.get(w).dogs.get(f).winPercentage)
				 * (obj.races.get(w).dogs.get(f).fixedOddWinPrice);
				 * //System.out.println("win pay " +
				 * currentRace.dogs.get(f).winPay); }
				 * 
				 * Collections.sort(obj.races.get(w).dogs,
				 * ObjectDOG.FIXEDODDWINPRICE);
				 * 
				 * 
				 * 
				 * for (int f = 0; f < 2; f++) { if (obj.races.get(w).wwin ==
				 * false && obj.races.get(w).dogs.get(f).winPay > 1) {
				 * obj.races.get(w).WIN =
				 * obj.races.get(w).dogs.get(f).getName();
				 * obj.races.get(w).WINPAY
				 * =obj.races.get(w).dogs.get(f).fixedOddWinPrice;
				 * System.out.println("win bet made: ");
				 * 
				 * System.out.println(obj.races.get(w).dogs.get(f).getName()+
				 * " : "+obj.races.get(w).dogs.get(f).fixedOddWinPrice);
				 * //winBet(races.get(w).dogs.get(f), races.get(w));
				 * obj.races.get(w).wwin = true; }}}
				 * 
				 * /*if (races.get(w).rave == true && races.get(w).wwin == true)
				 * { races.get(w).raceDriver.close(); races.remove(w);
				 * 
				 * }
				 */

				// System.exit(0);

			}
		}
	}

	public static void fillWithProbabilities() throws IOException {
		// TODO Auto-generated method stub
		try {
			for (int r = 0; r < obj.races.size(); r++) {
				int y = r;

				for (int f = 0; f < obj.races.get(y).dogs.size(); f++) {
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("1") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("2") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "1";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("3") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("4") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "2";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("5") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("6") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "3";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("7") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("8") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "4";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("9") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("10") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "5";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("11") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("12") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "6";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("13") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("14") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "7";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("15") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("16") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "8";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("17") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("18") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "9";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("19") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("20") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "10";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("21") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("22") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "11";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("23") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("24") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "12";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("25") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("26") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "13";
					}
					if (obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("27") == true
							|| obj.races.get(y).dogs.get(f).boxNumber.trim().equalsIgnoreCase("28") == true) {
						obj.races.get(y).dogs.get(f).boxNumber = "14";
					}
				}

				int number = obj.races.get(r).dogs.size();

				Collections.sort(obj.races.get(r).dogs, ObjectDOG.FIXEDODDWINPRICE);

				for (int i = 0; i < obj.races.get(r).dogs.size(); ++i) {
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

						winPercentage = (1 / obj.races.get(r).dogs.get(i).winPay) * 100;
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
							 * "\\"+ obj.races.get(r).dogs.size()+"runners"+ "\\
							 * " +"winProbabilitiesByRankAndPrice"+ "\\" +
							 * "rank"+(d) +"percentage"+percentages.get(t)+
							 * ".txt"));
							 */
							int e=obj.races.get(r).dogs.size()/2;
							int size=e*2;

							// with boxes
							dis = new DataInputStream(
									new FileInputStream("c:\\users\\john\\desktop\\betagrays\\Pricingprobabilities\\"
											+ obj.races.get(r).typeOfRace + "\\" + size
											+ "runners" + "\\" + "winProbabilitiesByRankAndPriceAndBox" + "\\" + "rank"
											+ d + "\\" + "box" + obj.races.get(r).dogs.get(i).boxNumber + "\\"
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
							obj.races.get(r).dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]) + Double.parseDouble(array[2])
									+ Double.parseDouble(array[3]);
							obj.races.get(r).dogs.get(i).trifectaPercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]);
							obj.races.get(r).dogs.get(i).placePercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]);
							obj.races.get(r).dogs.get(i).winPercentage = Double.parseDouble(array[0]);
						}

						if (number < 8) {

							// handle inputInteger here...
							obj.races.get(r).dogs.get(i).firstFourPercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]) + Double.parseDouble(array[2])
									+ Double.parseDouble(array[3]);
							obj.races.get(r).dogs.get(i).trifectaPercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]) + Double.parseDouble(array[2]);
							obj.races.get(r).dogs.get(i).placePercentage = Double.parseDouble(array[0])
									+ Double.parseDouble(array[1]);
							obj.races.get(r).dogs.get(i).winPercentage = Double.parseDouble(array[0]);
						}
						// System.out.println(obj.races.get(r).dogs.get(i).winPercentage);

					}

				}
			}
		} catch (Exception j) {
			j.printStackTrace();
			System.exit(0);
		}
	}

	public static void placeBet(double placeMultiplyer) {
		// TODO Auto-generated method stub
		for (int w = 0; w < obj.races.size(); w++) {
			loop: {

				obj.races.get(w).PLACE = null;
				obj.races.get(w).PLACEPAY = 0;
				obj.races.get(w).place = 0;
				obj.races.get(w).selections.clear();
				
				String[] url = null;
				url = obj.races.get(w).URL.split("/");
				String[] date = null;
				date = url[4].split("-");
				String dateString = date[2] + "/" + date[1] + "/" + date[0];
				DateFormat formatter;
				java.util.Date theDate = null;
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
				System.out.println(dayOfWeek);
				if(dayOfWeek==7){
					//break loop;
				}
				
				if(obj.races.get(w).typeOfRace.equalsIgnoreCase("harness"))
				{
					break loop;
				}
				if(obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds"))
				{
					break loop;
				}

				// System.out.println((obj.races.get(w).URL));
				// IDEA: whole race bet/lay
				// sum of real probabilities must equal 1,
				// dogprobability/sumofprobabilities *1= corrected probability
				// add rake correctedProbability+correctedProbability*.22=
				// corrected probability > than 1/odds then add to selections
				// staking plan

				// --------------------------------------------------------finds
				// sum of average probabilities
				double sumOfProbabilities = 0;
				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					sumOfProbabilities = sumOfProbabilities + obj.races.get(w).dogs.get(f).placePercentage;
					// System.out.println("average percentage
					// "+obj.races.get(w).dogs.get(f).placePercentage+" real
					// Odds "+1/(obj.races.get(w).dogs.get(f).placePay));
				}

				// System.out.println("sum of average percentage
				// "+sumOfProbabilities);
				// --------------------------------------------------------finds
				// sum of real probabilities
				double sumOfRealProbabilities = 0;
				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					sumOfRealProbabilities = sumOfRealProbabilities + (1 / (obj.races.get(w).dogs.get(f).placePay));

				}

				// --------------------------------------------------------correct
				// probabilities
				double r = 3;
				if (obj.races.get(w).dogs.size() < 8) {
					r = r - 1;
				}
				try {
					double firstRunner = obj.races.get(w).dogs.get(0).placePercentage / sumOfProbabilities * r;
					if (firstRunner > 1 / (obj.races.get(w).dogs.get(0).placePay)) {
						// break loop;
					}
				} catch (Exception o) {
				}

				for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
					obj.races.get(w).dogs.get(
							f).placePercentage = (obj.races.get(w).dogs.get(f).placePercentage / sumOfProbabilities)
									* r;
					// System.out.println("new average percentage
					// "+obj.races.get(w).dogs.get(f).placePercentage);
				}

				// int f=placeMultiplyer;
				try {
					double upperbounds = 0;
					double lowerbounds = 0;
					double runners = 0;

					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
						upperbounds = 3;// 3
						lowerbounds = 1.0; // 1.1
						runners = 1;// 2

						/*
						 * upperbounds = 3;//3 lowerbounds= 1.1; //1.1 runners =
						 * 2;//3
						 */
					}
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("harness")) {
						upperbounds = 3;// 3
						lowerbounds = 1.15;// 1.4
						runners = 1;// 2
					}
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
						upperbounds = 3;// 3
						lowerbounds = 1.15;// 1.2
						runners = 3;// 3
						/*
						 * upperbounds = 3;//3 lowerbounds= 1.2;// 1.2 runners =
						 * 3;//3
						 */
					}
					// --------------------------------------------------------adds
					// runners to selection array
					double p = 2.2;
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("greyhounds")) {
						p = 1.0;
					}
					if (obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")) {
						p = 1.0;
					}

					Collections.sort(obj.races.get(w).dogs, ObjectDOG.TRAINERPLACE);
					for (int f = 0; f <= runners - 1; f++) {
						if(f==0)
						{
							f++;
						}
						if(f==1)
						{
							f++;
						}

						if (obj.races.get(w).dogs
								.get(f).placePercentage > ((obj.races.get(w).dogs.get(f + 1).placePercentage) * p)) {
							// System.out.println(obj.races.get(w).dogs.get(f).placePercentage+"
							// "+1/obj.races.get(w).dogs.get(f).placePay);
							if (obj.races.get(w).dogs.get(f).placePercentage
									/ (1 / obj.races.get(w).dogs.get(f).placePay) > lowerbounds
									&& obj.races.get(w).dogs.get(f).placePercentage
											/ (1 / obj.races.get(w).dogs.get(f).placePay) < upperbounds) {
								// System.out.println("ADDING");
								obj.races.get(w).dogs
										.get(f).TABFormRating = obj.races.get(w).dogs.get(f).placePercentage
												/ (1 / obj.races.get(w).dogs.get(f).placePay);

								obj.races.get(w).selections.add(obj.races.get(w).dogs.get(f));
							}
						}
					}
					/*
					 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase(
					 * "greyhounds")) { upperbounds = 2;//3 lowerbounds= 1.1;
					 * //1.1 runners = 2;//2
					 * 
					 * 
					 * }
					 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase("harness"
					 * )) { upperbounds =2;//3 lowerbounds= 1.2;// 1.4 runners =
					 * 2;//2 }
					 * if(obj.races.get(w).typeOfRace.equalsIgnoreCase("racing")
					 * ) { upperbounds = 2;//3 lowerbounds= 1.2;// 1.2 runners =
					 * 2;//3
					 * 
					 * }
					 */
				} catch (Exception o) {
				}
				// --------------------------------------------------------finds
				// highest return runner and bets $1
				try {
					Collections.sort(obj.races.get(w).selections, ObjectDOG.TABFORMRATING);
					obj.races.get(w).PLACE = obj.races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
					).name();
					obj.races.get(w).PLACEPAY = obj.races.get(w).selections.get(0// obj.races.get(w).selections.size()-1
					).placePay;
					obj.races.get(w).winDiv = obj.races.get(w).selections.get(0).placePercentage;
				} catch (Exception v) {
				}

				// not needed yet, only going to bet on one dog, bellow will be
				// needed when multiple win bets are used
				// --------------------------------------------------------assigns
				// bet amount to other dogs

				// --------------------------------------------------------add
				// up total wager

				/*
				 * for (int f = 0; f < obj.races.get(w).dogs.size(); f++) {
				 * obj.races.get(w).dogs.get(f).fixedOddWinPrice =
				 * Double.parseDouble(
				 * obj.races.get(w).raceDriver.findElement(By.xpath(obj.races.
				 * get(w).dogs.get(f).winxpath)).getText());
				 * obj.races.get(w).dogs.get(f).winPay =
				 * (obj.races.get(w).dogs.get(f).winPercentage)
				 * (obj.races.get(w).dogs.get(f).fixedOddWinPrice);
				 * //System.out.println("win pay " +
				 * currentRace.dogs.get(f).winPay); }
				 * 
				 * Collections.sort(obj.races.get(w).dogs,
				 * ObjectDOG.FIXEDODDWINPRICE);
				 * 
				 * 
				 * 
				 * for (int f = 0; f < 2; f++) { if (obj.races.get(w).wwin ==
				 * false && obj.races.get(w).dogs.get(f).winPay > 1) {
				 * obj.races.get(w).WIN =
				 * obj.races.get(w).dogs.get(f).getName();
				 * obj.races.get(w).WINPAY
				 * =obj.races.get(w).dogs.get(f).fixedOddWinPrice;
				 * System.out.println("win bet made: ");
				 * 
				 * System.out.println(obj.races.get(w).dogs.get(f).getName()+
				 * " : "+obj.races.get(w).dogs.get(f).fixedOddWinPrice);
				 * //winBet(races.get(w).dogs.get(f), races.get(w));
				 * obj.races.get(w).wwin = true; }}}
				 * 
				 * /*if (races.get(w).rave == true && races.get(w).wwin == true)
				 * { races.get(w).raceDriver.close(); races.remove(w);
				 * 
				 * }
				 */

				// System.exit(0);

			}
		}

	}

	public static void makeSmallObj() throws IOException {
		// TODO Auto-generated method stub

		smallObj = new database();
		for (int w = obj.races.size() - (10000); w < obj.races.size(); w++) {
			smallObj.races.add(obj.races.get(w));
		}
		// write to disk with fileOutputStream
		FileOutputStream f_out = new FileOutputStream("mySmallobject.data");
		// write object with ObjectOutputStream
		ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
		// write object out to disk
		obj_out.writeObject(smallObj);

		obj_out.close();
	}

	public static void populateSmallDatabase() {
		// TODO Auto-generated method stub

		try {
			// read from disk using FileInputStream
			FileInputStream f_in = new FileInputStream("mySmallobject.data");

			// read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// read the object
			obj = (database) obj_in.readObject();
			obj_in.close();
		} catch (Exception r) {
			r.printStackTrace();
		}

		System.out.println(obj.races.size());
		System.out.println("complete");

	}

	public static void getTrackCondition() throws IOException {
		// TODO Auto-generated method stub
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.load.strategy", "unstable");
		profile.setPreference("dom.max_chrome_script_run_time", 0);
		profile.setPreference("dom.max_script_run_time", 0);
		WebDriver driver = new FirefoxDriver(profile);
		PrintWriter track = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\betagrays\\reports\\track.txt"));
		WebDriverWait twait = new WebDriverWait(driver, 20);
		
		for(int  e=0;e<obj.races.size();e++)
		{
			if(obj.races.get(e).WIN!=null&&obj.races.get(e).WIN.equalsIgnoreCase("empty")==false)
			{
				driver.get(obj.races.get(e).URL);
				try{
				twait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[3]/div[2]")));}catch(Exception p){}
				twait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[3]/div[2]")));
				String txt = driver
						.findElement(By
								.xpath("/html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[3]/div[2]"))
						.getText();
				track.println(txt);
				
			}
		}
		track.close();
		
	}
}
