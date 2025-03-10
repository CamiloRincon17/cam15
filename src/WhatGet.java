
import java.util.Scanner;

public class WhatGet {
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
     System.out.println("ingrese el valor del primer numero");
    int Num1=in.nextInt();
     System.out.println("Ingrese eñ valor del segundo numero");
    int Num2=in.nextInt();
    int Suma,Resta,Divicion,Multiplicacion;
    int  Resultado=0;
    System.out.println("Menu para saber que opcion quieres ");
    System.out.println("1: si quieres Suma");
    System.out.println("2: si quieres Divicion");
    System.out.println("3: si quieres Resta");
    System.out.println("4: si quieres Multiplicar");
    int opcion=0;
    opcion=in.nextInt();
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
        Resultado = 0;
           break;

     
        }
   System.out.println("El resultado es "+Resultado);
   
    } 

}
