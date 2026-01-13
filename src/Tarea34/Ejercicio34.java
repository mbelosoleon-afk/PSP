package Tarea34;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Ejercicio34 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long tiempoPrimera;
        long bytesPrimera;
        long tiempoSegunda;
        long bytesSegunda;

        System.out.println("Escribe una url");
        String primera = scan.nextLine();

        System.out.println("Escribe otra url");
        String segunda = scan.nextLine();

        try{
            //Creamos cliente
            HttpClient cliente1 = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            //Crear petición
            HttpRequest request1 = HttpRequest.newBuilder()
                    .uri(URI.create(primera))
                    .GET()
                    .build();


            long startTime1 = System.currentTimeMillis();

            HttpResponse<String> response = cliente1.send(request1, HttpResponse.BodyHandlers.ofString());

            long endTime1 = System.currentTimeMillis();

            long duracion = endTime1 - startTime1;

            System.out.println("Duración de la primera conexion: " + duracion);
            tiempoPrimera = duracion;

            HttpResponse<byte[]> response1 = cliente1.send(request1, HttpResponse.BodyHandlers.ofByteArray());

            byte[] respuestaBytes = response1.body();

            long numeroBytes = respuestaBytes.length;

            System.out.println("Número de bytes: " + numeroBytes);
            bytesPrimera = numeroBytes;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            //Creamos cliente
            HttpClient cliente2 = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            //Crear petición
            HttpRequest request2 = HttpRequest.newBuilder()
                    .uri(URI.create(segunda))
                    .GET()
                    .build();


            long startTime2 = System.currentTimeMillis();

            HttpResponse<String> response = cliente2.send(request2, HttpResponse.BodyHandlers.ofString());

            long endTime2 = System.currentTimeMillis();

            long duracion = endTime2 - startTime2;

            System.out.println("Duración de la segunda conexion: " + duracion);
            tiempoSegunda = duracion;

            HttpResponse<byte[]> response1 = cliente2.send(request2, HttpResponse.BodyHandlers.ofByteArray());

            byte[] respuestaBytes = response1.body();

            long numeroBytes = respuestaBytes.length;

            System.out.println("Número de bytes: " + numeroBytes);
            bytesSegunda = numeroBytes;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(tiempoPrimera<tiempoSegunda){
            System.out.println("La web más rápida es: " + primera + " con " + tiempoPrimera + " ms");
        }else {
            System.out.println("La web más rápida es: " + segunda + " con " + tiempoSegunda + " ms");
        }

        if(bytesPrimera>bytesSegunda){
            System.out.println("La web con más contenido es: " + primera + " con " + bytesPrimera + " caracteres");
        }else{
            System.out.println("La web con más contenido es: " + segunda + " con " + bytesSegunda + " caracteres");
        }
    }
}
