  #Autor: Miguel Buitrago
#language:es
  Característica:  Compra de productos en Tiendas Éxito

  Antecedentes: Se debe ingresar al ambiente de pruebas para las validaciones
      Dado que miguel ingresa a la pagina exito
      Y migel se encuentra en la categoria "Juguetería" y subcategoria   "juguetes"
      Cuando miguel seleciona 5 productos con cantidaddes entre 1 y 10

    @PaginaExito
    Escenario:  Verificacion de los nombres de los prodcuto esocgidos correspondan a la informacion del carrito
      Entonces verifico que los nombre de los productos agregados sean iaguales a los nombres de los productos en el carrito

    @PaginaExitoPrecioTotalDeLosProductos
    Escenario: Verificar que los precios de los productos seleccionados correspondan a los del carrito
      Entonces Se verifica que los precios de los productos en el carrito correspondan a los precios de los productos seleccionados