package web.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import net.serenitybdd.screenplay.targets.Target;
import web.interaction.Cantidad;
import web.interaction.EsperarElementos;
import web.userinterfaces.PaginaCarrito;
import web.userinterfaces.PaginaJugutes;

import java.util.List;

public class Agregar implements Task {

    private final int cantidadMin;
    private final int cantidadMax;
    private final int cantidadProductos;
    public int sumaProductos=0;

    public Agregar(int cantidadProductos,int cantidadMin, int cantidadMax) {
        this.cantidadMin = cantidadMin;
        this.cantidadMax = cantidadMax;
        this.cantidadProductos = cantidadProductos;
    }

    public static Agregar productos(int cantidadProductos,int cantidadMin, int cantidadMax) {
        return Tasks.instrumented(Agregar.class,cantidadProductos,cantidadMin,cantidadMax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Integer> listaElementos=actor.recall("listaElementos");
        List<Integer> cantidad=actor.recall("cantidadSeleccionada");
        List<WebElementFacade> agregar= PaginaJugutes.agregarCarrito.resolveAllFor(actor);
        System.out.println("eneuntra"+agregar.size());

        for (int i =0;i<cantidadProductos;i++){

            int producto=listaElementos.get(i);
            int cantidades=cantidad.get(i);
             sumaProductos += cantidades;
            System.out.println("indice seleccionado"+producto);
            WebElementFacade elemento=agregar.get(producto);


           actor.attemptsTo(
                   Click.on(elemento)
                    );

            EsperarElementos.tiempo(2000);
            List<WebElementFacade> cantidadProductos=PaginaJugutes.anhadir.resolveAllFor(actor);
            System.out.println("cantidad producots: "+cantidadProductos.size());
            WebElementFacade cuantia=cantidadProductos.get(i);
            System.out.println("cantidad de producto para el elemento "+i+cantidades);
            for(int j=1; j<cantidades;j++){
                        actor.attemptsTo(
                        Click.on(cuantia)
                );
            }


        }

        System.out.println("la canitdad de producto fue "+sumaProductos);
        actor.remember("totalProductos",sumaProductos);
        EsperarElementos.tiempo(5000);
    }
}

