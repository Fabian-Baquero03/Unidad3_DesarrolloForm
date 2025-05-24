package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormularioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirFormulario() {
        driver.get("http://64.227.54.255/Softesting/Frontend/Caso1.html");
    }

    public void completarFormulario(String nombre, String email, String barrio, String asunto, String mensaje) {
    escribir(By.xpath("//input[@id='nombre']"), nombre); // XPath
    escribir(By.cssSelector("input[name='email']"), email); // CSS Selector
    escribir(By.xpath("//input[@name='barrio']"), barrio); // XPath
    escribir(By.name("asunto"), asunto); // Por nombre
    escribir(By.cssSelector("textarea[name='Mensaje']"), mensaje); // CSS Selector (convertido desde JS)
}


    public void enviarFormulario() {
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        boton.click();
    }

   public boolean hayAlertas() {
    try {
        // Si hay alerta emergente
        wait.until(ExpectedConditions.alertIsPresent());
        return true;
    } catch (Exception e) {
        // Revisar alertas inline si no hay emergentes
        return driver.findElements(By.cssSelector(".alert")).size() > 0;
    }
}

    public boolean alertaGenericaPresente() {
        try {
            Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
            String textoAlerta = alerta.getText();
            alerta.accept();
            return textoAlerta.contains("UPPPPS ALGO HA FALLADO");
        } catch (Exception e) {
            return false;
        }
    }
    
    private void escribir(By selector, String texto) {
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        campo.clear();
        campo.sendKeys(texto);
    }

    public boolean hayAlertaJS() {
    try {
        driver.switchTo().alert();
        return true;
    } catch (NoAlertPresentException e) {
        return false;
    }
}
    
}
