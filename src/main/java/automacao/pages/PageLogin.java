package automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.utils.drivers.Utilitarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static src.utils.drivers.DriversManager.abrirBrowser;
import static src.utils.drivers.DriversManager.driver;

//Page Object para a pagina de login
public class PageLogin extends Utilitarios {

    public static WebDriverWait wait;
    public static String tela = "Pagina de Login";
    public static String step = "AbrirInstanciaNavegador - RealizarLogin";

    // Mapeamento dos elementos
    public static By campoUsuario = new By.ByXPath("//*[@id=\"session_key\"]");
    public static By campoSenha = new By.ByXPath("//input[@id=\"session_password\" and @name=\"session_password\" and @type=\"password\"]\n");
    public static By btnEntrar = new By.ByXPath("//button[normalize-space(text())=\"Entrar\"]\n");

    // Funcao para executar os metodos
    public static void execute(String navegador, String url, String user, String psw) throws Exception {
        System.out.println("Step -> " + step);
        iniciaDriver(navegador);
        iniciaNavegador();
        realizaLogin(url, user, psw);
    }

    //Inicializa Chromedriver
    public static void iniciaDriver(String navegador) throws Exception {
        try {
            driver = abrirBrowser(navegador);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            String mensagemErro = "Erro ao iniciar instancia do driver e navegador";
            System.err.println(mensagemErro);
            throw new Exception(mensagemErro);
        }
    }

    //Inicializa instancia do WebDriverWait
    public static void iniciaNavegador() throws Exception {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        } catch (Exception e) {
            String mensagemErro = "Erro ao inicializar instancia do WebDriverWait";
            System.err.println(mensagemErro);
            throw new Exception(mensagemErro);
        }
    }

    public static void realizaLogin(String url, String user, String psw) throws Exception {
        driver.get(url);

        elementoClicavel(campoUsuario);
        enviaDados(campoUsuario, user, step, tela);
        enviaDados(campoSenha, psw, step, tela);
        clickComum(btnEntrar, step, tela);
    }
}

