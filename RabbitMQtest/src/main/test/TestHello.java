import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by licheng on 12/7/17.
 */
public class TestHello {
    @Test
    public void testHello(){
        Hello h = new Hello();
        assertEquals(h.hello(),"hello");
    }
}
