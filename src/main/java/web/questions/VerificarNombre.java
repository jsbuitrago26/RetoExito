package web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class VerificarNombre implements Question <Boolean> {
    public static VerificarNombre nombre() {
        return new VerificarNombre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Object> elementosTotal=new ArrayList<>();
        List<Object> elementosTotalCarrito=new ArrayList<>();


        elementosTotal=actor.recall("listaNombres");
        elementosTotalCarrito=actor.recall("informacionDelCarrito");
        List<Object> nombresCarrito = (List<Object>) elementosTotalCarrito.get(0);
        return elementosTotal.containsAll(nombresCarrito);
    }
}
