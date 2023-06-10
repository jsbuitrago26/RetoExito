package web.task;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import web.userinterfaces.PaginaPrincipal;


public class Escoger implements Task {
    public  String categorias;
    public  String subCategorias;

    public Escoger(String categorias,String subCategorias){
        this.categorias=categorias;
        this.subCategorias=subCategorias;
    }
    public static Escoger categoria(String categoria, String subCategoria) {
        return Tasks.instrumented(Escoger.class,categoria,subCategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PaginaPrincipal.BTN_menu),
                Click.on(PaginaPrincipal.BTN_categoria),
                Click.on(PaginaPrincipal.SeleccionSubcategoria)
        );

    }
}
