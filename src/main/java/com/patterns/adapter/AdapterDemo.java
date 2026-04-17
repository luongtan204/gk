package com.patterns.adapter;

// Adapter example
public class AdapterDemo {
    public static void main(String[] args) {
        ModernPayment payment = new BankAdapter(new LegacyBankAPI());
        payment.pay(1234.56);
    }
}

interface ModernPayment { void pay(double amount); }

class LegacyBankAPI {
    void processTransaction(String account, double money) {
        System.out.println("Thanh toán qua bank cũ: " + money);
    }
}

class BankAdapter implements ModernPayment {
    private LegacyBankAPI legacyBank;
    public BankAdapter(LegacyBankAPI legacyBank) { this.legacyBank = legacyBank; }
    @Override
    public void pay(double amount) {
        legacyBank.processTransaction("STUDENT_ACC", amount);
    }
}

