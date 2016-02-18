package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
       /* if(isPrimeLambda(13))
            System.out.println("Simple");
        else System.out.println("Not Simple");*/


        List evenNumber = Arrays.asList(1,2,5,4,6,5,4,3,8);
  /*      if(isEven(evenNumber))
            System.out.println("Even");
        else System.out.println("Not Even");
    */

        System.out.println(isEvenLambda(evenNumber));
        //System.out.println(isEvenLambda(Arrays.asList(1,2,5,4,6,5,4,3,8)));
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <number/2; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeLambda(int number) {
        return IntStream.range(2,number/2).noneMatch(i -> number % i == 0);
    }

 /*   public static boolean isEven(List <Integer> number) {
        for (int i = 0; i < number.size(); i++){
            if (number[i] % 2 == 0 && number[i] > 3){
                return true;
            }
        }
        return false;
    }
*/
    public static int isEvenLambda( List <Integer> ints){
        IntStream.of(1,2,5,4,6,5,4,3,8)
        //        .filter(i -> getBooleanPredicate(i))
                .filter(Main::getBooleanPredicate)
                .map(getDoubleIntOperator())
                .findFirst().getAsInt();

        return ints.stream()
                .filter(getIntegerPredicate())
                .findFirst()
               // .map(getDoubledIntegerFunction())
                .map(Main::getDoubleIntOperator)
                .get();
    }

    private static Function<Integer, Integer> getDoubledIntegerFunction() {
        return i -> i * 2;
    }

    private static IntUnaryOperator getDoubleIntOperator() {
        return i -> i * 2;
    }

    private static int getDoubleIntOperator(int i) {
        System.out.println("\nDoubled -> " + i);
        return i * 2;
    }

    private static IntPredicate getIntPredicate() {
        return i -> i % 2 == 0 &&  i > 3;
    }

    private static Predicate<Integer> getIntegerPredicate() {
        return i -> i % 2 == 0 &&  i > 3;
    }

    public static boolean getBooleanPredicate(int i){
        System.out.println("\nIs greater then 3 and even ->" + i);
        return i % 2 == 0 &&  i > 3;
    }

}
