package web.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Random;

public class Cantidad implements Interaction {

    private int cantidadMin;
    private int cantidadMax;

    public Cantidad(int cantidadMin, int cantidadMax) {
        this.cantidadMin = cantidadMin;
        this.cantidadMax = cantidadMax;
    }

    public static Cantidad porProducto(int cantidadMin, int cantidadMax) {
        return new Cantidad(cantidadMin,cantidadMax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random =new Random();
        System.out.println("mac"+cantidadMax+"min"+cantidadMin);
        int cantidadseleccionada=random.nextInt((cantidadMax-cantidadMin)+1)+cantidadMin;
        actor.remember("cantidadSeleccionada",cantidadseleccionada);
    }
}
