package builder;

/**
 * Created by licheng on 12/8/17.
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    public String name() {
        return "Coke";
    }
}