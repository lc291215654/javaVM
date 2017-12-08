package InterceptingFilter;

/**
 * Created by licheng on 12/8/17.
 */
public class AuthenticationFilter implements Filter {
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}