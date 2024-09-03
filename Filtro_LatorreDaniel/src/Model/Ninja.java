package Model;

public class Ninja {
    private int ID;
    private String Nombre;
    private String Rango;
    private String Aldea;

    public Ninja(int ID, String Nombre, String Rango, String Aldea) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Rango = Rango;
        this.Aldea = Aldea;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return Nombre;
    }

    public String getElo() {
        return Rango;
    }
    
    public String getAldea() {
        return Aldea;
    }

    public void setName(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setRango(String rango) {
        this.Rango = rango;
    }
    
    public void setAldea(String aldea) {
        this.Aldea = aldea;
    }
}