package InterceptingFilter;

/**
 * Created by licheng on 12/8/17.
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
