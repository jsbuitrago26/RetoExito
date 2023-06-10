package web.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.interaction.EsperarElementos;
import web.userinterfaces.PaginaCarrito;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import net.serenitybdd.screenplay.targets.Target;
public class Dirigirse implements Task {
    public static Dirigirse carrito() {
        return Tasks.instrumented(Dirigirse.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(

                Click.on(PaginaCarrito.carro),

               WaitUntil.the(PaginaCarrito.correo,isVisible()).forNoMoreThan(20).seconds(),
               Enter.theValue("prueba@gmail.com").into(PaginaCarrito.correo),
                WaitUntil.the(PaginaCarrito.BTN_confirmar,isClickable()),
                Click.on(PaginaCarrito.BTN_confirmar)


        );
       // EsperarElementos.tiempo(5000);


    }
}
