package main.java.servicios;

import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import main.java.modelos.Monedas;

public class Conversor {
    private final ConsumirDatos consumirDatos;
    private static final Map<String, String> NOMBRES_MONEDAS = Map.of(
            "USD", "Dólar",
            "ARS", "Peso Argentino",
            "BRL", "Real Brasileño",
            "COP", "Peso Colombiano"
    );

    public Conversor(ConsumirDatos consumirDatos) {
        this.consumirDatos = consumirDatos;
    }

    public void convertir(String monedaInicial, String monedaFinal, Scanner scanner) {
        try {
            String respuesta = consumirDatos.consumir(monedaInicial, monedaFinal);
            Gson gson = new Gson();
            Monedas monedas = gson.fromJson(respuesta, Monedas.class);

            String nombreInicial = NOMBRES_MONEDAS.getOrDefault(monedaInicial, monedaInicial);
            String nombreFinal = NOMBRES_MONEDAS.getOrDefault(monedaFinal, monedaFinal);

            System.out.println("\n¿Qué valor en " + nombreInicial + " deseas convertir a " + nombreFinal + "?:");
            double cantidad = Double.parseDouble(scanner.nextLine());
            double cantidadConvertida = cantidad * monedas.conversion_rate();

            System.out.printf("\nLa tasa de conversión para hoy es: 1 %s = %.2f %s\n", nombreInicial, monedas.conversion_rate(), nombreFinal);
            System.out.printf("%.2f %s equivalen a %.2f %s\n\n", cantidad, nombreInicial, cantidadConvertida, nombreFinal);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al procesar la conversión. Inténtelo de nuevo.");
        }
    }
}