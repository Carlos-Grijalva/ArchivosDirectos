
import java.lang.*;
import java.io.*;

class Operacion {

    public static void main(String[] args) {
        // creando e inicializando los campos del registro
        // observar que se debe usar clases numericas apropiadas
        int clave = 0;
        String nombre = "";
        int edad = 0;
        long tregistro = 58;
        long cregistros = 0;
        // abriendo archivo, leyendo
        try {
            File arch = new File("c:\\ajava\\archivo2.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            //calulando cantidad de registros
            cregistros = archivo.length() / tregistro;
            for (int r = 0; r < cregistros; r++) {
                // leyendo registro
                clave = archivo.readInt();
                //leyendo string
                for (int i = 0; i < 25; ++i) {
                    nombre += archivo.readChar();
                };
                edad = archivo.readInt();
                //sumando edad + 50
                edad = edad + 50;
                //regresando apuntador y regrabando con cambio
                archivo.seek(archivo.getFilePointer() - tregistro);
                archivo.writeInt(clave);
                archivo.writeChars(nombre);
                archivo.writeInt(edad);
                nombre = "";
            };
            archivo.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
// avisando
        System.out.println("YA TERMINE DE SUMAR");
    } // cierra main
} // cierra clase
