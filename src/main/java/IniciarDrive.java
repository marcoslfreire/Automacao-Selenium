import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IniciarDrive {
    public static void main(String[] args) {
        // Configurando o caminho para o ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\AutomacaoSelenium\\AutomacaoSeleniumdrivers/chromedriver");
        // Inicializando o WebDriver do Chrome
        WebDriver driver = new ChromeDriver();

        // Exemplo: Abrir uma página
        driver.get("https://br.linkedin.com/");

        // Exemplo: Fechar o navegador
        driver.quit();
    }
}
