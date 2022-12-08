package org.example.task2;

import org.example.task2.documents.Document;
import org.example.task2.documents.SmartDocument;
import org.example.task2.documents.TimedDocument;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        document = new TimedDocument(document);
//        document = CashedDocument(document);
        System.out.println(document.parse());


    }
}
