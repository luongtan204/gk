package com.patterns.factorymethod;

// Factory Method example (based on the user's specification)
public class FactoryMethodDemo {
    public static void main(String[] args) {
        DocumentFactory transcriptFactory = new TranscriptFactory();
        DocumentFactory certificateFactory = new CertificateFactory();

        Document d1 = transcriptFactory.createDocument();
        Document d2 = certificateFactory.createDocument();

        d1.generate(); // Xuất Bảng điểm
        d2.generate(); // Xuất Giấy xác nhận
    }
}

interface Document { void generate(); }

class Transcript implements Document {
    public void generate() { System.out.println("Xuất Bảng điểm sinh viên."); }
}
class Certificate implements Document {
    public void generate() { System.out.println("Xuất Giấy xác nhận sinh viên."); }
}

abstract class DocumentFactory {
    abstract Document createDocument();
}

class TranscriptFactory extends DocumentFactory {
    Document createDocument() { return new Transcript(); }
}

class CertificateFactory extends DocumentFactory {
    Document createDocument() { return new Certificate(); }
}

