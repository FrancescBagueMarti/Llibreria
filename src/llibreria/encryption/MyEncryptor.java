package llibreria.encryption;

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

public class MyEncryptor {
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

        public SecretKeySpec getKey(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
            byte[] claveEncriptar = MessageDigest.getInstance("SHA-1").digest(clave.getBytes("UTF-8"));
            claveEncriptar = Arrays.copyOf(claveEncriptar, 16);
            return new SecretKeySpec(claveEncriptar, "AES");
        }

        public static String encriptar (String dato, SecretKeySpec key) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
            UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException 
        {
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] datosAEncriptar = dato.getBytes("UTF-8");
            byte[] bytesEncriptados = cipher.doFinal(datosAEncriptar);

            return Base64.getEncoder().encodeToString(bytesEncriptados);
        }

        public static String desencriptar (String dato, SecretKeySpec key) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
            IllegalBlockSizeException, BadPaddingException 
        {
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] bytesEncriptados = Base64.getDecoder().decode(dato);
            byte[] datoDesencriptado = cipher.doFinal(bytesEncriptados);

            return new String(datoDesencriptado);
        }

        public static String generarCadena(String... args) {
            String cadena = "";
            for (String s : args) {
                cadena += s + ":";
            }
            return cadena.substring(0, cadena.length()-1);
        }
        public static String generarCadena(char separator, String... args) {
            String cadena = "";
            for (String s : args) {
                cadena += s + separator;
            }
            return cadena.substring(0, cadena.length()-1);
        }
    }
}
