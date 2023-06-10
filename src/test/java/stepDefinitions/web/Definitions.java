package stepDefinitions.web;

import cucumber.api.java.Before;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import web.task.AbrirPagina;
import web.task.Dirigirse;
import web.task.Escoger;
import web.task.EscogerProductos;

public class Definitions {
    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^que miguel ingresa a la pagina exito$")
    public void queMiguelIngresaALaPaginaExito() {
        OnStage.theActorCalled("miguel").wasAbleTo(AbrirPagina.urlApp());
    }


    @Y("^migel se encuentra en la categoria \"([^\"]*)\" y subcategoria   \"([^\"]*)\"$")
    public void migelSeEncuentraEnLaCategoriaYSubcategoria(String categoria, String subcategoria) {
            OnStage.theActorInTheSpotlight().attemptsTo(Escoger.categoria(categoria,subcategoria));
    }

    @Cuando("^miguel seleciona (\\d+) productos con cantidaddes entre (\\d+) y (\\d+)$")
    public void miguelSelecionaProductosConCantidaddesEntreY(int cantidadProductos, int cantidadMin, int cantidadMax) {
        OnStage.theActorInTheSpotlight().attemptsTo(EscogerProductos.seleccionar(cantidadProductos,cantidadMin,cantidadMax));
        OnStage.theActorInTheSpotlight().attemptsTo(Dirigirse.carrito());

    }

    @Entonces("^verifico que los nombre de los productos agregados sean iaguales a los nombres de los productos en el carrito$")
    public void verificoQueLosNombreDeLosProductosAgregadosSeanIagualesALosNombresDeLosProductosEnElCarrito() {
       // OnStage.theActorInTheSpotlight().attemptsTo(Dirigirse.carrito());
    }





}
