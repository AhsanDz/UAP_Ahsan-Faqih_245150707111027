package uap.mains;
import uap.models.*;
import java.util.Scanner;

public class KalkulatorPabrik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("Ahsan Faqih");
        System.out.println("245150707111027");
        System.out.println("===========================================");
        
        System.out.println("Donat dengan lubang");
        System.out.println("===========================================");
        System.out.print("Isikan Radius: ");
        double majorRadius = scanner.nextDouble();
        System.out.print("Isikan radius: ");
        double minorRadius = scanner.nextDouble();
        System.out.println("===========================================");
        
        Torus donatDenganLubang = new Torus(majorRadius, minorRadius);
        donatDenganLubang.printInfo();
        
        System.out.println("===========================================");
        
        System.out.println("Donat tanpa lubang");
        System.out.println("===========================================");
        System.out.print("Isikan Radius: ");
        double radius = scanner.nextDouble();
        System.out.println("===========================================");
        
        Sphere donatTanpaLubang = new Sphere(radius);
        donatTanpaLubang.printInfo();
        
        System.out.println("===========================================");
        
        scanner.close();
    }
}
