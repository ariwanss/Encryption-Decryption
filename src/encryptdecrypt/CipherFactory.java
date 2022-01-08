package encryptdecrypt;

public class CipherFactory {

    public static Cipher make(String mode, String algorithm, int key) {
        switch (mode) {
            case "enc":
                switch (algorithm) {
                    case "shift":
                        return new ShiftEncryptor(key);
                    case "unicode":
                        return new UnicodeEncryptor(key);
                }
            case "dec":
                switch (algorithm) {
                    case "shift":
                        return new ShiftDecrypter(key);
                    case "unicode":
                        return new UnicodeDecrypter(key);
                }
        }
        throw new IllegalArgumentException();
    }
}
