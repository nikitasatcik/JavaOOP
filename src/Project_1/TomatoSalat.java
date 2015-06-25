package Project_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TomatoSalat extends Salat {
    private String name;
    private int weight;
    private double calories;
    private static String stringArray = "";
    private static ArrayList<Double> dataFromFile;
    private List<Vegetables> vegetables;
    private List<Tomato> tomatoes;
    private List<Ocimum> ocimums;
    private List<ChiliPepper> peppers;
    private List<Vegetables> vegetablRegion;

    public TomatoSalat(String name) {
        this.name = name;
    }

    public void sliceVegetables() {
        System.out.println("Slicing Vegetables for " + name);
    }

    public void fillWithVegetables() {
        System.out.println("Add some vegetables");
        getDataFromFile();

        /******добавим помидорчики ******/
        tomatoes = new ArrayList<>();
        for (int i = 0; i < dataFromFile.size()/10; i++) {
            if (i % 2 == 0) {
                tomatoes.add(new Tomato("redTomato", (int) (Math.random() + dataFromFile.get(i)), dataFromFile.get(i), "red"));
            } else {
                tomatoes.add(new Tomato("yellowTomato", (int) (Math.random() + dataFromFile.get(i)), dataFromFile.get(i), "yellow"));
            }
        }
        /******добавим базилик ******/
        ocimums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ocimums.add(new Ocimum("Basilic", (int) (Math.random() * 100), Math.random() * 100));
        }

        /*******добавим перец ******/
        peppers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peppers.add(new ChiliPepper("ChiliPepper", 10, Math.random() * 100, 10));
        }
    }

    public void mixIngredient() {
        System.out.println("Mixing" + name);
    }

    public void makeSalat() {
        vegetables = new ArrayList<>();
        int size = tomatoes.size() + ocimums.size() + peppers.size();
        int counter = 0;
        while (counter < size) {
            if (counter >= tomatoes.size() ||
                    counter >= peppers.size() ||
                    counter >= ocimums.size()) {
                return;
            }

            vegetables.add(tomatoes.get(counter));
            vegetables.add(peppers.get(counter));
            vegetables.add(ocimums.get(counter));
            counter++;
        }
        System.out.println("Your " + name + " had made");
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

        vegetablRegion = new ArrayList<>();
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
                vegetablRegion.add(vegetables.get(i));
            }
        }
        System.out.println(vegetablRegion);
    }

    public void getDataFromFile() {
        dataFromFile = new ArrayList<>();
        try {
            FileReader readFile = new FileReader("D:\\Dropbox\\Java\\src\\Project_1\\Array.txt");
            Scanner scanFile = new Scanner(readFile);
            while (scanFile.hasNextLine()) {
                stringArray += scanFile.nextLine() + " ";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] strings = stringArray.trim().split("\\s+");
        for (String nextString : strings) {
            String s = nextString;
            s = s.replace(",", ".");
            double d = Double.parseDouble(s);
            dataFromFile.add(d);
        }
    }

    @Override
    public String toString() {
        return "TomatoSalat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", vegetables=" + vegetables +
                ", vegetablRegion=" + vegetablRegion +
                '}';
    }
}
