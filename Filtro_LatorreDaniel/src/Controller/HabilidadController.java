package Controller;

import DAO.HabilidadDAO;
import Model.Habilidad;

import java.sql.SQLException;
import java.util.List;

public class HabilidadController {
    private HabilidadDAO habilidadDAO;

    public HabilidadController() {
        this.habilidadDAO = new HabilidadDAO();
    }

    public void addHabilidad(Habilidad habilidad) throws SQLException {
        habilidadDAO.addHabilidad(habilidad);
    }

    public List<Habilidad> getAllHabilidades() throws SQLException {
        return habilidadDAO.getAllHabilidades();
    }
}