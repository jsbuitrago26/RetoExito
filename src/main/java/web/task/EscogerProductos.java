package web.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import web.interaction.EsperarElementos;
import web.interaction.ProductoAleatorio;
import web.userinterfaces.PaginaJugutes;

import java.awt.*;

public class EscogerProductos implements Task {
    public  int cantidadProductos;
    public  int cantidadMin;
    public  int cantidadMax;

    public EscogerProductos(int cantidadProductos,int cantidadMin,int cantidadMax){
        this.cantidadProductos=cantidadProductos;
        this.cantidadMin=cantidadMin;
        this.cantidadMax=cantidadMax;
    }

    public static EscogerProductos seleccionar(int cantidadProductos, int cantidadMin, int cantidadMax) {
        return Tasks.instrumented(EscogerProductos.class,cantidadProductos,cantidadMin,cantidadMax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      /*  WebDriver driver= BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");*/
        EsperarElementos.tiempo(10000);

        actor.attemptsTo(

                ProductoAleatorio.cantidad(cantidadProductos,cantidadMin,cantidadMax),
                Agregar.productos(cantidadProductos,cantidadMin,cantidadMax)
               // Cantidad.porProducto(cantidadMin,cantidadMax)
        );

    }
}
