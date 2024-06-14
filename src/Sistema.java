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

    public void mostrarPedidos(List<Pedido> lista ){
        for (Pedido p : lista){
            System.out.println(p);
        }
    }


    private List<Pedido> obtenerPorFechaYEstado(Date fecha, Estado estado) {
        List<Pedido> pedidosFiltro = new ArrayList<Pedido>();
        for(Pedido p : this.pedidos){
            if (p.getFecha().equals(fecha) && p.getEstado().equals(estado)){
                pedidosFiltro.add(p);
            }
        }
        return pedidosFiltro;

    }

    public List<Pedido> obtenerTerminadosDelDia(){
        return obtenerPorFechaYEstado(new Date(), Estado.TERMINADO);
    }

    //terminar todos los del dia
    //obtenerTerminados
    //obtenerEnProceso
    //
    //
}
