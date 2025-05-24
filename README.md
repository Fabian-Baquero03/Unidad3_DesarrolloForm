# Automatización de Pruebas - Formulario Web (Softesting)

Este proyecto automatiza la validación funcional de un formulario web disponible en `http://64.227.54.255/Softesting/Frontend/Caso1.html`. La solución utiliza **Selenium WebDriver** junto con **Cucumber** y está escrita en **Java**, siguiendo el patrón **Page Object Model (POM)**.

---

##  Tecnologías y dependencias

- **Lenguaje**: Java 17  
- **Framework de automatización**: Selenium WebDriver 4.18.1  
- **Framework BDD**: Cucumber Java 7.11.2  
- **Ejecución**: JUnit 4.13.2  
- **Gestor de dependencias**: Maven  
- **Driver utilizado**: ChromeDriver 124.x

---

##  Características destacables de esta solución

- **Separación clara de responsabilidades** mediante el uso del patrón Page Object Model.
- **Cobertura funcional completa** con casos positivos y negativos relevantes.
- **Validación robusta** tanto de errores visuales (inline) como de alertas emergentes del navegador.
- **Ejecución basada en BDD** legible y mantenible gracias al uso de Gherkin.
- **Escalabilidad**: la solución permite fácilmente agregar nuevos escenarios o adaptarse a otros formularios.

---

## 🧪 Casos de prueba documentados (Escenarios Gherkin)

| ID | Nombre del Escenario | Entrada | Resultado Esperado |
|----|-----------------------|---------|---------------------|
| TC01 | Envío exitoso con datos válidos | Nombre: Carlos<br>Email: carlos@abc.com<br>Barrio: Centro<br>Asunto: Consulta<br>Mensaje: Hola | No deben mostrarse alertas |
| TC02 | Envío exitoso con otros datos válidos | Nombre: Mariana<br>Email: mariana@abc.com<br>Barrio: Norte<br>Asunto: Reclamo<br>Mensaje: Texto largo | No deben mostrarse alertas |
| TC03 | Envío exitoso con nombre/asunto largos | Nombre: Alejandro<br>Email: ale@abc.com<br>Barrio: Sur<br>Asunto: Solicitud importante<br>Mensaje: Mensaje cualquiera | No deben mostrarse alertas |
| TC04 | Fallo por nombre y email inválidos | Nombre: 1<br>Email: jj.com<br>Barrio: Centro<br>Asunto: o<br>Mensaje: p | Deben mostrarse alertas en los campos y alerta emergente de error |
| TC05 | Fallo por email sin arroba | Nombre: Laura<br>Email: lauragmail.com<br>Barrio: Oeste<br>Asunto: Aviso<br>Mensaje: Texto | Deben mostrarse alertas en los campos y alerta emergente de error |

---

##  Ejecución del proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Fabian-Baquero03/Unidad3_DesarrolloForm.git
   ```
2. Importar como proyecto Maven en tu IDE (VS Code, IntelliJ, Eclipse).
3. Ejecutar el archivo `TestRunner.java`.

---

##  Estructura de carpetas

```
Automatizacion-Formulario/
├── features/
│   └── formulario.feature
├── pages/
│   └── FormularioPage.java
├── steps/
│   └── FormularioSteps.java
├── runner/
│   └── TestRunner.java
├── pom.xml
└── README.md
```

---

##  Consideraciones

- El formulario no presenta respuestas explícitas en pantalla al éxito, por lo que la verificación se basa en ausencia de alertas.
- Las validaciones cubren alertas inline y alertas del navegador (`alert()`).
- Se utilizó una espera explícita (`WebDriverWait`) para garantizar estabilidad ante cargas lentas.

---