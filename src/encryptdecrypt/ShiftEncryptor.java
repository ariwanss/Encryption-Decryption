package encryptdecrypt;

public class ShiftEncryptor extends Cipher {

    public ShiftEncryptor(int key) {
        super(key);
    }

    @Override
    public String execute(String message) {
        return message.chars()
                .map(
                        x -> {
                            if (x >= FIRST_UPPERCASE_LETTER && x <= LAST_UPPERCASE_LETTER) {
                                return (x + key - FIRST_UPPERCASE_LETTER) % 26 + FIRST_UPPERCASE_LETTER;
                            } else if (x >= FIRST_LOWERCASE_LETTER && x <= LAST_LOWERCASE_LETTER) {
                                return (x + key - FIRST_LOWERCASE_LETTER) % 26 + FIRST_LOWERCASE_LETTER;
                            } else {
                                return x;
                            }
                        }
                )
                .mapToObj(Character::toString)
                .reduce("", String::concat);
    }
}
