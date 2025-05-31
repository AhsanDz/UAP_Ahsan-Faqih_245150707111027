package uap.models;
import uap.interfaces.*;
import uap.bases.*;

public class Sphere extends Shape implements ThreeDimensional, PiRequired, MassCalculable, ShippingCostCalculator, MassConverter {
    private double radius;
    
    public Sphere() {
    }
    
    public Sphere(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getVolume() {
        // V = (4/3)πr³
        return (4.0/3.0) * PI * radius * radius * radius;
    }
    
    @Override
    public double getSurfaceArea() {
        // A = 4πr²
        return 4 * PI * radius * radius;
    }
    
    @Override
    public double getMass() {
        // m = ρ × A × t
        return DENSITY * getSurfaceArea() * THICKNESS;
    }
    
    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }
    
    @Override
    public double calculateCost() {
        double massInKg = gramToKilogram();
        int roundedKg = (int) Math.ceil(massInKg);
        return roundedKg * PRICE_PER_KG;
    }
    
    @Override
    public void printInfo() {
        System.out.printf("Volume           : %.2f\n", getVolume());
        System.out.printf("Luas permukaan   : %.2f\n", getSurfaceArea());
        System.out.printf("Massa            : %.2f gram\n", getMass());
        System.out.printf("Massa dalam kg   : %.4f kg\n", gramToKilogram());
        System.out.printf("Biaya Kirim      : Rp %.0f\n", calculateCost());
    }
}