package src.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriversManager {
    public static WebDriver driver;

    public static WebDriver abrirBrowser(String browser) throws MalformedURLException {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
//
////          Options para executar sem abrir o Browser.
////          habilitar todos e desabilitar os de browser aberto para executar sem abrir o browser
//            options.addArguments("--headless"); // habilitar para executar sem abrir o browser
//            options.addArguments("--no-sandbox"); // habilitar para executar sem abrir o browser
//            options.addArguments("--start-maximized"); // habilitar para executar sem abrir o browser
//            options.addArguments("--window-size=2560,1440"); // habilitar para executar sem abrir o browser
//            options.addArguments("--window-size=3840,2160"); // habilitar para executar sem abrir o browser
////
////          Options para executar com o Browser do chrome aberto.
////          desabilitar os options acima e habilitar todos abaixo para executar com browser
////
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--enable-javascript");
            options.addArguments("--test-type");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-web-security");
            options.addArguments("--force-device-scale-factor=0.8'"); // escala
            options.addArguments("--lang=pt-BR");
            options.addArguments("--disable-geolocation");
            options.addArguments("--enable-automation");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--remote-allow-origins=*");
//
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Não foi possível abrir o browser escolhido");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
