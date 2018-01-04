import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by licheng on 1/4/18.
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("localhost");
        boolean r = ip.isReachable(5000);
        System.out.println(r);
    }
}
