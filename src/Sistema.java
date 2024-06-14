import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema {

    private List<Pedido> pedidos = new ArrayList<Pedido>();
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void terminarPedido(Pedido pedido){
        pedido.terminarPedido();
    }

    public void mostrarTodo(){
        for (Pedido p : this.pedidos){
            System.out.println(p);
        }
    }

    private List<Pedido> obtenerPorFechaYEstado(Date fecha, Estado estado) {
        //

        return pedidos;
    }

    public List<Pedido> obtenerTerminadosDelDia(){
        return obtenerPorFechaYEstado(new Date(), Estado.TERMINADO);
    }


    //obtenerTerminados
    //obtenerEnProceso
    //terminarTodosLosDelDia
    //
}
