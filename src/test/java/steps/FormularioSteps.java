package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.FormularioPage;

import static org.junit.Assert.*;

public class FormularioSteps {

    public static WebDriver driver; // ← Hacemos el driver estático y público
    FormularioPage formulario;

   @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        formulario = new FormularioPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("el usuario abre el formulario")
    public void elUsuarioAbreElFormulario() {
        formulario.abrirFormulario();
    }

    @When("completa el formulario con nombre {string}, email {string}, barrio {string}, asunto {string}, mensaje {string}")
    public void completaFormulario(String nombre, String email, String barrio, String asunto, String mensaje) {
        formulario.completarFormulario(nombre, email, barrio, asunto, mensaje);
    }

    @When("presiona el boton Enviar")
    public void presionaElBotonEnviar() {
        formulario.enviarFormulario();
    }

    @Then("no deben mostrarse alertas")
    public void noDebenMostrarseAlertas() {
    boolean hayErroresVisuales = formulario.hayAlertas();       // detecta mensajes visibles
    boolean hayAlertasJS = formulario.hayAlertaJS();            // detecta alertas emergentes
    assertFalse("Se mostraron alertas inesperadas", hayErroresVisuales || hayAlertasJS);
}

    @Then("deben mostrarse alertas en los campos")
    public void debenMostrarseAlertas() {
        assertTrue("No se mostraron alertas esperadas", formulario.hayAlertas());
    }

    @Then("debe mostrarse la alerta generica de error")
public void debeMostrarseLaAlertaGenericaDeError() {
    boolean alerta = formulario.alertaGenericaPresente();
    if (!alerta) {
        System.out.println("No se mostro alerta emergente, pero podría haber alertas inline.");
    }
    assertTrue("No se mostro la alerta generica esperada", alerta);
}

}
