package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EncryptorDecrypter {

    private String mode;
    private String algorithm;
    private String message;
    private String outputFile;
    private int key;
    private Cipher cipher;

    private void initializeFields(String[] args) {
        this.mode = "enc";
        this.key = 0;
        this.message = "";
        this.algorithm = "shift";
        this.outputFile = "";

        List<String> arguments = Arrays.asList(args);
        if (arguments.contains("-mode")) {
            mode = arguments.get(arguments.indexOf("-mode") + 1);
        }
        if (arguments.contains("-key")) {
            key = Integer.parseInt(arguments.get(arguments.indexOf("-key") + 1));
        }
        if (arguments.contains("-in")) {
            String filename = arguments.get(arguments.indexOf("-in") + 1);
            try (Scanner scanner = new Scanner(new File(filename))) {
                message = scanner.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("Error file not found");
            }
        }
        if (arguments.contains("-data")) {
            message = arguments.get(arguments.indexOf("-data") + 1);
        }
        if (arguments.contains("-out")) {
            outputFile = arguments.get(arguments.indexOf("-out") + 1);
        }
        if (arguments.contains("-alg")) {
            algorithm = arguments.get(arguments.indexOf("-alg") + 1);
        }

        this.cipher = CipherFactory.make(mode, algorithm, key);
    }

    public void run(String[] args) {
        initializeFields(args);
        if (outputFile.isEmpty()) {
            System.out.println(cipher.execute(message));
        } else {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                printWriter.println(cipher.execute(message));
            } catch (FileNotFoundException e) {
                System.out.println("Error file not found");
            }
        }

    }
}
