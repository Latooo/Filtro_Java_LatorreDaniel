package Model;


public class Mision {
    private int ID;
    private String Description;
    private String Rango;
    private String Recompensa;
    
    public Mision(int ID, String Description, String Rango, String Recompensa) {
        this.ID = ID;
        this.Description = Description;
        this.Rango = Rango;
        this.Recompensa = Recompensa;
    }

    public int getId() {
        return ID;
    }

    public String getDescription() {
        return Description;
    }

    public String getElo() {
        return Rango;
    }
    
    public String getRecompensa() {
        return Recompensa;
    }

    public void setName(String Description) {
        this.Description = Description;
    }

    public void setRango(String rango) {
        this.Rango = rango;
    }
    
    public void setAldea(String Recompensa) {
        this.Recompensa = Recompensa;
    }
}
