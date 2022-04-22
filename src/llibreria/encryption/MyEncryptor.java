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

/**
 * Class with inner Classes oriented to work with data encrypttion
 * @author Francesc Bague Marti
 * @version 1.0 2022/04/17
 */
public class MyEncryptor {
    /**
     * Interfaz para la realización de processos de encriptación personalizados per el programador
     */
    public static interface customizedEncryptionProcess {
        abstract String customProcess();
    }
    /**
     * Class for the encryption of passwords
     */
    public static class BlowFish {
        /**
         * Generate a salt for use with the BCrypt.hashpw() method, selecting a reasonable default for the number of hashing rounds to apply
         * @return an encoded salt value
         */
        public static String genSalt(){
            return BCrypt.gensalt();
        }
        /**
         * Generate a salt for use with the BCrypt.hashpw() method
         * @param i the log2 of the number of rounds of hashing to apply - the work factor therefore increases as 2**log_rounds.
         * @return an encoded salt value
         */
        public static String genSalt(int i) {
            return BCrypt.gensalt(i);
        }
        /**
         * Generate a salt for use with the BCrypt.hashpw() method
         * @param i the log2 of the number of rounds of hashing to apply - the work factor therefore increases as 2**log_rounds.
         * @param random an instance of SecureRandom to use
         * @return an encoded salt value
         */
        public static String genSalt(int i, SecureRandom random) { 
            return BCrypt.gensalt(i, random);
        }
        /**
         * Hash a password using the OpenBSD bcrypt scheme
         * @param pass the password to hash
         * @param salt the salt to hash with (perhaps generated using BCrypt.gensalt)
         * @return the hashed password
         */
        public static String hashpw(String pass, String salt) {
            return BCrypt.hashpw(pass, salt);
        }
        /**
         * Check that a plaintext password matches a previously hashed one
         * @param pass the plaintext password to verify
         * @param hash the previously-hashed password
         * @return true if the passwords match, false otherwise
         */
        public static boolean checkpw(String pass, String hash) {
            return BCrypt.checkpw(pass, hash);
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
        public static String useCustomizedEncryptionProcess(customizedEncryptionProcess process) {
            return process.customProcess();
        }
    }
}