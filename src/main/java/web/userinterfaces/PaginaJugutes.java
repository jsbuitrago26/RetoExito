package web.userinterfaces;

import net.serenitybdd.screenplay.targets.BaseTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaginaJugutes {
    public static Target elementos= Target.the("Sabemos la cantidad de elementos").
            located(By.xpath("//*[@class='vtex-flex-layout-0-x-flexRow vtex-flex-layout-0-x-flexRow--searchResult']"));
    public static Target elemntoFinal= Target.the("Bajamos").
            located(By.xpath("//*[@class='vtex-button__label flex items-center justify-center h-100 ph5 ']"));
    public static Target elementosPrecio=Target.the("Elementos precio").
            located(By.xpath("//*[@class='exito-vtex-components-4-x-selling-price flex items-center ']"));
    public static Target anhadir=Target.the("Seleccionamos la cantidad de productos").
            located(By.xpath("//*[@class='shelf-exito-vtex-components-buy-button-manager-more']"));
    public static Target agregarCarrito=Target.the("Seleccionamos el productp").
            located(By.xpath("//*[@class='exito-vtex-components-4-x-buttonDataContainer flex justify-center']"));;
}
