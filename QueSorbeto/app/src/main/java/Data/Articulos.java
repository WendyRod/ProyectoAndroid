package Data;

public class   Articulos {

    private String name;
    private String id;
    private String precio;

    public Articulos(String name, String id, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.precio = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrecio(String phoneNumber) {
        this.precio = precio;
    }
}
