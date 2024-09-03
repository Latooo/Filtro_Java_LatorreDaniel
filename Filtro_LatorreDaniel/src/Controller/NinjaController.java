package Controller;

import DAO.NinjaDAO;
import Model.Ninja;

import java.sql.SQLException;
import java.util.List;

public class NinjaController {
    private NinjaDAO ninjaDAO;

    public NinjaController() {
        this.ninjaDAO = new NinjaDAO();
    }

    public void addNinja(Ninja ninja) throws SQLException {
        ninjaDAO.addNinja(ninja);
    }

    public void updateNinja(Ninja ninja) throws SQLException {
        ninjaDAO.updateNinja(ninja);
    }

    public void deleteNinja(int ninjaId) throws SQLException {
        ninjaDAO.deleteNinja(ninjaId);
    }

    public Ninja getNinja(int ninjaId) throws SQLException {
        return ninjaDAO.getNinja(ninjaId);
    }

    public List<Ninja> getAllNinjas() throws SQLException {
        return ninjaDAO.getAllNinjas();
    }
}