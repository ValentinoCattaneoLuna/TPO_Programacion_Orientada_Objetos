public class Main {
    public static void main(String[] args) {
        Sistema lavaderoPepe = new Sistema();
        Servicio lavadoCompleto = new Servicio("Lavado completo",10000);
        Servicio lavadoExpress = new Servicio("Lavado express",4000);
        Vehiculo tornado = new Vehiculo("tornado",2000);
        Vehiculo cuatrinashe = new Vehiculo("cuatrinashe",2500);
        Vehiculo gol = new Vehiculo("gol",3500);
        Cliente valentino = new Cliente("Valentino", gol,"1128384628");
        Cliente mateo = new Cliente("Mateo", tornado, "2254123456");
        Pedido pedido1 = new Pedido(lavadoCompleto, mateo);
        Pedido pedido2 = new Pedido(lavadoExpress, valentino);
        lavaderoPepe.agregarPedido(pedido1);
        lavaderoPepe.agregarPedido(pedido2);
        lavaderoPepe.terminarPedido(pedido2);
        lavaderoPepe.mostrarTodo();
    }
}