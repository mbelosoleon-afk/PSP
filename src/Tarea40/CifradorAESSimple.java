package Tarea40;

import java.io.PrintWriter;
import java.security.Key;

public class CifradorAESSimple {

    public static void main(String[] args) {
        final int LONGITUD_BLOQUE = 16; // Expresado en bytes
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "RememberSammyJenkins";
        final String TEXTO_SIN_CIFRAR = "No te creas las mentiras de Teddy";

        try {
            Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
            String textoCifrado = AESSimpleManager.cifrar(TEXTO_SIN_CIFRAR, clave);

            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifrado);
            pw.close();

            System.out.println("El mensaje se ha cifrado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}