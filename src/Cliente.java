public class Cliente {


    private String nombre;
    private Vehiculo vehiculo;
    private String telefono;


    public Cliente(String nombre, Vehiculo vehiculo, String telefono) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre;
    }

}