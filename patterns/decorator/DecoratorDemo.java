package com.patterns.decorator;

// Decorator example
public class DecoratorDemo {
    public static void main(String[] args) {
        Tuition basic = new BasicTuition();
        Tuition withInsurance = new HealthInsuranceDecorator(basic);
        Tuition withAll = new ParkingDecorator(withInsurance);

        System.out.println("Base cost: " + basic.getCost());
        System.out.println("With Health Insurance: " + withInsurance.getCost());
        System.out.println("With Insurance + Parking: " + withAll.getCost());
    }
}

interface Tuition { double getCost(); }

class BasicTuition implements Tuition {
    public double getCost() { return 15000000; }
}

abstract class TuitionDecorator implements Tuition {
    protected Tuition tuition;
    public TuitionDecorator(Tuition t) { this.tuition = t; }
    public double getCost() { return tuition.getCost(); }
}

class HealthInsuranceDecorator extends TuitionDecorator {
    public HealthInsuranceDecorator(Tuition t) { super(t); }
    public double getCost() { return super.getCost() + 800000; }
}

class ParkingDecorator extends TuitionDecorator {
    public ParkingDecorator(Tuition t) { super(t); }
    public double getCost() { return super.getCost() + 200000; }
}

