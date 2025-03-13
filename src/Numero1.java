public class Numero1 {
    public static void main(String[] args) {
        int numero = 12345;

        // Convertir el número a una cadena
        String cadenaNumero = Integer.toString(numero);

        // Recorrer cada carácter de la cadena
        for (int i = 0; i < cadenaNumero.length(); i++) {
            char digitoChar = cadenaNumero.charAt(i); // Obtener el carácter
            int digito = Character.getNumericValue(digitoChar); // Convertir a número
            System.out.println("Dígito " + (i + 1) + ": " + digito);
        }
    }
}