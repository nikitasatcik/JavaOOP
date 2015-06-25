package Project_1;

public class Paprica implements Vegetables {

    private  String name;
    private int weight;
    private double calories;

    public Paprica(String name, int weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    @Override
    public int getWeight(){
        return weight;
    }

    @Override
    public double getCalories(){
        return calories;
    }

    @Override
    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "\nPaprica{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                '}';
    }
}
