package Project_1;

public class ChiliPepper implements Vegetables {
    private  String name;
    private int weight;
    private double calories;
    private int chilness;

    public ChiliPepper(String name, int weight, double calories, int chilness) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.chilness = chilness;
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
        return "\nChiliPepper{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", chilness=" + chilness +
                '}';
    }
}
