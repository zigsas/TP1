package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class LicencePlateGenerator implements Serializable {
    public String generateLicencePlate() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }

        String generatedLicencePlate = generate();
        return generatedLicencePlate;
    }

    private String generate() {
        int minLetter = 65; // letter 'A'
        int maxLetter = 90; // Letter 'Z'

        int minNumber = 48; // numeral '0'
        int maxNumber = 57; // numeral '9'

        int length = 3;
        Random random = new Random();

        String generatedLetters = random.ints(minLetter, maxLetter + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedNumbers = random.ints(minNumber, maxNumber + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedLicencePlate = generatedLetters + generatedNumbers;
        return generatedLicencePlate;
    }
}