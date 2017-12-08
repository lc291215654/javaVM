package builder;

/**
 * Created by licheng on 12/8/17.
 */
public abstract class ColdDrink implements Item {

    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}