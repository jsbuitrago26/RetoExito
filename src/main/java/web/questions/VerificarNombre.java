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
        return null;
    }
}
