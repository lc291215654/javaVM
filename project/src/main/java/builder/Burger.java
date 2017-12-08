package builder;

/**
 * Created by licheng on 12/8/17.
 */
public abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}