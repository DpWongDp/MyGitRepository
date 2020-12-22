package com.dp.vue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class VueApplicationTests {

    @Test
    void contextLoads() {
       Integer a = 10;
       Integer b = new Integer(10);
        Integer c = Integer.valueOf(10);

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }

    @Test
    void test01(){
        ArrayList<Integer> i1 = new ArrayList<>();
        ArrayList<Integer> i2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            i1.add(i);
        }

        for (int i = 9; i >= 0; i--) {
            i2.add(i);
        }

        System.out.println(i1);
        System.out.println(i2);

        System.out.println(i1 .equals(i2) );


    }

}
