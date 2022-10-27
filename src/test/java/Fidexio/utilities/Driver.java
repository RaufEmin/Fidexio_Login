package Fidexio.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.encoders.UrlBase64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static InheritableThreadLocal<WebDriver>driverpool=new InheritableThreadLocal<WebDriver>();
    /*
    We make Webdriver private,because we want to close access from outside of the class
    We make it static because we will use it in a static method
    */
    //private static WebDriver driver;

       /*
       Create a re-usable utility method which will return same driver instance when we call it

        */



    public static WebDriver getDriver(){
        if (driverpool.get()==null){
              /*
              We read our browserType from configuration.properties.
              This way,we can control which browser is opened from outside our code,from configuration.properties.
               */

            String browserType= ConfigurationReader.getProperty("browser");

              /*
               Depending on the browserType that will be return from configuration.properties file
               switch statement will determine the case,and open the matching browser

               */

            switch (browserType){
                case "remote-chrome":
                    try{
                        String gridAddress="54.88.109.226 ";
                        URL url=new URL("http://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverpool.set(new RemoteWebDriver(url,desiredCapabilities));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driverpool.set(new ChromeDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverpool.set(new FirefoxDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }
        return  driverpool.get();
    }

    /*
      this method will make sure our driver value is always null after using quit()method

     */
    public static void closeDriver(){
        if (driverpool.get()!=null){
            driverpool.get().quit();//this line will terminate the existing session.value will not even be null
            driverpool.remove();

        }
    }




}
