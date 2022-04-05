package llibreria.encriptation;
import java.security.SecureRandom;

import org.mindrot.jbcrypt.BCrypt;

public class MyEncrypter {
    public static class BlowFish {
        private String salt;
        public BlowFish(){}
        public void setSalt(String salt){
            this.salt = salt;
        }
        public String getSalt() {
            return this.salt;
        }
        public static String genSalt(){
            return BCrypt.gensalt();
        }
        public static String genSalt(int i) {
            return BCrypt.gensalt(i);
        }
        public static String genSalt(int i, SecureRandom sgr) { 
            return BCrypt.gensalt(i, sgr);
        }
        public String hashpw(String text, String salt) {
            return BCrypt.hashpw(text, salt);
        }
        public boolean checkpw(String text, String hash) {
            return BCrypt.checkpw(text, hash);
        }
    }
    public static class Aes {
        private String salt;
        public Aes(){}
        public void setSalt(String salt) {
            this.salt = salt;
        }
    }
}
