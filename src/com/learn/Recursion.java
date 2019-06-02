package com.learn;

import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println("factorial " + factorial);
        
        int[] nums = {1, 2, 3, 4, 14};
        int sumValue = sumArray(nums);
        System.out.println("sumArray " + sumValue);
        
        boolean isEven = isEven(123);
        System.out.println("isEven " + isEven);
        
        int subBelow = sumBelow(7);
        System.out.println("subBelow " +  subBelow);
        
        int exponent = exponent(4, 3);
        System.out.println("Exponent of " +  exponent);
        
        String rev = reverseString("string");
        System.out.println("ReverseString " +  rev);
        
        //System.out.println(275 % 3);
        //int remainder = modulo(-275, -502);
        //System.out.println("Modulo of " +  remainder);
        
        int multiply = multiply(10, 2);
        System.out.println("Multiply of " +  multiply);
        
        int[] elements = {1, 2, 3, 4, 14, 18, 22, 25};
        boolean isFound = bSearch(elements, 1); 
        System.out.println("bSearch " +  isFound);
        
        isFound = binarySearch(elements, 134, 0, elements.length - 1);
        System.out.println(" Rec binarySearch " +  isFound);
        
        System.out.println(sumDigits(4134));
        System.out.println(sumofNumbers(4134));
        
    }
    
    public static int sumDigits(int number){
        if (number == 0){
            return 0;
        }
        return (number % 10) + sumDigits(number / 10);
    }
    
    public static int sumofNumbers(int number){
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
    
    public static int factorial(int number){
        if (number == 1){
            return number;
        }
        return number * factorial(number - 1);
    }
    
    public static int sumArray(int[] numbers){
        if(numbers.length == 1){
            return numbers[0];
        }
        //int[] newNum = ArrayUtils.remove(numbers, 0);
        int[] newArray = new int[numbers.length - 1];
        for (int i = 1; i <= numbers.length - 1; i++) {
            newArray[i - 1] = numbers[i];
        }
        return numbers[0] + sumArray(newArray);
    }
    
    private static boolean isEven(int number){
            if (number == 2) {
                return true;
            } else if(number == 1){
                return false;
            } else {
                return isEven(number - 2);
            }
    }
    
    private static int sumBelow(int number){
        if (number == 0){
            return number;
        }
        return (number - 1) + sumBelow(number - 1);
    }
    
    /*private static int[] rangeNumbers(int start, int end){
        
    }*/
    
    private static int exponent(int number, int power){
        if (power == 0){
            return 1;
        }
        return number * exponent(number, power - 1);
    }
    
    public static String reverseString(String value){
        if(value.length() == 1){
            return value;
        }
        return value.charAt(value.length() - 1) + reverseString(value.substring(0, value.length() - 1));
    }
    
    public static int modulo(int number, int divBy){
        if (number < divBy) {
            return number;
        }
        return modulo(number - divBy, divBy);
    }
    
    public static int multiply(int num1, int num2){
        if(num2 == 0){
            return 0;
        }
        return num1 + multiply(num1, num2 - 1);
    }
    
    public static boolean binarySearch(int[] elements, int target, int low, int high){
        int mid = (low + high) / 2;
        
        if(high < low){
            return false;
        }
        
        if(target == elements[mid]){
            return true;
        } else if (target > elements[mid]){
           return binarySearch(elements, target, mid + 1, high);
        } else if (target < elements[mid]){
           return binarySearch(elements, target, low, mid - 1);
        }
        return false;
    }
    
    public static boolean bSearch(int[] elements, int target){
        int low = 0;
        int high = elements.length - 1;
        boolean flag = false;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if (target == elements[mid]){
                flag = true;
                break;
            } else if(target > mid){
                low = mid + 1;
            } else {
               high =  mid - 1;
            }
        }
        return flag;
    }

}
