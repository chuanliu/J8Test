
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package j8test;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

/**
 *
 * @author Jack
 */
public class Hello {
  Runnable r1 = () -> { System.out.println(this); };
  Runnable r2 = () -> { System.out.println(toString()); };

  public String toString() { return "Hello, world!"; }

  public static void main(String ... args) {
    new Hello().r1.run();
    new Hello().r2.run();
  }
  
  public static <T, U> Comparator<T> comparing(  Function<? super T, ? extends U> keyExtractor,
                                                 Comparator<? super U> keyComparator)
    {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (Comparator<T> & Serializable)
            (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                                              keyExtractor.apply(c2));
    }
  
}
