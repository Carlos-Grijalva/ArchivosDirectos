
import java.lang.*;
import java.io.*;

class Creacion {

    public static void main(String[] args) {
// creando e inicializando los campos del registro
// observar que se debe usar clases numéricas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
// abriendo archivo, capturando y grabando datos
        try {
//* Creando y grabando a un archivo, esta larga la instrucción*/
            File arch = new File("c:\\ajava\\archivo2.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            archivo.close();
        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */ } catch (IOException ioe) {
            /* Error al escribir */ }
// avisando
        System.out.println("ARCHIVO DIRECTO CREADO");
    } // cierra main
} // cierra clase
