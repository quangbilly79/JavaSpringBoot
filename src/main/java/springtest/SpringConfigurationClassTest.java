package springtest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

class Person {

    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Address {
    String street;
    int num;

    public Address(String street, int num) {
        this.street = street;
        this.num = num;
    }
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

@Configuration
public class SpringConfigurationClassTest {

    // @Bean đc sử dụng trong @Configuration class. Chỉ sử dụng đc vs method
    // Kết quả trả về của method tg ứng sẽ đc quản lý bởi Spring context
    @Bean
    public String name1() {
        return "person_name1";
    }

    @Bean
    public int age1() {return 3;}

    // Có thể truyền tham số, là các bean tg ứng đã tạo. Vd name -> bean name1 -> person_name1
    // Vì 1 class (vd String) chỉ tạo đc 1 bean tg ứng, nên k sợ lẫn
    @Bean
    public Person getPerson(String name, int age, @Qualifier("getAddressQualifier") Address address) {
        return new Person(name, age, address);
    }

    // Trong TH muốn dùng 1 Bean nào đó bị trùng class,
    // trong method getBean
    // Thêm @Primary
    @Bean(name = "addressBean")
    @Primary
    public Address getAddress() {
        return new Address("street1", 1);
    }

    // Trong TH muốn dùng 1 Bean nào đó bị trùng class,
    // làm tham số trong 1 Bean method khác
    // Thêm @Qualifier("beanName")
    @Bean
    @Qualifier("getAddressQualifier")
    public Address getAddressQualifier() {
        return new Address("streetQualifier", 2);
    }







}
