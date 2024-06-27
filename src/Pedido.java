
import java.time.LocalDate;
import java.util.Date;
public class Pedido {

    private int precioFinal;
    private Servicio serv;
    private Cliente cliente;
    private Estado estado;
    private LocalDate fecha;


    public Pedido(Servicio serv, Cliente cliente){
        this.serv = serv;
        this.cliente = cliente;
        this.estado = Estado.EN_PROCESO;
        this.fecha = LocalDate.now();
        this.calcularPrecio();
    }

    public  void terminarPedido(){
        this.estado = Estado.TERMINADO;
    }
    private void calcularPrecio(){
         this.precioFinal = this.cliente.getVehiculo().getPrecio() + this.serv.getPrecio();
    }
    public int getPrecioFinal() {
        return this.precioFinal;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public Estado getEstado() {
        return this.estado;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public Object getServicio() {return serv;}

    @Override
    public String toString() {
        return "Pedido:" + this.serv +", Cliente:  " + this.cliente +", Vehiculo:  " + this.cliente.getVehiculo() +", Estado: " +  this.estado + ", Precio final:" + this.getPrecioFinal()+"$.";
    }


}
