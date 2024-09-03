package Model;

public class Habilidad {
    private int ID;
    private String Nombre;
    private String Description;

    public Habilidad(int ID, String Nombre, String Description) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Description = Description;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return Nombre;
    }

    public String getDescription() {
        return Description;
    }
    
    public void setName(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
    
}