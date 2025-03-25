
import java.util.Scanner;

public class PleasPassword {
    public static void main(String[] args) {
        String OriginalPassword = "cam";
        String OriginalMain = "camilo17";
        Scanner in = new Scanner(System.in);
        String User="";
        System.out.println("Ingrese el usuario"); User=in.nextLine();
        String  Password ="";
        System.out.println("ingrese la contraseña"); Password=in.nextLine();
        if(OriginalMain.equals(User)){
            System.out.println("El usuario aprobado");
            if(OriginalPassword.equals(Password)){
            System.out.println("El usuario y la contraseña estan correcta");
            }
            else{
                System.out.println("El usuario esta bien pero la contraseña no");
            }
        }
        else{
            System.out.println("Error al Ingresar el usuario");
        }
    }
}
