Feature: Compra de productos en la app Éxito

  Scenario: Agregar producto al carrito
    Given que el usuario ha abierto la app Éxito
    When el usuario inicia sesión con correo "ejemplo@ejemplo.com" y contraseña "secreta"
    And el usuario agrega el producto "Camiseta" al carrito
    Then el producto "Camiseta" se agrega correctamente al carrito
