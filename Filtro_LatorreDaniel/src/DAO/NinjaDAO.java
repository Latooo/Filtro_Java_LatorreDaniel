package DAO;

import DataBase.Conexion;
import Model.Ninja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {
    private Connection con;

    public NinjaDAO() {
        this.con = Conexion.getConnection(); // Usar una única conexión
    }

    public void addNinja(Ninja ninja) throws SQLException {
        String query = "INSERT INTO Ninja (Nombre, Rango, Aldea) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ninja.getName());
            stmt.setString(2, ninja.getElo());
            stmt.setString(3, ninja.getAldea());
            stmt.executeUpdate();
        }
    }

    public void updateNinja(Ninja ninja) throws SQLException {
        String query = "UPDATE Ninja SET Nombre = ?, Rango = ?, Aldea = ? WHERE ID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ninja.getName());
            stmt.setString(2, ninja.getElo());
            stmt.setString(3, ninja.getAldea());
            stmt.setInt(4, ninja.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteNinja(int ninjaId) throws SQLException {
        String query = "DELETE FROM Ninja WHERE ID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, ninjaId);
            stmt.executeUpdate();
        }
    }

    public Ninja getNinja(int ninjaId) throws SQLException {
        String query = "SELECT * FROM Ninja WHERE ID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, ninjaId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ninja(
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Rango"),
                        rs.getString("Aldea")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<Ninja> getAllNinjas() throws SQLException {
        String query = "SELECT * FROM Ninja";
        List<Ninja> restaurants = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                restaurants.add(new Ninja(
                    rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Rango"),
                        rs.getString("Aldea")
                ));
            }
        }
        return restaurants;
    }
}
