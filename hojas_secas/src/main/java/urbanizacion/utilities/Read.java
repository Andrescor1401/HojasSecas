package urbanizacion.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    

    public static String readLine(BufferedReader bIn, String label) throws IOException {
        System.out.print(label);
        return bIn.readLine();
    }

    public static double readDouble(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                double retornar = Double.parseDouble(bIn.readLine());
                return retornar;
            } catch (NumberFormatException e) {
                System.err.println("Opcion invalida, debe ingresar un numero");
            }
        } while (true);
    }

    public static int readInt(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                int retornar = Integer.parseInt(bIn.readLine());
                return retornar;
            } catch (NumberFormatException e) {
                System.err.println("Opcion invalida, debe ingresar un dato numero de tipo entero");
            }
        } while (true);
    }

    public static float readFloat(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                float retornar = Float.parseFloat(bIn.readLine());
                return retornar;
            } catch (NumberFormatException e) {
                System.err.println("Opcion invalida, debe ingresar un dato numero de tipo float");
            }
        } while (true);
    }

    public static boolean readBoolean(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                boolean retornar = Boolean.parseBoolean(bIn.readLine());
                return retornar;
            } catch (IOException e) {
                System.err.println("Debe ingresar un dato booleano (true/false)");
            }
        } while (true);
    }
}
