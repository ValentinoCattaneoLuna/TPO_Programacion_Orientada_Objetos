public class Pedido {

    private int precioFinal;
    private Servicio serv;
    private Cliente cliente;
    private Estado estado;
    private java.util.Date fecha;


    public void calcularPrecio(){
         this.precioFinal = this.cliente.getVehiculo().getPrecio() + this.serv.getPrecio();
    }
    public int getPrecioFinal() {
        return precioFinal;
    }
}
