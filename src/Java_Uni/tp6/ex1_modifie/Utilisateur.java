package Java_Uni.tp6.ex1_modifie;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class Utilisateur {
    protected String username;
    protected String passwordHash;

    Utilisateur(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username vide wla nul");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("password vide wla nul");
        }
        this.username = username.trim().toLowerCase();
        this.passwordHash = hash(password);
    }

    // blah blah blah
    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    // blah blah blah
    protected boolean checkPassword(String attempt) {
        return passwordHash.equals(hash(attempt));
    }

    protected boolean seConnecter(String username, String pass) throws ConnexionException {
        if (username.isEmpty()) {
            throw new ConnexionException("username fera8");
        }
        if (pass.isEmpty()) {
            throw new ConnexionException("pass fera8");
        }
        if (!username.equals(this.username) || !checkPassword(pass)) {
            throw new ConnexionException("username or pass incorrect");
        }
        return true;
    }

    @Override
    public String toString() {
        return "username : " + username;
    }
}
