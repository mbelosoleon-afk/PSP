package Tarea41;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cliente {
    public static void main(String[] args) throws IOException {
        //1.DEFINIR CONFIANZA (¿De quién me fío?)
        System.setProperty("javax.net.ssl.trustStore","servidor.p12");
        System.setProperty("javax.net.ssl.trsutStorePassword","123456");

        //2. CONECTAR USANDO LA FACTORÍA
        SSLSocketFactory factory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();

        //Factory ya ha configurado la seguridad por nosotros
        SSLSocket socket =
                (SSLSocket) factory.createSocket("localhost",8443);

        //3.LEER DATOS
        InputStream is = socket.getInputStream();
        System.out.println("Recibido: " + new String((is.readAllBytes())));

    }
}
