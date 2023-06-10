package web.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import web.userinterfaces.AmbientePruebas;

public class AbrirPagina implements Task {
    private AmbientePruebas ambientePruebas;
    public static AbrirPagina urlApp() {
        return Tasks.instrumented(AbrirPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(ambientePruebas));
    }
}
