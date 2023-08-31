
import java.lang.*;
import java.io.*;

class Edicion {

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
            System.out.println("dame clave editar: ");
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
            //desplegando registro viejo
            System.out.println(clave + " " + nombre + " " + edad);
            System.out.print("NUEVO NOMBRE: ");
            nombre = teclado.readLine();
            //dejando string en 25 caracteres
            if (nombre.length() < 25) {
                for (int i = nombre.length(); i < 25; i++) {
                    nombre = nombre + " ";
                }
            } else {
                nombre = nombre.substring(0, 25);
            };
            System.out.print("NUEVA EDAD: ");
            edad = Integer.parseInt(teclado.readLine());
            // regresando apuntado y regrabando
            archivo.seek(archivo.getFilePointer() - tregistro);
            archivo.writeInt(clave);
            archivo.writeChars(nombre);
            archivo.writeInt(edad);
            nombre = "";
            archivo.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    } // cierra main
} // cierra clase
