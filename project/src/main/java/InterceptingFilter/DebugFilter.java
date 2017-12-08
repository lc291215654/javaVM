package InterceptingFilter;

/**
 * Created by licheng on 12/8/17.
 */
public class DebugFilter implements Filter {
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}