package Project_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Restaurant {
    private SalatMaker chef = new Chef();
    private Salat salat;

    public void createSalat() {
        while (true) {
            switch (menuKey()) {
                case 1:
                    salat = chef.makeSalat("TomatoSalat");
                    System.out.println(salat);
                    break;
                case 2:
                    salat = chef.makeSalat("GreekSalat");
                    System.out.println(salat);
                    break;
                case 3:
                    salat.sortByCalories();
                    System.out.println(salat);
                    break;
                case 4:
                    salat.countCalories();
                    break;
                case 5:
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Enter min Calorie");
                        double min = Double.parseDouble(reader.readLine());
                        System.out.println("Enter max Calorie");
                        double max = Double.parseDouble(reader.readLine());
                        salat.getVegetablesFromRange(min, max);
                    } catch (NumberFormatException e) {
                        System.out.println("Пустая Строка");
                    } catch (Exception e) {
                        System.out.println("Неправильный ввод");
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private int menuKey() {
        int key = 0;
        System.out.println(" 1 - Салат из помидор \n" +
                " 2 - Греческий салат \n" +
                " 3 - Отсортировать салат по калорийности \n" +
                " 4 - Калорийность салата \n" +
                " 5 - Найти овощи в салате, соответствующие заданному диапазону калорийности \n" +
                " 6 - Выход");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            key = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException numEx) {
            System.out.println("Неправильно введено число");
        } catch (Exception e) {
            e.getMessage();
        }
        return key;
    }
}
