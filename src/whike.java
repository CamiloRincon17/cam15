public class whike {
    public static void main(String[] args) {
        int N1 =0;
        int N2 = 1;
       int condicional =0;
    for (int i = 0; i < 30; i++) {
        condicional=N1+N2;
       N1=N2;
       N2=condicional;
System.out.println(""+condicional);
    }

    }
}
