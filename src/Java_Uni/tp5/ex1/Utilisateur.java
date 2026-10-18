package Java_Uni.tp5.ex1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class Utilisateur {
    protected String username;
    protected String passwordHash;

    Utilisateur(String username, String password) {
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
    private boolean checkPassword(String attempt) {
        return passwordHash.equals(hash(attempt));
    }

    protected boolean seConnecter(String username, String pass) {
        return username.equals(this.username) && checkPassword(pass);
    }

    @Override
    public String toString() {
        return "username : " + username;
    }
}
