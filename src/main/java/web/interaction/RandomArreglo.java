package web.interaction;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import web.userinterfaces.PaginaJugutes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomArreglo implements Interaction {
    private int cantidadProductos;
    private Target arrayElementos;
    private int fila;
    private int cantidadMin;
    private int cantidadMax;


    public RandomArreglo(int cantidadProductos, Target arrayElementos,int cantidadMin,int cantidadMax) {
        this.cantidadProductos = cantidadProductos;
        this.arrayElementos = arrayElementos;
        this.cantidadMin = cantidadMin;
        this.cantidadMax = cantidadMax;
    }
    public static RandomArreglo randomArreglo(int cantidadProductos, Target arrayElementos, int cantidadMin,int cantidadMax) {
        return new RandomArreglo(cantidadProductos, arrayElementos,cantidadMin,cantidadMax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elementos= arrayElementos.resolveAllFor(actor);
        List<WebElementFacade> elemntosPrecios=PaginaJugutes.elementosPrecio.resolveAllFor(actor);
        int cantidadElemento=elementos.size();
       // List<WebElementFacade> prueba =arrayElementos.resolveAllFor(actor);

        System.out.println("cantidad de elementos"+cantidadElemento);

        Random random =new Random();
        List<String> Elementos=new ArrayList<>();
        List<String> elemtosConPrecio=new ArrayList<>();
        List<Integer> indiceSeleccion=new ArrayList<>();
        List<Integer> cantidad=new ArrayList<>();
        for (int i =0;i<cantidadProductos;i++){
            int numeroAleatorio;

            int cantidadseleccionada=random.nextInt((cantidadMax-cantidadMin)+1)+cantidadMin;
            cantidad.add(cantidadseleccionada);
            do{
                numeroAleatorio=random.nextInt(cantidadElemento);

            }while (indiceSeleccion.contains(numeroAleatorio));
            indiceSeleccion.add(numeroAleatorio);

            System.out.println("Numero aleatorio"+numeroAleatorio);

        }

        Collections.sort(indiceSeleccion);
        for (int j=0;j<cantidadProductos;j++){
            int organizar = indiceSeleccion.get(j);
            WebElement elemento=elementos.get(organizar);
            String nombreElemento=elemento.getText();
            Elementos.add(nombreElemento);

            WebElement elemtoPrecio=elemntosPrecios.get(organizar);
            String precioElemento=elemtoPrecio.getText();
            elemtosConPrecio.add(precioElemento);
        }
        List<Object> listaPrincipal=new ArrayList<>();
        listaPrincipal.add(indiceSeleccion);
        listaPrincipal.add(Elementos);
        listaPrincipal.add(elemtosConPrecio);

        actor.remember("listaElementos",indiceSeleccion);
        actor.remember("listaNombres",Elementos);
        actor.remember("listaPrecio",elemntosPrecios);
        actor.remember("listaPrincipal",listaPrincipal);
        actor.remember("cantidadSeleccionada",cantidad);

        System.out.println("nombre de elementos :");
        for (Object nombre:listaPrincipal){
            System.out.println(nombre);
        }

    }
}
