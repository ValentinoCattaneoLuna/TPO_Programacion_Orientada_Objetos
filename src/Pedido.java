public class Pedido {

    private int precioFinal;
    private Servicio serv;
    private Cliente cliente;
    private Estado estado;
    private java.util.Date fecha;


    public Pedido(Servicio serv, Cliente cliente){
        this.serv = serv;
        this.cliente = cliente;
        this.estado = Estado.enProceso;
    }

    public  void terminarPedido(){
        this.estado = Estado.Terminado;
    }
    public void calcularPrecio(){
         this.precioFinal = this.cliente.getVehiculo().getPrecio() + this.serv.getPrecio();
    }
    public int getPrecioFinal() {
        return precioFinal;
    }
}
