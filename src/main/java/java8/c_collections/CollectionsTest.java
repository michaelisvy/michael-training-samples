package java8.c_collections;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    private String firstName;

    public Person(String firstName) {
        this.firstName = firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}

public class CollectionsTest {

    @Test
    public void shouldPopulateACollectionWithLambdasDoubleLoop() {
        List<Person> list = asList(new Person("Joe"), new Person("Sam"), new Person("John") );

        Predicate<Person> startWithJPredicate = p -> p.getFirstName().startsWith("J");
        Stream<Person> stream = list.stream().filter(startWithJPredicate);

        // convert stream back to collection (this is optional, should only be used if list needs to be returned)
        List<Person> filteredList =  stream.collect(Collectors.toList());

        filteredList.forEach(p -> assertThat(p.getFirstName()).startsWith("J"));
    }

    @Test
    public void shouldUseMapEntry() {
        Map<String,String> customersMap= new HashMap<>();
        customersMap.put("001", "John");
        customersMap.put("002", "Sam");
        customersMap.put("003", "Peter");

        Map.Entry entry = customersMap.entrySet().iterator().next();
        assertThat(entry.getKey()).isEqualTo("001");
        assertThat(entry.getValue()).isEqualTo("John");
    }
}
