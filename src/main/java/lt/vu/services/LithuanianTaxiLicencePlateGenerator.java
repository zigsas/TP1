package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.Random;

@Specializes
@ApplicationScoped
public class LithuanianTaxiLicencePlateGenerator extends LithuanianLicencePlateGenerator {
    @Override
    public String generateLicencePlate() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }

        String generatedLicencePlate = generate();
        return generatedLicencePlate;
    }

    private String generate() {
        int minNumber = 48; // numeral '0'
        int maxNumber = 57; // numeral '9'

        int numbersLength = 5;
        Random random = new Random();

        String generatedLetters = "T";

        String generatedNumbers = random.ints(minNumber, maxNumber + 1)
                .limit(numbersLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generatedLicencePlate = generatedLetters + generatedNumbers;
        return generatedLicencePlate;
    }
}
