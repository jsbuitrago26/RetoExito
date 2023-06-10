package web.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EsperarElementos implements Task {
    private final Target producto;

    public EsperarElementos(Target producto) {
        this.producto = producto;
    }

    public static Performable tiempo(int tiempo){
        try {
            System.out.println("estoy esperando");
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static EsperarElementos objeto(Target producto){
        return Tasks.instrumented(EsperarElementos.class,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(producto,isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
