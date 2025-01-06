package main.java.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirDatos {
    private static final String DIRECCION = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s";
    private static final String API_KEY = "aedbce54102bb5ac8a2b3ef0";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String consumir(String monedaInicial, String monedaFinal) {
        String url = String.format(DIRECCION, API_KEY, monedaInicial, monedaFinal);
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consumir la API", e);
        }
    }
}
