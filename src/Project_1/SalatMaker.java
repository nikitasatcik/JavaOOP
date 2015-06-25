package Project_1;

public abstract class SalatMaker {
    abstract Salat createSalat(String item);

    public Salat makeSalat(String type) {
        Salat salat = createSalat(type);
        salat.fillWithVegetables();
        salat.sliceVegetables();
        salat.mixIngredient();
        salat.makeSalat();
        return salat;
    }
}

