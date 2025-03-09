
import java.util.Scanner;

public class WhatGet {
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
     System.out.println("ingrese el valor del primer numero");
    int Num1=in.nextInt();
     System.out.println("Ingrese eñ valor del segundo numero");
    int Num2=in.nextInt();

    int Num1 = 0;
    int Num2 = 0;
    int Suma,Resta,Divicion,Multiplicacion;
    int ValorNumber=in.nextInt();
      
    switch ( opcion){
        case 1:
         Resultado = Num1 + Num2 ;
         System.out.println("");
             break;
        case 2:
         Resultado =Num1/Num2;    
         break;
        case 3:
         Resultado = Num1 - Num2 ;
             break;
        case 4:
         Resultado = Num1 * Num2;
        default:
        Resultado = 
           break;

       }
   } 
}
