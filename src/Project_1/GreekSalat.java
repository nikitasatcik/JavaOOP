package Project_1;


import java.util.ArrayList;
import java.util.List;

/**
 * Греческий салат.
 */

public class GreekSalat extends Salat {
    private String name;
    private int weight;
    private double calories;
    private List<Vegetables> vegetables = new ArrayList<>();
    private List<Tomato> tomatoes;
    private List<Ocimum> ocimums;
    private List<Paprica> papricas;
    private List<Vegetables> regVegetables;


    public GreekSalat(String name) {
        this.name = name;
    }

    public void sliceVegetables() {
        System.out.println("Slicing Vegetables for " + name);
    }

    public void fillWithVegetables() {
        System.out.println("Add some vegetables");

        /******добавим помидорчики ******/
        tomatoes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                tomatoes.add(new Tomato("redTomato", (int) (Math.random() * 100), Math.random() * 100, "red"));
            } else {
                tomatoes.add(new Tomato("yellowTomato", (int) (Math.random() * 100), Math.random() * 100, "yellow"));
            }
        }
        /******добавим базилик ******/
        ocimums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ocimums.add(new Ocimum("Basilic", (int) (Math.random() * 100), Math.random() * 100));
        }

        /*******добавим перец ******/
        papricas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            papricas.add(new Paprica("Paprica", (int) (Math.random() * 100), Math.random() * 100));
        }
    }

    public void mixIngredient() {
        System.out.println("Mixing" + name);
    }

    public void makeSalat() {
        vegetables = new ArrayList<>();
        int size = tomatoes.size() + ocimums.size() + papricas.size();
        int counter = 0;
        while (counter < size) {
            if (counter >= tomatoes.size() ||
                    counter >= papricas.size() ||
                    counter >= ocimums.size()) {
                return;
            }
            vegetables.add(tomatoes.get(counter));
            vegetables.add(papricas.get(counter));
            vegetables.add(ocimums.get(counter));
            counter++;
        }
        System.out.println("Your " + name + " made");
    }

    public double countCalories() {
        double sum = 0;
        for (Vegetables vegetable : vegetables) {
            sum += vegetable.getCalories();
        }
        calories = sum;
        System.out.println(name + " has " + calories + " calories");
        return calories;
    }

    public void sortByCalories() {
        for (int i = 0; i < vegetables.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (vegetables.get(j - 1).getCalories() > vegetables.get(j).getCalories()) {
                    Vegetables temp = vegetables.get(j - 1);
                    vegetables.set(j - 1, vegetables.get(j));
                    vegetables.set(j, temp);
                }
            }
        }
    }

    public void getVegetablesFromRange(double min, double max) {

        regVegetables = new ArrayList<>();
        for (int i = 0; i < vegetables.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (vegetables.get(j - 1).getCalories() > vegetables.get(j).getCalories()) {
                    Vegetables temp = vegetables.get(j - 1);
                    vegetables.set(j - 1, vegetables.get(j));
                    vegetables.set(j, temp);
                }
            }
        }

        int leftMarker = 0;
        int rightMarker = 0;

        for (int i = 0; i < vegetables.size(); i++) {
            if (vegetables.get(i).getCalories() >= max) {
                rightMarker = i;
                break;
            } else if (vegetables.get(i).getCalories() <= min) {
                leftMarker = i;
            }
        }

        for (int i = 0; i < vegetables.size(); i++) {
            if (i > leftMarker && i < rightMarker) {
                regVegetables.add(vegetables.get(i));
            }
        }
        System.out.println(regVegetables);
    }

    @Override
    public String toString() {
        return "GreekSalat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", vegetables=" + vegetables +
                ", regVegetables=" + regVegetables +
                '}';
    }
}
