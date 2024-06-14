
import java.util.Date;
public class Pedido {
    private int precioFinal;
    private Servicio serv;
    private Cliente cliente;
    private Estado estado;
    private Date fecha;


    public Pedido(Servicio serv, Cliente cliente){
        this.serv = serv;
        this.cliente = cliente;
        this.estado = Estado.EN_PROCESO;
        this.fecha = new Date();
    }

    public  void terminarPedido(){
        this.estado = Estado.TERMINADO;
    }
    public void calcularPrecio(){
         this.precioFinal = this.cliente.getVehiculo().getPrecio() + this.serv.getPrecio();
    }
    public int getPrecioFinal() {
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Pedido{" + serv +" " + cliente +" " + cliente.getVehiculo() +" " +  estado + '}';
    }
}
