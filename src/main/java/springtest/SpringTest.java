package springtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringTest {
    public static void main(String[] args) {
        // 1: Tạo 1 Spring context vs new AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigurationClassTest.class);


        // 2: Tạo 1 class configuration để Spring context quản lý (SpringConfigurationClass)

        // 3: Tạo các bean tg ứng (chỉ có thể là method) trong class Config để Spring quản lý
        // Lấy về kq trả về của các hàm bean vs context.getBean
        // trả về Object, có thể cast nếu cần
        //System.out.println(context.getBean("name2")); // [I@3c9d0b9d

        String returnBean = (String) context.getBean("name1");
        System.out.println(returnBean); // bean name

        //String returnBean1 = (String) context.getBean(String.class);
        //System.out.println(returnBean1); // bean name

        Person person1 = (Person) context.getBean("getPerson");
        System.out.println(person1);
        // Person{name='person_name1', age='3', address='Address{street='streetQualifier', num='2'}'}

        Address address = (Address) context.getBean(Address.class);
        System.out.println(address); // address{street='street1', num='1'}


        // Lấy ds các Bean (cả các bean buildin) vs getBeanDefinitionNames
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        // org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        //org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        //org.springframework.context.annotation.internalCommonAnnotationProcessor
        //org.springframework.context.event.internalEventListenerProcessor
        //org.springframework.context.event.internalEventListenerFactory
        //springConfigurationClass
        //name1
        //age1
        //getPerson
        //addressBean

    }

}
