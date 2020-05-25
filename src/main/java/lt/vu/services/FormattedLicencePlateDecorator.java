package lt.vu.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class FormattedLicencePlateDecorator implements ILicencePlateGenerator {
    @Inject @Delegate @Any ILicencePlateGenerator licencePlateGenerator;

    @Override
    public String generateLicencePlate() {
        String licencePlate = licencePlateGenerator.generateLicencePlate();

        int indexOfLastLetter = 0;
        for (int i = 0; i < licencePlate.length(); i++) {
            if (licencePlate.charAt(i) >= 'A' && licencePlate.charAt(i) <= 'Z') {
                indexOfLastLetter = i;
            }
        }

        licencePlate = licencePlate.substring(0, indexOfLastLetter + 1) + "-" + licencePlate.substring(indexOfLastLetter + 1);
        return licencePlate;
    }
}
