package Tarea33;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio33 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Escribe la primera URL");
        String url = scan.nextLine();

        //Crear cliente
        HttpClient cliente = HttpClient.newHttpClient();

        //Crear petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try{
            //Enviar y recibir respuesta
            HttpResponse<String> response = cliente.send(request,
                                            HttpResponse.BodyHandlers.ofString());
            //Procesar resultados
            System.out.println("Código: " + response.statusCode());
            System.out.println("Cuerpo: " + response.body());

            //Guardamos el HTML recibido en un fichero
            HttpResponse<Path> responsePath = cliente.send(request,
                                                HttpResponse.BodyHandlers.ofFile(Path.of("inspector.html")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scan.close();
    }
}
