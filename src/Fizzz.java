public class Fizzz {
    public static void main(String[] args) {
        for (int Numero=0; Numero<100; ){
            Numero=Numero+1;

            if(Numero % 3 == 0 && Numero % 5 ==0){
                System.out.println("fizzbuzzz");
            }
            else if (Numero % 3 ==0) {
                System.out.println("Fizz");
            }
            else if (Numero % 5 ==0) {
                System.out.println("Buzz");
            }else{        
                System.out.println(Numero);

            }

        }
    }
}
