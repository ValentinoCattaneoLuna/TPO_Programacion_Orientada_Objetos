import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.net.URI;
import java.math.BigDecimal;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sistema {

    private List<Pedido> pedidos = new ArrayList<Pedido>();
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void terminarPedido(Pedido pedido){
        pedido.terminarPedido();
        enviarMensajeWhatsApp("Tu vehiculo ya esta listo para ser retirado",pedido.getCliente().getTelefono());
    }

    public void mostrarPedidos(List<Pedido> lista ){
        for (Pedido p : lista){
            System.out.println(p);
        }
    }

    public void terminarTodosLosDelDia(){
        for (Pedido p : this.pedidos){
            if (p.getEstado().equals(Estado.EN_PROCESO) && p.getFecha().equals(new Date())){
                p.terminarPedido();
            }
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
    private List<Pedido> obtenerPorFecha(Date fecha){
        List<Pedido> pedidosFiltro = new ArrayList<Pedido>();
        for(Pedido p : this.pedidos){
            if (p.getFecha().equals(fecha)){
                pedidosFiltro.add(p);
            }
        }
        return pedidosFiltro;
    }

    private List<Pedido> obtenerPorEstado(Estado estado){
        List<Pedido> pedidosFiltro = new ArrayList<Pedido>();
        for(Pedido p : this.pedidos){
            if (p.getEstado().equals(estado)){
                pedidosFiltro.add(p);
            }
        }
        return pedidosFiltro;
    }

    public List<Pedido> obtenerTerminadosDelDia(){
        return obtenerPorFechaYEstado(new Date(), Estado.TERMINADO);
    }
    public List<Pedido> obtenerTodosLosTerminados(){return obtenerPorEstado(Estado.TERMINADO);}
    public List<Pedido> obtenerTodosEnProceso(){return obtenerPorEstado(Estado.EN_PROCESO);}
    public List<Pedido> obtenerTodosLosDeHoy(){return obtenerPorFecha(new Date());}

    private void enviarMensajeWhatsApp(String mensaje, String numeroDestino) {
        String ACCOUNT_SID = "sid";
        String AUTH_TOKEN = "authtoken";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber("whatsapp:"+numeroDestino), // Usar el número de WhatsApp como destino
                        new PhoneNumber("whatsapp:+14155238886"), // Número de WhatsApp como origen
                        mensaje)
                .create();

        System.out.println("Mensaje enviado con SID: " + message.getSid());
    }


}
