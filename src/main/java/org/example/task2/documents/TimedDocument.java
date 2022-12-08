package org.example.task2.documents;

public class TimedDocument implements Document{
    Document document;
    public TimedDocument(Document smartDocument) {
        document = smartDocument;
    }
    @Override
    public String parse() {
        long start = System.nanoTime();
        String parsed = document.parse();
        System.out.println("Parsing took " + ((double)(System.nanoTime() - start) / 1000000000) + " seconds.\n\n");
        return parsed;
    }
}
