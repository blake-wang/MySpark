package base.集合框架;

import java.util.ArrayList;

public class Demo13_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>() {{
            add(8);
            add(20);
        }};
        ar.add(9);


        System.out.println(ar.toString());
    }
}
