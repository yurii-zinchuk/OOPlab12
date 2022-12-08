package org.example.task2.documents;

import lombok.Getter;

public class CachedDocument implements Document{
    @Getter
    private final Document document;
    @Getter
    private final String gcsPath;
    private final Database db;

    public CachedDocument(Document doc) {
        document = doc;
        gcsPath = doc.getGcsPath();
        db = Database.getInstance();
    }

    @Override
    public String parse() {
        String parsed;
        parsed = db.getParsedTextByFilePath(document.getGcsPath());

        if (parsed == null) {
            parsed = document.parse();
            db.addParsedText(document.getGcsPath(), parsed);
        }

        return parsed;
    }
}
