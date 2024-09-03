package View;

import Controller.MisionController;
import Model.Mision;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MisionView {
    private static final Scanner scanner = new Scanner(System.in);
    private MisionController misionController = new MisionController();

    public void displayMenu() {
        while (true) {
            System.out.println("Misiones:D");
            System.out.println("1. Agregar Misiones");
            System.out.println("2. Listar Misiones");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        agregarMision();
                        break;
                    case 2:
                        listarMision();
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

    private void agregarMision() throws SQLException {
        System.out.print("Descripcion breve de la mision: ");
        String description = scanner.nextLine();
        System.out.print("Ingrese el Rango(Bronce - Plata - Oro): ");
        String rango = scanner.nextLine();
        System.out.print("Ingrese la recompensa: ");
        String recompensa = scanner.nextLine();
        Mision mision = new Mision(0, description, rango, recompensa);
        misionController.addMision(mision);
        System.out.println("Ninja agregado.");
    }

    private void listarMision() throws SQLException {
        List<Mision> misiones = misionController.getAllMision();
        for (Mision mision : misiones) {
            System.out.println("ID: " + mision.getId());
            System.out.println("Nombre: " + mision.getDescription());
            System.out.println("Rango: " + mision.getElo());
            System.out.println("Aldea:" + mision.getRecompensa());
            System.out.println("-----");
        }
    }
}

    

