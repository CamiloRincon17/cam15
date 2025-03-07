import java.util.Scanner;
public class BiggerNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Num1=0;
        int Num2=0;
        int Num3=0;
        System.out.println("Ingresa el primer numero");
        Num1=in.nextInt();
        System.out.println("Ingresa el segundo numero");
        Num2=in.nextInt();
        System.out.println("Ingresa el tercer numero");
        Num3=in.nextInt();
if(Num1>=Num2 && Num1>=Num3) {
  System.out.println("El numero mayor es "+Num1);
    if(Num2>Num3){
        System.out.println("El orden es "+Num1+" "+Num2+" "+Num3);
      }else{
             System.out.println("El orden es "+Num1);
      } 
}else if (Num2>=Num3 && Num2>=Num1){
   System.out.println("El numero mayor es "+ Num2);
    if(Num3>=Num1){
        System.out.println("El numero orden de los numeros es "+Num2+" "+Num3+" "+Num1);
    }else{
        System.out.println("El orden de los numeros es "+Num2+" "+Num1+" "+Num3);
    }
}
else{
 System.out.println("El numero mayor es "+Num3);
    if (Num2>Num3) {
     System.out.println("El orden de los numero es "+Num3+" "+Num2+" "+Num1);
       }else{
        System.out.println("El orden de los numeros es "+Num3+" "+Num1+" "+Num2);
 }
}
    }
}
