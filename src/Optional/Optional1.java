package Optional;

import java.util.Optional;
import java.util.function.Consumer;

import com.winterbe.java8.Person;

/**
 * @author Benjamin Winterberg
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

//        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
//        greeter.accept(new Person("Luke", "Skywalker"));
        optional.isPresent();           // true
        optional.ifPresent(p->System.out.println("Hello " + p.toUpperCase()));
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"
        optional= optional.filter(p->p.startsWith("b"));

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
        
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("dddd"));
    }

}