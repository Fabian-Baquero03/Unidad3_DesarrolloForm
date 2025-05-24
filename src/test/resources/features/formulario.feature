Feature: Validacion del formulario

  @Formulario
  Scenario: Envio exitoso con datos validos
    Given el usuario abre el formulario
    When completa el formulario con nombre "Carlos", email "carlos@abc.com", barrio "Centro", asunto "Consulta", mensaje "Hola"
    And presiona el boton Enviar
    Then no deben mostrarse alertas

  @Formulario
  Scenario: Envio exitoso con datos validos distintos
    Given el usuario abre el formulario
    When completa el formulario con nombre "Mariana", email "mariana@abc.com", barrio "Norte", asunto "Reclamo", mensaje "Texto largo"
    And presiona el boton Enviar
    Then no deben mostrarse alertas

  @Formulario
  Scenario: Envio exitoso con nombre y asunto largos
    Given el usuario abre el formulario
    When completa el formulario con nombre "Alejandro", email "ale@abc.com", barrio "Sur", asunto "Solicitud importante", mensaje "Mensaje cualquiera"
    And presiona el boton Enviar
    Then no deben mostrarse alertas

  @Formulario
  Scenario: Fallo por nombre y email invalidos
    Given el usuario abre el formulario
    When completa el formulario con nombre "1", email "jj.com", barrio "Centro", asunto "o", mensaje "p"
    And presiona el boton Enviar
    Then deben mostrarse alertas en los campos
    And debe mostrarse la alerta generica de error

  @Formulario
  Scenario: Fallo por email sin arroba
    Given el usuario abre el formulario
    When completa el formulario con nombre "Laura", email "lauragmail.com", barrio "Oeste", asunto "Aviso", mensaje "Texto"
    And presiona el boton Enviar
    Then deben mostrarse alertas en los campos
    And debe mostrarse la alerta generica de error



