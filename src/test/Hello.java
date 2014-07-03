package test;

import java.util.ArrayList;
import java.util.function.Consumer;

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
   new ArrayList<Integer>().forEach(new Consumer<Integer>() {

	@Override
	public void accept(Integer arg0) {
		
	}
});

   new Hello().r2.run();
   new Thread(() -> System.out.println("这是一个java8的小例子,可以使用lambda表达式")).start();
 }
}
