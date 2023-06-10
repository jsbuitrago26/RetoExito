package web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {
    public static Target SeleccionSubcategoria=Target.the("Selecciona la subcategoria").
            located(By.id("Categorías-nivel2-Juguetes"));

    public static Target BTN_menu=Target.the("Ingresar al menu").
            located(By.id("Trazado_7822"));
    public static Target BTN_categoria=Target.the("Selecciona la categoria").
            located(By.id("undefined-nivel2-Juguetería"));
}
