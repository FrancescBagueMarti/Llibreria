package llibreria.encriptation;

import java.security.SecureRandom;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.mindrot.jbcrypt.BCrypt;

public class MyEncrypter {
    public static class BlowFish {
        public static String genSalt(){
            return BCrypt.gensalt();
        }
        public String genSalt(int i) {
            return BCrypt.gensalt(i);
        }
        public String genSalt(int i, SecureRandom sgr) { 
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
        private static final String CIPHER_INSTANCE = "AES/ECB/PKCS5Padding";
        public static SecretKeySpec getKey(String clave) 
            throws UnsupportedEncodingException, NoSuchAlgorithmException 
        {
            //byte[] claveEncriptar = clave.getBytes("UTF-8");
            //MessageDigest sha = MessageDigest.getInstance("SHA-1");

            byte[] claveEncriptar = MessageDigest.getInstance("SHA-1").digest(clave.getBytes("UTF-8"));
            claveEncriptar = Arrays.copyOf(claveEncriptar, 16);

            return new SecretKeySpec(claveEncriptar, "AES");
        }
    }
}
