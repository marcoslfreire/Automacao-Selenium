import automacao.pages.PageLogin;
import org.junit.Test;

import static src.utils.drivers.DriversManager.driver;

public class Run {

    @Test
    public void Ativar() throws Exception {
        PageLogin.execute("chrome", "https://br.linkedin.com/", "marcos3dt@gmail.com", "");
        driver.quit();
    }
}
