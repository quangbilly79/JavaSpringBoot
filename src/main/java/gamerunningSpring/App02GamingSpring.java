package gamerunningSpring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingSpring {
    public static void main(String[] args) {
        // 1: Tạo 1 Spring context vs new AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationClass.class);


        // 2: Tạo 1 class configuration để Spring context quản lý (SpringConfigurationClass)

        // 3: Tạo các bean tg ứng (chỉ có thể là method) trong class Config để Spring quản lý
        // Lấy về kq trả về của các hàm bean vs context.getBean
        // trả về Object, có thể cast nếu cần
        System.out.println(context.getBean("name2")); // [I@3c9d0b9d

        String returnBean = (String) context.getBean("name1");
        System.out.println(returnBean); // bean name

        Person person1 = (Person) context.getBean("getPerson");
        System.out.println(person1); // Person{name='abc', age='3'}



    }

}
