package web.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import web.userinterfaces.PaginaJugutes;

public class ProductoAleatorio implements Interaction {
    public int cantidadProductos;
    private int cantidadMin;
    private int cantidadMax;
    public ProductoAleatorio(int cantidadProductos,int cantidadMin,int cantidadMax){

        this.cantidadProductos=cantidadProductos;
        this.cantidadMin = cantidadMin;
        this.cantidadMax = cantidadMax;
    }
    public static ProductoAleatorio cantidad(int cantidadProductos,int cantidadMin,int cantidadMax) {
        return new ProductoAleatorio(cantidadProductos,cantidadMin,cantidadMax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                // Scroll.to(PaginaJugutes.elemntoFinal),
                EsperarElementos.objeto(PaginaJugutes.elementos),
                RandomArreglo.randomArreglo(cantidadProductos,PaginaJugutes.elementos,cantidadMin,cantidadMax)

       );



    }
}
