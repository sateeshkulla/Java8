package com.learn.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] productsN = productNumber(nums);
        System.out.println(Arrays.toString(productsN));
       //boolean foundNumber = isNumberSubset_v3(9);
       //System.out.println(foundNumber);
       /* LinkList list = new LinkList();
        list.addElement(18);
        list.addElement(02);
        list.addElement(11);
        list.addElement(19);
        list.addElement(01);
        list.addElement(108);
        System.out.println(list.size);
        list.deleteElement(19);
        System.out.println(list.size);
        list.addElementFirst(2011);
        System.out.println(list.size);
        
        LinkList listnew = new LinkList();
        System.out.println(listnew.size);
        list.deleteElement(19);
        System.out.println(listnew.size);*/
    }
    
    public static boolean isNumberSubset(int k) {
        int[] numbers = { 10, 5, 3, 7 };
       for(int i = 0; i < numbers.length; i++){
           for(int j = 0; j < numbers.length; j++){
               if(k == numbers[i] + numbers[j]){
                   return true;
               }
           }
       }
        return false;
    }
    
    public static boolean isNumberSubset_v2(int k) {
        int[] numbers = { 10, 5, 3, 7, -14, -2 };
        Map<Integer, Integer> subSets = new HashMap<>();
        for (int number : numbers) {
            number =  number < 0 ? -(number) : number;
            if (subSets.containsKey(k - number)) {
                return true;
            }
            subSets.put(number, number);
        }

        return false;
    }
    
    public static boolean isNumberSubset_v3(int k) {
        int[] numbers = { 10, 5, 3, 7, -14, -2 };
        Map<Integer, Integer> subSets = new HashMap<>();
        for (int number : numbers) {
            for (int number2 : numbers) {
                if (subSets.containsKey(k - Math.abs(number + number2))) {
                    return true;
                }
                subSets.put(Math.abs(number + number2), Math.abs(number + number2));
            }
        }

        return false;
    }
    
    public static int[] productNumbers(int[] numbers) {
        int[] productNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int a = 1;
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                a *= numbers[j];
            }
            productNumbers[i] = a;
        }

        return productNumbers;
    }
    
    public static int[] productNumber(int[] numbers) {
        int[] productNumbers = new int[numbers.length];
        int product = 1;
        for (int i = 0; i < numbers.length; i++) {
            product *= numbers[i];
        }
        
        for (int i = 0; i < numbers.length; i++) {
            productNumbers[i] = product / numbers[i];
        }
        
        return productNumbers;
    }

}
