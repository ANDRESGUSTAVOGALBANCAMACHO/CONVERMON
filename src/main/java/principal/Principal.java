package main.java.principal;

import main.java.servicios.ConsumirDatos;
import main.java.servicios.Conversor;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsumirDatos consulta = new ConsumirDatos();
        Conversor conversor = new Conversor(consulta);

        while (true) {
            System.out.println("""
                ************************************
                Estas usando CONVERMON. ¡Bienvenido!
                ************************************
                
                ¿Qué conversión deseas hacer?
                1. Dólar a Peso Argentino
                2. Peso Argentino a Dólar
                3. Dólar a Real Brasileño
                4. Real Brasileño a Dólar
                5. Dólar a Peso Colombiano
                6. Peso Colombiano a Dólar
                7. Salir
                ************************************
                Coloca la opción que deseas elegir:""");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            if (opcion == 7) {
                System.out.println("Saliendo del programa. ¡Gracias por usar CORVERMON!\n" +
                        "***************************************************");
                break;
            }

            switch (opcion) {
                case 1 -> conversor.convertir("USD", "ARS", scanner);
                case 2 -> conversor.convertir("ARS", "USD", scanner);
                case 3 -> conversor.convertir("USD", "BRL", scanner);
                case 4 -> conversor.convertir("BRL", "USD", scanner);
                case 5 -> conversor.convertir("USD", "COP", scanner);
                case 6 -> conversor.convertir("COP", "USD", scanner);
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
