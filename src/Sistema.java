import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Pedido> pedidos = new ArrayList<Pedido>();
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void terminarPedido(Pedido pedido){
        pedido.terminarPedido();
    }
}
