package org.javaregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        Pattern p = Pattern.compile("\\d+[G]");
        Matcher m = p.matcher("sda   4  f 100G ff");
        System.out.println(m.groupCount());
        System.out.println(m.find());
        System.out.println(m.group());
    }
}
