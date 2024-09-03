package Controller;

import DAO.MisionDAO;
import Model.Mision;

import java.sql.SQLException;
import java.util.List;

public class MisionController {
    private MisionDAO misionDAO;

    public MisionController() {
        this.misionDAO = new MisionDAO();
    }

    public void addMision(Mision mision) throws SQLException {
        misionDAO.addMision(mision);
    }

    public List<Mision> getAllMision() throws SQLException {
        return misionDAO.getAllMision();
    }
}
