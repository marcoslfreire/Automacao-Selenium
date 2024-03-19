package src.utils.drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Utilitarios extends DriversManager{
    private static final int tempoEspera = 30;
    private static final String separadorLog = "& ";

    // Tratamento de pop-up
    public static void mudarContexto() throws Exception {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    // Tratamento fechar pop-up
    public static void fecharContexto() throws Exception {
        for (String winHandleBefore : driver.getWindowHandles()) {
            driver.switchTo().window(winHandleBefore);
        }
    }
    public static void selectListOptionByName(String name, String valor, String step, String tela) throws Exception {
        By element = By.xpath("//select[@name='" + name + "']/option[@value='" + valor + "']");
        clickComum(element, step, tela);
    }
    public static void selectListContainsTextByID(String id, String valor, String step, String tela) throws Exception {
        By element = By.xpath("//select[@id='"+id+"']/option[contains(text(),'"+valor+"')]");
        clickComum(element, step, tela);
    }
    public static void selectListContainsTextByName(String name, String valor, String step, String tela) throws Exception {
        By element = By.xpath("//select[@name=\""+name+"\"]/option[contains(text(),'"+valor+"')]");
        clickComum(element, step, tela);
    }
    public static void selecionarCheckbox(String oferta, String step, String tela) throws Exception {
        By checkbox = new By.ByXPath("//*[text()='" + oferta + "'][not(contains(@style,'DISPLAY: none'))]//parent::td//parent::tr/td/input[@type='checkbox']");
        clickComum(checkbox, step, tela);
    }
    public static void selecionarCheckboxVisivel(String oferta, String step, String tela) throws Exception {
        By checkbox = new By.ByXPath("//*[text()='" + oferta + "']//parent::tr[not(contains(@style,'DISPLAY: none'))]/td/input[@type='checkbox']");
        clickComum(checkbox, step, tela);
    }
    public static void clicarNaLupaCorrespondente(String tipoDistribuicao, String step, String tela) throws Exception {
        By lupa = new By.ByXPath("//td[contains(text(),'" + tipoDistribuicao + "')]//parent::td//parent::tr/td/a");
        clickComum(lupa, step, tela);
    }
    public static void selecionarContaCorrespondente(String nomeConta, String step, String tela) throws Exception {
        By linkConta = new By.ByXPath("//td[text()='" + nomeConta + "']//parent::tr//td//a");
        clickComum(linkConta, step, tela);
    }
    public static boolean elementoEstaPresente(By by, int time) {
        boolean isPresente;
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(time));
            espera.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            isPresente = true;
        } catch (Exception e) {
            isPresente = false;
        }
        return isPresente;
    }

    public static boolean elementoClicavel(By by){
        boolean isPresente;
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            espera.until(ExpectedConditions.elementToBeClickable(by));
            isPresente = true;
        }
        catch (Exception e)
        {
            isPresente = false;
        }
        return isPresente;
    }

    public static void enviaDados(By by, String valor, String step, String tela) throws Exception {
        WebElement element = null;
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            espera.until(ExpectedConditions.presenceOfElementLocated(by));
            espera.until(ExpectedConditions.elementToBeClickable(by));
            element = driver.findElement(by);
            element.click();
            element.clear();
            element.sendKeys(valor.trim());
        } catch (Exception e) {
            String mensagemErro = "MOBILE - Erro ao preencher elemento: '"+by+"', step: '"+step+"', tela: '"+tela+"', tempo de espera: "+tempoEspera+"s " + separadorLog + e.toString();

            System.err.println(mensagemErro);
//            TestRun.mensagemErro = mensagemErro;
            throw new Exception(mensagemErro);
        }
    }

    public static void clickComum(By by, String step, String tela) throws Exception {
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            espera.until(ExpectedConditions.presenceOfElementLocated(by));
            espera.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            String mensagemErro = "Erro ao aguardar elemento se tornar visível/clicável: '"+by+"', step: '"+step+"', tela: '"+tela+"', tempo de espera: "+tempoEspera+"s " + separadorLog + e.toString();

            System.err.println(mensagemErro);
            throw new Exception(mensagemErro);
        }
        try {
            WebElement elemento = driver.findElement(by);
            elemento.click();
        } catch (Exception e) {
            String mensagemErro = "Erro ao clicar no elemento: '" + by + "', step: '" + step + "', tela: '" + tela + "', tempo de espera: "+tempoEspera+"s " + separadorLog + e.toString();

            System.err.println(mensagemErro);
            throw new Exception(mensagemErro);
        }
    }

}
