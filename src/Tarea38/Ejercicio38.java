package Tarea38;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

public class Ejercicio38 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);

        //Fase de crear contraseña
        System.out.println("Crea una contraseña");

        String contrasena = scan.nextLine();

        String resultado = cifrar(contrasena);

        System.out.println("Contraseña cifrada: " + resultado);

        //Fase de logeo
        System.out.println("Usuario registrado. Inicie sesión para probar");

        System.out.println("Introduzca su contraseña");

        String logeo = scan.nextLine();

        String resultado2 = cifrar(logeo);

        if(resultado.equals(resultado2)) {
            System.out.println("Ha iniciado sesión correctamente, los Hash son iguales");
        }else {
            System.out.println("Contraseña incorrecta, los Hash son distintos");
            System.out.println(resultado2);s
        }

    }

    public static String cifrar(String texto) throws NoSuchAlgorithmException {
        //1. Instanciar
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        //2. Cargar datos
        md.update(texto.getBytes());

        //3. Resumir (devuelve bytes)
        byte[] resumen = md.digest();

        //4. Convertir a Hexadecimal (Legible)
        String hex = HexFormat.of().formatHex(resumen);

        return hex;
    }
}
