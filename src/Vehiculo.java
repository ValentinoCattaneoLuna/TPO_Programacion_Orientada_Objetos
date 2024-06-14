public class Vehiculo {

    private int precio;
    private String nombre;

    public Vehiculo(String nombre,int precio){
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getPrecio(){
        return this.precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
