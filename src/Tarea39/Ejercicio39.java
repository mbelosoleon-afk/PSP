package Tarea39;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

public class Ejercicio39 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scan = new Scanner(System.in);

        String contrasena = "4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8";

        System.out.println("Escoja un número de los siguientes tres");
        System.out.println("1: Auditoría Flash, 2: Decodificador césar, 3: Fuerza Bruta Paralela");

        int opcion = scan.nextInt();

        switch (opcion){
            case 1:
                comprobarHash(contrasena);
                break;
            case 2:
                System.out.println("Decodificador");
                break;
            case 3:
                System.out.println("Fuerza Bruta");
                break;
        }
    }

    public static void comprobarHash(String contrasena) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");


        try (BufferedReader br = new BufferedReader(new FileReader("/home/dam/Documentos/PSP/src/Tarea39/diccionario(1).txt"))) {

            String linea;
            boolean encontrada = false;
            while ((linea = br.readLine()) != null) {

                String palabra = linea.trim();

                byte[] hash = md.digest(palabra.getBytes());

                String hex = HexFormat.of().formatHex(hash);

                if(hex.equals(contrasena)) {
                    System.out.println("¡CONTRASEÑA ENCONTRADA! la palabra es: " + linea);
                    encontrada = true;
                    break;
                }
            }
            if(!encontrada) {
                System.out.println("La contraseña no se encuentra en el diccionario");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
