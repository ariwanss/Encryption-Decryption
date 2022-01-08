package encryptdecrypt;

public class ShiftDecrypter extends Cipher {

    public ShiftDecrypter(int key) {
        super(key);
    }

    @Override
    public String execute(String message) {
        return message.chars()
                .map(
                        x -> {
                            if (x >= FIRST_UPPERCASE_LETTER && x <= LAST_UPPERCASE_LETTER) {
                                return (x + 26 - key - FIRST_UPPERCASE_LETTER) % 26 + FIRST_UPPERCASE_LETTER;
                            } else if (x >= FIRST_LOWERCASE_LETTER && x <= LAST_LOWERCASE_LETTER) {
                                return (x + 26 - key - FIRST_LOWERCASE_LETTER) % 26 + FIRST_LOWERCASE_LETTER;
                            } else {
                                return x;
                            }
                        }
                )
                .mapToObj(Character::toString)
                .reduce("", String::concat);
    }

    @Override
    public String toString() {
        return "Shift Decrypter";
    }
}
