import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Selenium");

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
//        System.setProperty("webdriver.ie.driver",src/resources/chromedriver.exe");
//        // Inicijalizacija Internet Explorer WebDrivera
//        WebDriver driver = new InternetExplorerDriver();

        // Define ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allowed-ips=178.237.216.5");

        WebDriver driver = new ChromeDriver();

        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://www.whatismyip.com/");
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = (WebElement) driver.findElements(By.cssSelector("input[name='username']"));
        usernameField.sendKeys("tomsmith");


//        WebElement usernameField = (WebElement) driver.findElements(By.cssSelector("#password"));    //.id i .css staticke metode abstractne klase By
        WebElement passwordField = (WebElement) driver.findElements(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

//        WebElement loginButton1 = (WebElement) driver.findElement(By.className("fa fa-2x fa-sing-in"));    //i[class='fa fa-2x fa-sign-in']
        WebElement loginButton = driver.findElement(By.cssSelector(".fa"));
        loginButton.click();

        WebElement logInText = (WebElement) driver.findElements(By.id("flash"));
        String actualColor = logInText.getCssValue("background-color");

//        System.out.println("Boja: "+ actualColor);     //Boj: rgba(93,164,35,1) --> Hex to RGBA Converter: #5da423
        String expectedColour = "rgba(93,164,35,1)";
        if (actualColor.equals(expectedColour)){
            System.out.println("Test je prosao");

        }else{
            System.out.println("Test je pao");
        }

//        driver.close();     //zatvara samo trenutni tab
        driver.quit();   //zatvara sve tabove


    }
}