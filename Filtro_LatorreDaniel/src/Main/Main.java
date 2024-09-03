package Main;

import java.util.Scanner;
import Controller.NinjaController;
import Controller.MisionController;
import Controller.HabilidadController;
import View.HabilidadView;
import View.NinjaView;
import View.MisionView;
import DataBase.Conexion;


public class Main {
    private static NinjaController ninjaController;
    private static MisionController misionController;
    private static HabilidadController habilidadController;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar la conexión a la base de datos
        Conexion.init();

        // Crear los controladores
        ninjaController = new NinjaController();
        misionController = new MisionController();
        habilidadController = new HabilidadController();

        // Menú principal
        while (true) {
            displayMenu("Konoha", new String[]{
                "1. Ninjas",
                "2. Misiones",
                "3. Habilidades",
                "4. Salir"
            });
            int choice = getChoice(1, 4);

            switch (choice) {
                case 1 -> new NinjaView().displayMenu();
                case 2 -> new MisionView().displayMenu();
                case 3 -> new HabilidadView().displayMenu();
                case 4 -> {
System.out.println("Saliendo... Hasta luego!");
scanner.close();
return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
    
    private static void displayMenu(String title, String[] options) {
        System.out.println("\n" + title);
        System.out.println("--------------------------------------------------");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    private static int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Opción fuera de rango. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }
}