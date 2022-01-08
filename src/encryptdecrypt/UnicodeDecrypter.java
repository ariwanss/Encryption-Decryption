package encryptdecrypt;

public class UnicodeDecrypter extends Cipher {

    public UnicodeDecrypter(int key) {
        super(key);
    }

    @Override
    public String execute(String message) {
        return message.chars().map(x -> x - key).mapToObj(Character::toString).reduce("", String::concat);
    }
}
