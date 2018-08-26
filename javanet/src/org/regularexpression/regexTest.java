package org.regularexpression;

import java.util.stream.Stream;

/**
 * Created by LICHENG on 2018/5/23.
 */
public class regexTest {

    public static void main(String args[]) {
        String qq1 = "1832137835";
        String qq2 = "789j9371";
        String qq3 = "22";
        String qq4 = "012189783";

        String regex = "[1-9][0-9]{4,9}";
        boolean b = qq1.matches(regex);

        System.out.println(b);
        Stream.Builder builder = Stream.builder();
        Stream stream = builder.build();


    }


//    public int StrToInt(String str) {
//        int n = str.length();
//        int s = 1;
//        long res = 0;
//        if (!n) {
//            return 0;
//        }
//        if (str[0] == '-') s = -1;
//        for (int i = (str[0] == '-' || str[0] == '+') ? 1 : 0;
//             i < n;
//             ++i) {
//            if (!('0' <= str[i] && str[i] <= '9')) return 0;
//            res = (res << 1) + (res << 3) + (str[i] & 0xf);//res=res*10+str[i]-'0';
//        }
//        return res * s;
//    }
}
