package View;

import Controller.HabilidadController;
import Model.Habilidad;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HabilidadView {
    private static final Scanner scanner = new Scanner(System.in);
    private HabilidadController habilidadController = new HabilidadController();

    public void displayMenu() {
        while (true) {
            System.out.println("Habilidades:D");
            System.out.println("1. Agregar Habilidades");
            System.out.println("2. Listar Habilidades");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        agregarHabilidad();
                        break;
                    case 2:
                        listarHabilidad();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (SQLException e) {
                System.err.println("Error de base de datos: " + e.getMessage());
            }
        }
    }

    private void agregarHabilidad() throws SQLException {
        System.out.print("Ingrese el nombre de la habilidad: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese una descripcion: ");
        String description = scanner.nextLine();
        Habilidad habilidad = new Habilidad(0, name, description);
        habilidadController.addHabilidad(habilidad);
        System.out.println("Habilidad Creada.");
    }

    private void listarHabilidad() throws SQLException {
        List<Habilidad> habilidades = habilidadController.getAllHabilidades();
        for (Habilidad habilidad : habilidades) {
            System.out.println("ID: " + habilidad.getId());
            System.out.println("Nombre: " + habilidad.getName());
            System.out.println("Descripcion: " + habilidad.getDescription());
            System.out.println("-----");
        }
    }
}
