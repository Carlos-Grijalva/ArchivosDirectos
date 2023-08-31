
import java.lang.*;
import java.io.*;

class Filtros {

    public static void main(String[] args) {
        // creando e inicializando los campos del registro
        // observar que se debe usar clases numericas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
        long tregistro = 58;
        long cregistros = 0;
        int edadtemp = 0;
        // creando objeto teclado y capturando clave
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("edad mayor que: ");
            edadtemp = Integer.parseInt(teclado.readLine());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        // abriendo archivo, leyendo
        try {
            File arch = new File("c:\\ajava\\archivo2.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            //calulando cantidad de registros
            cregistros = archivo.length() / tregistro;
            for (int r = 0; r < cregistros; r++) {
                clave = archivo.readInt();
                //leyendo string
                for (int i = 0; i < 25; ++i) {
                    nombre += archivo.readChar();
                };
                edad = archivo.readInt();
                //desplegando
                if (edadtemp <= edad) {
                    System.out.println(clave + " " + nombre + " " + edad);
                };
                // limpiar strings o java encadena con la siguiente
                nombre = "";
            };
            archivo.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    } // cierra main
} // cierra clase
