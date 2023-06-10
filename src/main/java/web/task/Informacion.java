package web.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import web.interaction.EsperarElementos;
import web.userinterfaces.PaginaCarrito;

import java.util.ArrayList;
import java.util.List;

public class Informacion implements Task {
    private final int cantidadProductos;

    public Informacion(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public static Informacion carrito(int cantidadProductos) {
        return Tasks.instrumented(Informacion.class,cantidadProductos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        EsperarElementos.tiempo(5000);
        List<String> elementos=new ArrayList<>();
        List<String> elementosPrecio=new ArrayList<>();
        List<String> elementosCantidad=new ArrayList<>();
        List<Object> elementosTotal=new ArrayList<>();
        List<String> nombreProductosEscogidos=actor.recall("listaNombres");
        for (int i=0; i<cantidadProductos;i++){
          Target[] infTotalProducto= PaginaCarrito.informacioProducto(i+1);
          Target infProductoNombre=infTotalProducto[0];
          Target infProductoPrecio=infTotalProducto[1];
          Target infProductoCantidad=infTotalProducto[2];

          String infNOmbre = Text.of(infProductoNombre).viewedBy(actor).asString();

          String precio = Text.of(infProductoPrecio).viewedBy(actor).asString();
          int indice =precio.indexOf("$", precio.indexOf("$")+1);
         String infPrecio=(indice !=-1) ? precio.substring(indice):precio;
          String infCantidad = Text.of(infProductoCantidad).viewedBy(actor).asString();
            elementos.add(infNOmbre);
            elementosPrecio.add(infPrecio);
            elementosCantidad.add(infCantidad);

        }
        elementosTotal.add(elementos);
        elementosTotal.add(elementosPrecio);
        elementosTotal.add(elementosCantidad);
        System.out.println("Nombres de roductos en el carro : "+elementosTotal);

        List<List<Object>> informacionOrganizada=new ArrayList<>();
        List<?> informacionNombreCarritodes=(List<?>) elementosTotal.get(0);
        List<Integer> filaorganizada=new ArrayList<>();

        for (String elemento : nombreProductosEscogidos) {
            int indice = informacionNombreCarritodes.indexOf(elemento);
            filaorganizada.add(indice);
        }
        int numFilas = elementosTotal.size();
        int numColumnas = informacionNombreCarritodes.size();
        System.out.println("numfila"+numFilas);
        System.out.println("Columnas"+numColumnas);
        for (int i = 0; i < numFilas; i++) {
            List<Object> filaDesordenada = (List<Object>) elementosTotal.get(i);
            List<Object> filaOrganizada = new ArrayList<>();
            for (int j = 0; j < numColumnas; j++) {
                filaOrganizada.add(filaDesordenada.get(filaorganizada.get(j)));
            }
            informacionOrganizada.add(filaOrganizada);
        }

        for (List<Object> fila : informacionOrganizada) {
            System.out.println(fila);
        }
        actor.remember("informacionDelCarrito",informacionOrganizada);
    }
}
