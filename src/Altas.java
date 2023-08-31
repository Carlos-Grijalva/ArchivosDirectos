
import java.lang.*;
import java.io.*;

class Altas {

    public static void main(String[] args) {
        // creando e inicializando los campos del registro
        // observar que se debe usar clases numericas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
        // creando objeto teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        // abriendo archivo, capturando y grabando datos
        try {
            //* Creando y grabando a un archivo, esta larga la instrucción*/
            File arch = new File("c:\\ajava\\archivo2.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            System.out.println("dame clave: ");
            clave = Integer.parseInt(teclado.readLine());
            System.out.println("dame nombre: ");
            nombre = teclado.readLine();
            //dejando string en 25 caracteres
            if (nombre.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            } else {
                nombre = nombre.substring(0, 25);
            };
            System.out.println("dame edad: ");
            edad = Integer.parseInt(teclado.readLine());
            // grabando al archivo
            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
            };
            archivo.writeInt(clave);
            // y recordar que cada caracter se graba en dos bytes
            archivo.writeChars(nombre);
            archivo.writeInt(edad);
            archivo.close();
        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */ } catch (IOException ioe) {
            /* Error al escribir */ }
    } // cierra main
} // cierra clase

