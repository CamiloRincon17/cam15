
import java.util.Scanner;

public class WhatEver {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int CantidadNumber = 0;
    System.out.println("Ingrese la longitud del vector");
    CantidadNumber =in.nextInt();
    int[] NumeroVector = new int[CantidadNumber]; 
    System.out.println("Ingrese los numeros del vector"); 
    for (int i = 0; i < NumeroVector.length; i++) {
    
        NumeroVector[i] = in.nextInt();
        
    }
    for (int i = 0; i < NumeroVector.length; i++) {
    System.out.println("los numeros que ingreso  son "+NumeroVector[i]);        
    }

    }
}
