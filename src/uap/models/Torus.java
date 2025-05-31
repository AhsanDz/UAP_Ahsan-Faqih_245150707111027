package uap.models;
import uap.interfaces.*;
import uap.bases.*;

public class Torus extends Shape implements ThreeDimensional, PiRequired, MassCalculable, ShippingCostCalculator, MassConverter {
    private double majorRadius;
    private double minorRadius;
    
    public Torus() {
    }
    
    public Torus(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }
    
    @Override
    public double getVolume() {
        // V = 2π²Rr²
        return 2 * PI * PI * majorRadius * minorRadius * minorRadius;
    }
    
    @Override
    public double getSurfaceArea() {
        // A = 4π²Rr
        return 4 * PI * PI * majorRadius * minorRadius;
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

