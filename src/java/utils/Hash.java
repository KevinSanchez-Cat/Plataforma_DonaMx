package utils;

import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Hash {

    /**
     * Retorna un hash a partir de un tipo y un texto
     *
     * @param txt texto para cifrar
     * @param hashType metodo de cifrado
     * @return una nueva cadena, cifrada
     */
    public static String getHash(String txt, String hashType) {

        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String md5(String txt) {
        return getHash(txt, "MD5");
    }

    public static String sha1(String txt) {
        return getHash(txt, "SHA1");
    }
}
