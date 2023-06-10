package web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCarrito {
    public static Target carro=Target.the("Ingresamos al carrito").
            located(By.className("exito-header-3-x-minicartQuantity"));
    public static Target correo=Target.the("Ingresamos el correo").
            located(By.xpath("//*[@type='email']"));
    public static Target BTN_confirmar=Target.the("Ingresamos al carrito").
            located(By.className("exito-checkout-io-0-x-preLoginActiveButton"));
    public static String item="((//*[@class='exito-checkout-io-0-x-itemCartContent'])[";
    public static String complementoNombre="]/div/div)[4]";
    public static String complementoPrecio="]/div/div)[5]";
    public static String complementoCantidad="]/div/div)[6]/div/div";
   // public static String itemCompletoNombre;

    public static Target[] informacioProducto(int i) {
        String seleccionProducto=Integer.toString(i);
        String itemCompletoNombre=item+seleccionProducto+complementoNombre;
        String itemCompletoCantidad=item+seleccionProducto+complementoCantidad;
        String itemCompletoPrecio=item+seleccionProducto+complementoPrecio;
        Target infProductoNombre = Target.the("Informacion del producto").
                located(By.xpath(itemCompletoNombre));
        Target infProductoPrecio = Target.the("Informacion del producto precio").
                located(By.xpath(itemCompletoPrecio));
        Target infProductoCantidad = Target.the("Informacion del producto cantidad").
                located(By.xpath(itemCompletoCantidad));
        Target[] informacionProducto={infProductoNombre,infProductoPrecio,infProductoCantidad} ;
        return informacionProducto ;
    }

}
