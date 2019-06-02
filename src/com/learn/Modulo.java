package com.learn;

import org.junit.Assert;

public class Modulo {

    public static int modulo(int number, int divBy) {
        number = (number < 0) ? -number : number;
        divBy = (divBy < 0) ? -divBy : divBy;

        if (number < divBy) {
            return number;
        }
        return modulo(number - divBy, divBy);
    }

    public static void main(String[] args) {
        int count = 1;
        
        Assert.assertEquals(Modulo.modulo(2, 1), 2 % 1);
        System.out.println(count++);
        Assert.assertEquals(Modulo.modulo(17, 5), 17 % 5);
        System.out.println(count++);
        Assert.assertEquals(Modulo.modulo(78, 453), 78 % 453);
        System.out.println(count++);
        Assert.assertEquals(Modulo.modulo(0, 32), 0 % 32);
        System.out.println(count++);

        Assert.assertEquals(Modulo.modulo(-79, 82), -79 % 82);
        System.out.println(count++);
        
        //Assert.assertEquals(Modulo.modulo(-275, -502), -275 % -502);
        System.out.println(count++);
        Assert.assertEquals(Modulo.modulo(-275, -274), -275 % -274);
        System.out.println(count++);
        //Assert.assertEquals(Modulo.modulo(-4, 2), -4 % 2);
        System.out.println(count++);

       //Assert.assertEquals(Modulo.modulo(0, 0), Double.NaN);
    }

}
