package web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCarrito {
    public static Target carro=Target.the("Ingresamos al carrito").
            located(By.xpath("(//*[@class='vtex-menu-2-x-header-link-icon '])[2]"));
    public static Target correo=Target.the("Ingresamos el correo").
            located(By.xpath("//*[@type='email']"));
    public static Target BTN_confirmar=Target.the("Ingresamos al carrito").
            located(By.xpath("//*[@class='exito-checkout-io-0-x-preLoginActiveButton']"));
}
