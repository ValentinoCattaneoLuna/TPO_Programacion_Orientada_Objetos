import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema lavaderoPepe = new Sistema();
        Servicio lavadoCompleto = new Servicio("Lavado completo",10000);
        Servicio lavadoExpress = new Servicio("Lavado express",4000);
        Vehiculo tornado = new Vehiculo("tornado",2000);
        Vehiculo cuatrinashe = new Vehiculo("cuatrinashe",2500);
        Vehiculo gol = new Vehiculo("gol",3500);
        Vehiculo Clio = new Vehiculo("Clio", 3500);
        Cliente valentino = new Cliente("Valentino", gol,"+5491128384628");
        Cliente mateo = new Cliente("Mateo", tornado, "+5492267530090");
        Cliente facundo = new Cliente("Facundo", Clio, "+5492267524376");
        Pedido pedido1 = new Pedido(lavadoCompleto, mateo);
        Pedido pedido2 = new Pedido(lavadoExpress, valentino);
        Pedido pedido3 = new Pedido(lavadoCompleto, facundo);
        lavaderoPepe.agregarPedido(pedido1);
        lavaderoPepe.agregarPedido(pedido2);
        lavaderoPepe.agregarPedido(pedido3);
        lavaderoPepe.terminarPedido(pedido1);
        lavaderoPepe.terminarPedido(pedido2);


        List<Pedido> enProceso = lavaderoPepe.obtenerTodosEnProceso();
        List<Pedido> lavadosHoy = lavaderoPepe.obtenerTerminadosDelDia();
        lavaderoPepe.mostrarPedidos(lavadosHoy);
        lavaderoPepe.mostrarPedidos(enProceso);
    }
}
