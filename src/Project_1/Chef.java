package Project_1;

/**
 * Шеф-повар
 */

public class Chef extends SalatMaker {
    Salat createSalat(String type) {
        if (type.equals("GreekSalat")) {
            return new GreekSalat("GreekSalat");
        } else if (type.equals("TomatoSalat")) {
            return new TomatoSalat("TomatoSalat");
        } else {
            return null;
        }
    }
}