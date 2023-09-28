package hacker_rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
@FunctionalInterface
interface Lambda {
    String display(String name);
}

public class Test {
    public static void main(String[] args) {

        String yourName = "Khánh";
//        Lambda lambda = new Lambda() {
//            @Override
//            public String display(String name) {
//                return "Hello " + name;
//            }
//        };
//
        Lambda lambda = name -> "Hello " + name;
        System.out.println(lambda.display(yourName));
    }
}
