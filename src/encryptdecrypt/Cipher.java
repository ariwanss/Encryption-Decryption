package encryptdecrypt;

abstract class Cipher {
    public final static int FIRST_LOWERCASE_LETTER = 97;
    public final static int LAST_LOWERCASE_LETTER = 122;
    public final static int FIRST_UPPERCASE_LETTER = 65;
    public final static int LAST_UPPERCASE_LETTER = 90;
    int key;

    Cipher(int key) {
        this.key = key;
    }

    abstract String execute(String message);
}
