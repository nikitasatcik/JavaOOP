package Project_1;

public class Tomato implements Vegetables {
    private String name;
    private int weight;
    private double calories;
    private String color;

    public Tomato(String name, int weight, double calories,String color) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.color = color;
    }

    @Override
    public int getWeight(){
        return weight;
    }

    @Override
    public double getCalories(){
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "\nTomato{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", color='" + color + '\'' +
                '}';
    }
}