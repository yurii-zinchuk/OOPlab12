package org.example.task2.documents;

import lombok.Getter;

public class TimedDocument implements Document{
    @Getter
    private Document document;
    @Getter
    private String gcsPath;

    public TimedDocument(Document doc) {
        document = doc;
        gcsPath = doc.getGcsPath();
    }

    @Override
    public String parse() {
        long start = System.nanoTime();
        String parsed = document.parse();
        System.out.println("Parsing took " + ((double)(System.nanoTime() - start) / 1000000000) + " seconds.\n");
        return parsed;
    }
}
