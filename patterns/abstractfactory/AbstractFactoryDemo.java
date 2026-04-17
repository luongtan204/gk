package com.patterns.abstractfactory;

// Abstract Factory example
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        UniversityFactory under = new UndergradFactory();
        Transcript t = under.createTranscript();
        Certificate c = under.createCertificate();
        t.print();
        c.print();
    }
}

interface Transcript { void print(); }
interface Certificate { void print(); }

interface UniversityFactory {
    Transcript createTranscript();
    Certificate createCertificate();
}

class UndergradTranscript implements Transcript {
    public void print() { System.out.println("Undergrad Transcript printed."); }
}
class UndergradCertificate implements Certificate {
    public void print() { System.out.println("Undergrad Certificate printed."); }
}

class UndergradFactory implements UniversityFactory {
    public Transcript createTranscript() { return new UndergradTranscript(); }
    public Certificate createCertificate() { return new UndergradCertificate(); }
}

