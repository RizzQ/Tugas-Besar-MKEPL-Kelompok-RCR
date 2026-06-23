package Kalkulator;

import java.sql.*;

public class CodeQLExamples {

    // Example 1: SQL injection via string concatenation
    public void vulnerableSql(String userInput) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:");
            stmt = conn.createStatement();
            // unsafe concatenation of user input into SQL
            String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
            stmt.executeQuery(query);
        } finally {
            if (stmt != null) try { stmt.close(); } catch (Exception e) {}
            if (conn != null) try { conn.close(); } catch (Exception e) {}
        }
    }

    // Example 2: Command injection via Runtime.exec with concatenated input
    public void vulnerableExec(String host) throws Exception {
        // unsafe concatenation of untrusted input into shell command
        String cmd = "ping -n 1 " + host;
        Runtime.getRuntime().exec(cmd);
    }

    // Example 3: Hardcoded credential
    private static final String API_PASSWORD = "SuperSecret123"; // should be stored in secret store

    public String useHardcodedPassword() {
        // pretend to use the hardcoded password
        return "Using password: " + API_PASSWORD;
    }

    // helper main to avoid unused warnings during compilation
    public static void main(String[] args) throws Exception {
        CodeQLExamples ex = new CodeQLExamples();
        ex.useHardcodedPassword();
        ex.vulnerableSql("alice");
        ex.vulnerableExec("localhost");
    }
}
