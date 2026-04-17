package com.patterns.strategy;
// Strategy example
public class StrategyDemo {
    public static void main(String[] args) {
        StudentFeeCalculator calc = new StudentFeeCalculator();
        calc.setStrategy(new GPAStrategy());
        calc.calculateFinalFee(1000000);

        calc.setStrategy(new PoorHouseholdStrategy());
        calc.calculateFinalFee(1000000);
    }
}

interface ScholarshipStrategy { double calculateDiscount(double tuition); }

class GPAStrategy implements ScholarshipStrategy {
    public double calculateDiscount(double tuition) { return tuition * 0.5; }
}
class PoorHouseholdStrategy implements ScholarshipStrategy {
    public double calculateDiscount(double tuition) { return tuition * 0.8; }
}

class StudentFeeCalculator {
    private ScholarshipStrategy strategy;
    public void setStrategy(ScholarshipStrategy strategy) { this.strategy = strategy; }
    public void calculateFinalFee(double tuition) {
        double discount = strategy.calculateDiscount(tuition);
        System.out.println("Học phí còn lại: " + (tuition - discount));
    }
}

