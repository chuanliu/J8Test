package Lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.winterbe.java8.Person;

/**
 * Common standard functions from the Java API.
 *
 * @author Benjamin Winterberg
 */
public class Lambda3 {

	@FunctionalInterface
	interface Fun {
		void foo();
	}

	public static void main(String[] args) throws Exception {

		// Predicates

		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo"); // true
		predicate.negate().test("foo"); // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		Predicate<Person> dd = p -> p.getFirstName().length() > 0;
		Predicate<Person> isStudent = Person::isStudent;
		System.out.println(dd.test(new Person("Jack", "Liu")));
		System.out.println(isEmpty.test("dd"));

		// Functions

		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, Integer> toInteger2 = p -> Integer.valueOf(p);

		Function<String, String> backToString = toInteger
				.andThen(String::valueOf);

		backToString.apply("123"); // "123"

		// Suppliers

		Supplier<Person> personSupplier = Person::new;
		Supplier<Person> personSupplier2 = () -> new Person();
		Supplier<Person> personSupplier3 = Person::getPerson;
		Supplier<Person> personSupplier4 = () -> Person.getPerson();
		personSupplier.get(); // new Person

		// Consumers
		Consumer<Person> greeter = (p) -> System.out.println("Hello, "
				+ p.getFirstName());
		Consumer<Person> greeter2 = (p) -> System.out
				.println("we will geting start");
		greeter.accept(new Person("Luke", "Skywalker"));

		greeter.andThen(greeter2).accept(new Person("Jack", "Liu"));

		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName()
				.compareTo(p2.getFirstName());

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2); // > 0
		comparator.reversed().compare(p1, p2); // < 0
		// Comparator
		// Runnables

		Runnable runnable = () -> System.out.println(UUID.randomUUID());
		runnable.run();

		// Callables

		Callable<UUID> callable = UUID::randomUUID;
		callable.call();
		
		Callable<Person> callable2 = Person::getPerson;
		Person pp = callable2.call();
		System.out.print(pp);
	}

}
