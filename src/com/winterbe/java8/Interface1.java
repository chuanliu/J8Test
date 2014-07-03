package com.winterbe.java8;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);
//        double calculate1(int a);

        default public double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

//        formula1.calculate(100);     // 100.0
//        formula1.sqrt(-23);          // 0.0
//        Formula.positive(-4);        // 0.0
        
        System.out.println(formula1.calculate(100));
        System.out.println(formula1.sqrt(-23));
        System.out.println(Formula.positive(-4));

//        Formula formula2 = (a) -> sqrt( a * 100); //????????????????????
        
        Formula formula = (p)-> Formula.positive(p*100);
    }

}