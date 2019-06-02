package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.omg.CORBA.portable.ValueBase;

public class Examples {

    public static void main(String[] args) {
       // System.out.println(System.currentTimeMillis());
       Examples example = new Examples();
       example.printNums();
       example.printnumformat1();
       System.out.println();
       example.printnumformat();
       example.printMultiplicationTable();
       //example.printOdd();
       //example.reverseString("happy");
       //System.out.println(example.reverseString("hello"));
       //System.out.println(example.reverseStr("hello"));
       //boolean flag = false;
       //example.printValue();
       //example.convertToDecimal("1000");
       //example.binearySearch(65);
       //example.sortStrings();
       //example.sumNumbers();
       //example.rSumNumbers(10);
       //example.triangle(4);
       //System.out.println(example.factorial(6));
       //example.countWord("Yahoo World you testing");
       //System.out.println(example.reverseString("hello"));
       //IntStream.range(1, 11).forEach(System.out::println);
       //IntStream.range(1, 11).filter(value -> value % 2 == 0).forEach(System.out::println);
       //IntStream.range(1, 11).filter(value -> value % 2 != 0).forEach(System.out::println);
       //IntStream.range(1, 11).filter(value -> value % 2 != 0).forEach(System.out::println);
       //System.out.println(IntStream.range(1, 90).anyMatch(value -> value == 18));
       //example.stringStream();
       //System.out.println(IntStream.range(1, 4).count());
       //example.stringStream();
       //IntStream.range(1, 11).forEach(number -> System.out.println(number));
       //IntStream.range(1, 11).filter(value -> value * 2 == 0).forEach(System.out::println);
      /* for (int i = 0; i < 10; i++) {
           System.out.println(example.fibonacci(i));
       }*/
       //IntStream.range(1, 11).forEach(System.out::println);
       //IntStream.range(1, 25).filter(value -> value % 2 == 0).forEach(System.out::println);
       //IntStream.range(1, 25).filter(value -> value % 2 == 0).forEach(System.out::println);
       
       System.out.println(findNthSumNumber(2, 10));
       filterElements("de").forEach(System.out::println);
       int[] numbers = {5, 1, 1, 5};
       System.out.println("Sum " + maxSumSubSeqNonContagious(numbers));
       System.out.println("Stairs " + stairs(4));
    }
    
    public static int stairs(int n) {
        if(n <= 0) return 1;
        System.out.println(n);
        return stairs(n - 1) + stairs(n - 2);
    }
    
    public static int maxSumSubSeqNonContagious(int a[]){
        int max_include[] = new int[a.length];
        int max_exclude[] = new int[a.length];
        max_include[0] = a[0];
        max_exclude[0] = Integer.MIN_VALUE;
        int max = a[0];
        
        for(int i = 1; i<a.length; i++){
            max_include[i] = Math.max(max_exclude[i-1]+a[i], a[i]);
            max_exclude[i] = Math.max(max_include[i-1], max_exclude[i-1]);
            max = Math.max(max_include[i], max_exclude[i]);
        }
        
        return max;
    }
    
    //For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
    public static int sumAdjacentNumbers(int[] numbers) {
        int sumValues = 0;
        int counter = 1;
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            counter++;
            for (int j = i; j < numbers.length; j = j + counter) {
                sum += numbers[j];
            }
            if (sum > sumValues) {
                sumValues = sum;
            }
        }
        return sumValues;
    }
    
    public static List<String> filterElements(String queryString){
        List<String> elements = Arrays.asList("dog", "deer", "deal", "dear", "detriot");
        return elements.stream()
                .filter(element -> element.startsWith(queryString))
                .limit(3)
                .collect(Collectors.toList());
    }
    
    //findNthSumNumber(2, 10)
    public static int findNthSumNumber(int n, int sum) {
        boolean flag = true;
        int start = 0;
        int count = 0;
        while (flag) {
            int sumofDigits = sumDigits(++start);
            if (sumofDigits == sum && n == ++count) {
                flag = false;
            }
        }
        return start;
    }

    public static int sumDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 10) + sumDigits(number / 10);
    }
    
    public int fibonacci(int n) {
        /*List<Integer> numbers = new ArrayList<>();
        int n1 = 0;
        int n2 = 1;
        numbers.add(n1);
        numbers.add(n2);
        for(int i = 0; i <= n; i++){
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            numbers.add(sum);
        }
        numbers.stream().forEach(System.out::println);*/
       if (n <= 1) {
            return n;
        }
        
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public void printValue(){
        List<Integer> values = Arrays.asList(10,18,90);
        values.forEach(System.out::println);
        System.out.println("Old Loop...");
        for(int value : values){
            System.out.println(value);
        }
    }
    
    public void convertToDecimal(String binayString){
        int result = 0;
        int conversion = 1;
        for(int length = binayString.length() - 1; length >= 0; length--){
            if(binayString.charAt(length) == '1'){
                result += conversion;
            }
            conversion = conversion * 2;
        }
        System.out.println(result);
    }
    
    public void binearySearch(int searchNumber) {
        List<Integer> numbers = Arrays.asList(12, 23, 34, 56, 65, 76, 87, 88, 89, 90, 91, 92, 93, 94, 95, 101, 123,
                899);
        int low = 0;
        int high = numbers.size();
        int median = (low + high) / 2;
        Integer num = numbers.get(median);

        while (low <= high) {
            median = low + high / 2;
            num = numbers.get(median);
            System.out.println("Iterate : " + low + high);
            if (searchNumber < num) {
                high = median - 1;
            } else if (searchNumber > num) {
                low = median + 1;
            } else if (searchNumber == num) {
                break;
            }
        }

        System.out.println("Found at index : " + median);
    }
    
    public void sortStrings() {
        List<String> names = Arrays.asList("Akshara", "Kulla", "Awesome!!");
        System.out.println(names);
        //Collections.sort(names);
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println(names);

        Collections.sort(names, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(names);
        Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
        System.out.println(names);
    }
    
    public void sumNumbers(){
        int num = 10;
        int sum = 0;
        for(int i = 0; i <= num; i++){
            sum += i;
        }
    }
    
    public int rSumNumbers(int num){
       if(num == 1){
           return 1;
       }
       int sum = num + rSumNumbers(num - 1);
       return sum;
    }
    
    public int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    
    public void countWord(String value){
        HashMap<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i <= value.length() - 1; i++){
            Character alphabet = Character.toLowerCase(value.charAt(i));
            if(counts.get(alphabet) == null){
                counts.put(alphabet, 1);
                continue;
            }
            int count = counts.get(alphabet);
            counts.put(alphabet, ++count);
        }
        System.out.println(counts);
    }
    
    public String reverseString(String s){
        System.out.println(s);
        if (s.length() == 0)
             return s;

        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    public String reverseStr(String s){
        StringBuilder builder = new StringBuilder();
        for(int c = s.length() - 1; c >= 0; c--){
            builder.append(s.charAt(c));
        }
        return builder.toString();    
    }
    
    public void printOdd(){
        //for(int i = 1; i <= 100; i = i + 2){
        for(int i = 2; i <= 100; i = i + 2){
            System.out.println(i);
        }
    }
    
    public void printNums(){
        int a = 1, b = 10, c = 11, d = 20;
        for(int i = 1; i <= 10; i++){
            System.out.println(String.format("%2d", a++) 
                    + "  " + String.format("%2d", b--) 
                    + "  "  + String.format("%2d", c++)  
                    + "  " + String.format("%2d", d--) 
                    );
        }
    }
    
    public void printnumformat1() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for(int k = 10; k > i; k--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    public void printnumformat() {
        for (int i = 10; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for(int k = 10; k > i; k--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    public void printMultiplicationTable(){
        for(int i = 1; i <=10; i++){
            for(int j = 1; j <=10; j++){
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
    
    public void stringStream() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("The");
        list.add("");
        //list.stream().filter(element -> element.toLowerCase().startsWith("d")).forEach(System.out::println);
        //list.stream().filter(element -> element.toLowerCase().startsWith("t") && element.length() > 4).forEach(System.out::println);
        //Stream<String> stream = list.stream().filter(element -> element.toLowerCase().startsWith("t"));
        list.stream().map(element -> element.toUpperCase()).forEach(System.out::println);
    }
    
    
}