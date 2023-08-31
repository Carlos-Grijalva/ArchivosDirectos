
import java.lang.*;
import java.io.*;

class Lecturas {

    public static void main(String[] args) {
        // creando e inicializando los campos del registro
        // observar que se debe usar clases numericas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
        //recordar que un caracter son dos bytes en archivo
        long tregistro = 58;
        long cregistros = 0;
        // creando objeto teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        // abriendo archivo, capturando y grabando datos
        try {
            //* Creando y leyendo archivo, esta larga la instrucción*/
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
                System.out.println(clave + " " + nombre + " " + edad);
                // limpiar strings o java encadena con la siguiente
                nombre = "";
            };
            archivo.close();
        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */ } catch (IOException ioe) {
            /* Error al escribir */ }
    } // cierra main
} // cierra clase

