package DAO;

import DataBase.Conexion;
import Model.Habilidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO {
    private Connection con;

    public HabilidadDAO() {
        this.con = Conexion.getConnection(); // Usar una única conexión
    }

    public void addHabilidad(Habilidad habilidad) throws SQLException {
        String query = "INSERT INTO Habilidad (Nombre, Descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, habilidad.getName());
            stmt.setString(2, habilidad.getDescription());
            stmt.executeUpdate();
        }
    }

    public List<Habilidad> getAllHabilidades() throws SQLException {
        String query = "SELECT * FROM Habilidad";
        List<Habilidad> habilidades = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                habilidades.add(new Habilidad(
                    rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                ));
            }
        }
        return habilidades;
    }
}
