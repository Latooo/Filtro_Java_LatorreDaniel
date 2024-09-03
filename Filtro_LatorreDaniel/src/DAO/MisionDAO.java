package DAO;

import DataBase.Conexion;
import Model.Mision;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MisionDAO {
    private Connection con;

    public MisionDAO() {
        this.con = Conexion.getConnection(); // Usar una única conexión
    }

    public void addMision(Mision mision) throws SQLException {
        String query = "INSERT INTO Mision (Descripcion, Rango, Recompensa) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, mision.getDescription());
            stmt.setString(2, mision.getElo());
            stmt.setString(3, mision.getRecompensa());
            stmt.executeUpdate();
        }
    }


    public List<Mision> getAllMision() throws SQLException {
        String query = "SELECT * FROM Mision";
        List<Mision> misions = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                misions.add(new Mision(
                    rs.getInt("ID"),
                        rs.getString("Descripcion"),
                        rs.getString("Rango"),
                        rs.getString("Recompensa")
                ));
            }
        }
        return misions;
    }
}
