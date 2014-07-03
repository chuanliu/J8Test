/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author Jack
 *
 * (参数) -> 表达式
 *
 * (参数) -> 语句
 *
 * (参数) -> { 语句 }
 *
 */
public class J8Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//		numbers.forEach(( x) -> System.out.println(x));
        numbers.forEach((x) -> System.out.println(x));

        List<Shape> shapes = new ArrayList();
        shapes.add(new Shape("bule", 3));
        shapes.add(new Shape("black", 5));
        shapes.add(new Shape("red", 2));
        shapes.add(new Shape("red", 2));
        shapes.forEach((x) -> System.out.println(x.getColor()));
        shapes.forEach(x -> {
            System.out.println(x.toString());
        });
        shapes.forEach(s -> {
            if (s.getColor() == "red") {
                System.out.println(s.getColor());
            }
        });

        int sum = numbers.stream().mapToInt(e -> e).sum();
        System.out.println(sum);

        int sum2 = numbers.stream().mapToInt(e -> e).reduce(0, (x, y) -> x + y);
        System.out.println(sum2);

        int sumSize = shapes.stream().distinct().filter(s -> s.getSize() > 0).mapToInt(s -> s.getSize()).sum();
//      反回一个List
        List<Shape> shapes2 = shapes.stream().distinct().filter(s -> s.getSize() >= 2).collect(Collectors.toList());
        
//      shapes2.sort(Comparator.comparing(Shape::getSize)); //??????????????????????????
//        shapes2.sort(comparing(Shape::getSize)); //??????????????????????????

        System.out.println(sumSize);
        shapes2.forEach(s -> System.out.println(s.getSize()));

        Comparator<Integer> c2 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> c1 = Integer::compare;
//      反回一个groupingby return map
        Map<Integer, List<Shape>> map = shapes.stream().filter(s -> s.getSize() > 0).collect(Collectors.groupingBy(Shape::getSize));
        System.out.println(map.get(2).get(0).getColor());
        System.out.println(map);

//        int  count = 0;
//        List<String> strings = Arrays.asList("a", "b", "c");
//        strings.forEach(s -> {
//            count++; // error: can't modify the value of count
//        });
        
        
        

    }
//    
//    
//    
//    
//   public void appendAll (Iterable<String> values, Appendable out)
//        throws IOException { // doesn't help with the error
//            values.forEach(s -> {
//                out.append(s); // error: can't throw IOException here
//                // Consumer.accept(T) doesn't allow it
//            });
//        }

    
    
    
    
}
