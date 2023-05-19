package com.pavel;

import java.util.ArrayList;
import java.util.List;

public class SonarQubeDemo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i <= numbers.size(); i++) {
            System.out.println("Number: " + numbers.get(i));
        }

    }
}




