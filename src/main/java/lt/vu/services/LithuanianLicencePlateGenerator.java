package lt.vu.services;

import lt.vu.interceptors.IMethodProgressLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
@Alternative
public class LithuanianLicencePlateGenerator implements Serializable, ILicencePlateGenerator {
    @Override
    @IMethodProgressLogger
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

        int lettersLength = 3;
        int numbersLength = 3;
        Random random = new Random();

        String generatedLetters = random.ints(minLetter, maxLetter + 1)
                .limit(lettersLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedNumbers = random.ints(minNumber, maxNumber + 1)
                .limit(numbersLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedLicencePlate = generatedLetters + generatedNumbers;
        return generatedLicencePlate;
    }
}