package org.example.task2.documents;

import java.sql.*;
import java.util.Objects;

public class Database {
    private static Database instance;
    private  Connection c;

    private Database() {
        openDB();
        createTable();
    }

    private void openDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:cache.db");

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private void createTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS CACHE" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " FILEPATH           TEXT, " +
                    " PARSED            TEXT )";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Created table successfully");
    }

    public static Database getInstance() {
        instance = Objects.requireNonNullElseGet(instance, Database::new);
        return instance;
    }

    public String getParsedTextByFilePath(String filepath) {
        String parsed = null;
        try {
            String sql = "SELECT PARSED from CACHE WHERE FILEPATH = ?;";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1, filepath);

            ResultSet response = pstmt.executeQuery();

            if (response.next()) {
                parsed = response.getString("PARSED");
                System.out.println("Found parsed text in a database successfully.\n");
            } else {
                System.out.println("Did not find parsed text in cache. Parsing to be done.\n");
            }
            pstmt.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return parsed;
    }

    public void addParsedText(String filePath, String parsed) {
        try {
            String sql = "INSERT INTO CACHE (FILEPATH,PARSED) VALUES (?, ? );";
            PreparedStatement pstmt  = c.prepareStatement(sql);
            pstmt.setString((int)1, filePath);
            pstmt.setString((int)2, parsed);

            pstmt.executeUpdate();
            pstmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Parsed text cached successfully.\n");
    }
}
