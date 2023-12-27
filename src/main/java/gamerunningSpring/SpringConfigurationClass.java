package gamerunningSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

@Configuration
public class SpringConfigurationClass {
    int[] marks = {1,2,4,5,6};
    // @Bean đc sử dụng trong @Configuration class. Chỉ sử dụng đc vs method
    // Kết quả trả về của method tg ứng sẽ đc quản lý bởi Spring context
    @Bean
    public int[] name2() {
        return marks;
    }

    @Bean
    public String name1() {
        return "bean name";
    }

    @Bean
    public Person getPerson() {
        return new Person("abc", 3);
    }

}
