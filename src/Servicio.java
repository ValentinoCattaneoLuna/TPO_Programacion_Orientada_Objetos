public class Servicio{
    private String descripcion;
    private int precio;


    public Servicio(String descripcion, int precio){
        this.descripcion=descripcion;
        this.precio=precio;
    }
    public int getPrecio() {
        return this.precio;
    }

    public String getDescripcion() {
        return descripcion;
    }


    @Override
    public String toString() {
        return descripcion;
    }
}
