import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class TAB {
	public static WebDriver drivers;

	

	public static void start() throws IOException {
		// TODO Auto-generated method stub
		// giveTimeDouble();

		// checkTimeBETTING(simpleDateHyphens);
		// checkTimeRESULTS();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.load.strategy", "unstable");
		drivers = new FirefoxDriver(profile);
		
		
		
		drivers.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		robot.login(drivers);
		getResults();

		

		for (int u = 0; u < 15; u++) {

			try {

				for (String winHandle : drivers.getWindowHandles()) {
					drivers.switchTo().window(winHandle);
					drivers.close();
					;
				}
			} catch (Exception i) {
				i.printStackTrace();
			}

		}

	}

	

	

	private static void getResults() {
		// TODO Auto-generated method stub
		
		
		System.out.println("got get results");
		
		for(int g=0; g< robot.todaysRaces.size();g++)
		{
			
			if(robot.todaysRaces.get(g).positioningComplete==false)
			{
			
		
		for(int t=1;t<10000;t++)
		{
			//System.out.println(t);
			
			try{
				
				
				try{
					drivers.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
					drivers.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					drivers.get(robot.todaysRaces.get(g).URL);
				}catch(Exception u){
					try{
						drivers.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
						drivers.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
						drivers.get(robot.todaysRaces.get(g).URL);
					}catch(Exception f){
						drivers.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
						drivers.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
						drivers.get(robot.todaysRaces.get(g).URL);
					}
					}
			
			
			
			
			WebDriverWait twait = new WebDriverWait(drivers, 60);
			
			//check if abandoned
			twait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[3]/ul/li[1]")));
			
			if((drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[3]/ul/li[1]")).getText()).equalsIgnoreCase("Abandoned"))
			{robot.todaysRaces.remove(g);
			
			throw new Exception("no race");}
			
			//twait.until(ExpectedConditions.invisibilityOfElementLocated(
					//By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[1]")));
			
			
			// first place presence
			//twait.until(ExpectedConditions.visibilityOfElementLocated(
				//	By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[1]/td[3]")));
			
			// quinella results table presence
			twait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr[1]/td[3]/div/div")));
			
			
			
			try {
				Thread.sleep(10000);

			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
			
			
			
			
			
			/*twait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[4]/div/div[1]")));
			
			twait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[4]/div/div[2]")));
			
			twait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[1]")));*/
			/*String location = driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[1]/span/div[1]/div[1]/div/div/div[2]")).getText();
			System.out.println("9");
			String raceNumber = driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[1]/header/div[2]/div[1]")).getText().replace("R", "");
			System.out.println("10");
			if((location.equals(robot.todaysRaces.get(g).raceVenue))==true&&(raceNumber.equals(robot.todaysRaces.get(g).raceNumber))==true)
			{break;}*/
			
			
			
			
			
		
			String[] array;
		String firstString =(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[1]/td[3]")).getText());
		array = firstString.split("\n");
	//	.replaceAll("[^\\d.]", "").replace(".","");
		robot.todaysRaces.get(g).firstPlace = array[0].replaceAll("\\d","").replace(".","").trim();
		String secondString =(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[2]/td[3]")).getText());
		array = secondString.split("\n");
	//	.replaceAll("[^\\d.]", "").replace(".","");
		robot.todaysRaces.get(g).secondPlace = array[0].replaceAll("\\d","").replace(".","").trim();
		String thirdString =drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[3]/td[3]")).getText();
		array = thirdString.split("\n");
	//	.replaceAll("[^\\d.]", "").replace(".","");
		robot.todaysRaces.get(g).thirdPlace = array[0].replaceAll("\\d","").replace(".","").trim();
	try{
		String fourthString =drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[1]/tbody/tr[4]/td[3]")).getText();
		array = fourthString.split("\n");
	//	.replaceAll("[^\\d.]", "").replace(".","");
		robot.todaysRaces.get(g).fourthPlace = array[0].replaceAll("\\d","").replace(".","").trim();
	}catch(Exception s){}
		
		
	
	
	
	
	
	
	
		//robot.todaysRaces.get(g).winDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[5]/div/div[1]")).getText()).replace("$","")+"");
		
		//robot.todaysRaces.get(g).fixedOddwinDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[4]/div/div[1]")).getText()).replace("$","")+"");
		//robot.todaysRaces.get(g).secondplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[2]/td[5]/div/div[1]")).getText()).replace("$","")+"");
	//	robot.todaysRaces.get(g).fixedsecondplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[2]/td[4]/div/div")).getText()).replace("$","")+"");
		//robot.todaysRaces.get(g).fixedthirdplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[3]/td[4]/div/div")).getText()).replace("$","")+"");
	//	robot.todaysRaces.get(g).thirdplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[3]/td[5]/div/div[1]")).getText()).replace("$","")+"");
		//robot.todaysRaces.get(g).firstplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[5]/div/div[2]")).getText()).replace("$","")+"");
	//	robot.todaysRaces.get(g).fixedfirstplaceDiv = Double.parseDouble((driver.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div/section/table[1]/tbody/tr[1]/td[4]/div/div[2]")).getText()).replace("$","")+"");
		
		
		
		for(int p = 1;p<11;p++)
		{try{
			
			if(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[1]")).getText().equalsIgnoreCase("Quinella")==true )
			{
				robot.todaysRaces.get(g).quinellaDiv = Double.parseDouble(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[3]/div/div")).getText().replace("$","").replace(",",""));
			}
			if(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[1]")).getText().equalsIgnoreCase("Trifecta")==true )
			{
				robot.todaysRaces.get(g).trifectaDiv = Double.parseDouble(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[3]/div/div")).getText().replace("$","").replace(",",""));
			}
			if(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[1]")).getText().equalsIgnoreCase("First Four")==true )
			{
				robot.todaysRaces.get(g).firstFourDiv = Double.parseDouble(drivers.findElement(By.xpath("html/body/ui-view/main/div[1]/ui-view/div/ui-view/div[3]/div[2]/section/table[2]/tbody/tr["+p+"]/td[3]/div/div")).getText().replace("$","").replace(",",""));
							
			}
		}catch(Exception v){}
			
		}
		
		break;
			}catch(Exception a){//a.printStackTrace();
			}	
			}
		
		
		}}drivers.close();
		

	}

	

	

	

	

}
