
import java.lang.*;
import java.io.*;

class Busqueda {

    public static void main(String[] args) {
        // creando e inicializando los campos del registro
        // observar que se debe usar clases numericas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
        long tregistro = 58;
        // creando objeto teclado y capturando clave
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("dame clave: ");
            clave = Integer.parseInt(teclado.readLine());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        // abriendo archivo, leyendo
        try {
            File arch = new File("c:\\ajava\\archivo2.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            archivo.seek(clave * tregistro);
            clave = archivo.readInt();
            //leyendo string
            for (int i = 0; i < 25; ++i) {
                nombre += archivo.readChar();
            };
            edad = archivo.readInt();
            //desplegando
            System.out.println(clave + " " + nombre + " " + edad);
            // limpiar strings o java encadena con la siguiente
            nombre = "";
            archivo.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    } // cierra main
} // cierra clase

