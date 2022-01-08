package encryptdecrypt;

public class UnicodeEncryptor extends Cipher {

    public UnicodeEncryptor(int key) {
        super(key);
    }

    @Override
    public String execute(String message) {
        return message.chars().map(x -> x + key).mapToObj(Character::toString).reduce("", String::concat);
    }
}
