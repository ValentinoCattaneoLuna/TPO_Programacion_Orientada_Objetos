import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Sistema pepesys = new Sistema();
//        Vehiculo Moto = new Vehiculo("moto", 2400);
//        Cliente valen = new Cliente("valentino",Moto,"41241241");
//        Servicio prueba = new Servicio("prueba",1000);
//        pepesys.agregarPedido(new Pedido(prueba,valen));
//        pepesys.agregarPedido(new Pedido(prueba,valen));
//        List<Pedido> lavadosHoy = pepesys.obtenerProcesosDelDia();
//        pepesys.mostrarPedidos(lavadosHoy);

        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);


        List<Vehiculo> tiposVehiculos = new ArrayList<>();
        tiposVehiculos.add(new Vehiculo("Auto", 5000));
        tiposVehiculos.add(new Vehiculo("Moto", 2500));
        tiposVehiculos.add(new Vehiculo("Camioneta", 6500));


        List<Servicio> tiposServicios = new ArrayList<>();
        tiposServicios.add(new Servicio("Lavado Express", 5500));
        tiposServicios.add(new Servicio("Lavado Completo", 8000));
        tiposServicios.add(new Servicio("Detailing", 12000));


        menu(sistema,scanner,tiposVehiculos,tiposServicios);

    }

    public  static void menu(Sistema sistema, Scanner scanner, List<Vehiculo> tiposVehiculos, List<Servicio> tiposServicios){

        while (true) {
            System.out.println("\nSistema de Gestión de Pedidos");
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Terminar Pedido");
            System.out.println("3. Terminar Todos los Pedidos del Día");
            System.out.println("4. Mostrar Pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opción no válida, por favor ingrese un número.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefonoCliente = scanner.nextLine();

                    System.out.println("Seleccione el tipo de vehículo:");
                    for (int i = 0; i < tiposVehiculos.size(); i++) {
                        System.out.println((i + 1) + ". " + tiposVehiculos.get(i).getNombre());
                    }
                    int vehiculoSeleccionado;
                    try {
                        vehiculoSeleccionado = scanner.nextInt() - 1;
                    } catch (Exception e) {
                        System.out.println("Opción no válida, por favor ingrese un número.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();

                    Vehiculo vehiculo;
                    try {
                        vehiculo = tiposVehiculos.get(vehiculoSeleccionado);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Opción no válida, por favor seleccione un vehículo de la lista.");
                        continue;
                    }

                    Cliente cliente = new Cliente(nombreCliente, vehiculo, telefonoCliente);


                    System.out.println("Seleccione el tipo de servicio:");
                    for (int i = 0; i < tiposServicios.size(); i++) {
                        System.out.println((i + 1) + ". " + tiposServicios.get(i).getDescripcion());
                    }
                    int servicioSeleccionado;
                    try {
                        servicioSeleccionado = scanner.nextInt() - 1;
                    } catch (Exception e) {
                        System.out.println("Opción no válida, por favor ingrese un número.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();

                    Servicio servicio;
                    try {
                        servicio = tiposServicios.get(servicioSeleccionado);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Opción no válida, por favor seleccione un servicio de la lista.");
                        continue;
                    }


                    Pedido pedido = new Pedido(servicio, cliente);
                    sistema.agregarPedido(pedido);
                    System.out.println("Pedido agregado con éxito.");
                    break;
                case 2:

                    List<Pedido> pedidosEnProceso = sistema.obtenerTodosEnProceso();
                    if (pedidosEnProceso.isEmpty()) {
                        System.out.println("No hay pedidos en proceso.");
                        break;
                    }
                    System.out.println("Pedidos en proceso:");
                    for (int i = 0; i < pedidosEnProceso.size(); i++) {
                        System.out.println((i + 1) + ". " + pedidosEnProceso.get(i).getCliente().getNombre());
                    }

                    System.out.print("Ingrese el nombre del cliente del pedido a terminar: ");
                    String nombreClienteTerminar = scanner.nextLine();
                    boolean pedidoTerminado = false;
                    for (Pedido p : pedidosEnProceso) {
                        if (p.getCliente().getNombre().equalsIgnoreCase(nombreClienteTerminar)) {
                            sistema.terminarPedido(p);
                            System.out.println("Pedido terminado con éxito.");
                            pedidoTerminado = true;
                            break;
                        }
                    }
                    if (!pedidoTerminado) {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;
                case 3:
                    sistema.terminarTodosLosDelDia();
                    System.out.println("Todos los pedidos del día han sido terminados.");
                    break;
                case 4:
                    System.out.println("Seleccione un filtro para mostrar los pedidos:");
                    System.out.println("1. Pedidos terminados del día");
                    System.out.println("2. Todos los pedidos terminados");
                    System.out.println("3. Pedidos en proceso");
                    System.out.println("4. Pedidos del día");
                    System.out.println("5. Pedidos en proceso del día");
                    System.out.println("6. Pedidos por rango de precio");
                    System.out.println("7. Pedidos por tipo de servicio");
                    System.out.print("Seleccione una opción: ");

                    int filtro;
                    try {
                        filtro = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Opción no válida, por favor ingrese un número.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();

                    List<Pedido> pedidosFiltrados = new ArrayList<>();
                    switch (filtro) {
                        case 1:
                            pedidosFiltrados = sistema.obtenerTerminadosDelDia();
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 2:
                            pedidosFiltrados = sistema.obtenerTodosLosTerminados();
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 3:
                            pedidosFiltrados = sistema.obtenerTodosEnProceso();
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 4:
                            pedidosFiltrados = sistema.obtenerTodosLosDeHoy();
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 5:
                            pedidosFiltrados = sistema.obtenerProcesosDelDia();
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 6:

                            System.out.print("Ingrese el precio mínimo: ");
                            int precioMin;
                            try {
                                precioMin = scanner.nextInt();
                            } catch (Exception e) {
                                System.out.println("Precio no válido, por favor ingrese un número.");
                                scanner.nextLine();
                                continue;
                            }
                            scanner.nextLine();
                            System.out.print("Ingrese el precio máximo: ");
                            int precioMax;
                            try {
                                precioMax = scanner.nextInt();
                            } catch (Exception e) {
                                System.out.println("Precio no válido, por favor ingrese un número.");
                                scanner.nextLine();
                                continue;
                            }
                            scanner.nextLine();
                            pedidosFiltrados = sistema.obtenerRangoPrecio(precioMin, precioMax);
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                        case 7:

                            System.out.println("Seleccione el tipo de servicio:");
                            for (int i = 0; i < tiposServicios.size(); i++) {
                                System.out.println((i + 1) + ". " + tiposServicios.get(i).getDescripcion());
                            }
                            int tipoServicioSeleccionado;
                            try {
                                tipoServicioSeleccionado = scanner.nextInt() - 1;
                            } catch (Exception e) {
                                System.out.println("Opción no válida, por favor ingrese un número.");
                                scanner.nextLine();
                                continue;
                            }
                            scanner.nextLine();

                            try {
                                Servicio servicioFiltro = tiposServicios.get(tipoServicioSeleccionado);
                                pedidosFiltrados = sistema.obtenerPorTipoServicio(servicioFiltro.getDescripcion());
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Opción no válida, por favor seleccione un servicio de la lista.");
                                continue;
                            }
                            sistema.mostrarPedidos(pedidosFiltrados);
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

}