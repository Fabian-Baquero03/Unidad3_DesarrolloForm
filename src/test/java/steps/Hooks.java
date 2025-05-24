package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = FormularioSteps.driver;

        if (driver != null && scenario.isFailed()) {
            try {
                // Verificar si hay una alerta JS abierta
                Alert alert = driver.switchTo().alert();
                String mensaje = alert.getText();
                scenario.log("Alerta inesperada detectada: " + mensaje);
                alert.accept(); // puedes usar alert.dismiss() si prefieres
            } catch (NoAlertPresentException e) {
                // No hay alerta activa, todo ok
            }

            try {
                // Captura de pantalla al fallar
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Captura del fallo");
            } catch (Exception e) {
                scenario.log(" Error al tomar captura: " + e.getMessage());
            }
        }
    }
}
