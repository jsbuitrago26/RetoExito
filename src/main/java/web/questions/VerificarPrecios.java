package web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class VerificarPrecios implements Question<Boolean> {
    public static VerificarPrecios precios() {
        return new VerificarPrecios();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Object> elementosTotal=new ArrayList<>();
        List<Object> elementosTotalCarrito=new ArrayList<>();
        List<Object> elementosTotalPrecios=new ArrayList<>();
        elementosTotal=actor.recall("listaPrincipal");
        elementosTotalPrecios= (List<Object>) elementosTotal.get(3);

        elementosTotalCarrito=actor.recall("informacionDelCarrito");
        List<Object> preciosCarrito = (List<Object>) elementosTotalCarrito.get(1);
        return elementosTotalPrecios.equals(preciosCarrito);
    }
}
