import redis.clients.jedis.Jedis;

/**
 * Created by licheng on 12/12/17.
 */
public class RedisFirst {



    public static void main(String args[]){
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo","bar");
        String value = jedis.get("foo");
        System.out.println(value);

        jedis.lpush("quene1","aafafd");
        jedis.lpush("quene1","bbfabf");
        jedis.lpush("quene1","bfabad");
        jedis.lpush("quene1","babafh");


        for(int i=0 ;i<jedis.llen("quene1");i++){
            System.out.println(jedis.lpop("quene1"));
        }



    }


}
