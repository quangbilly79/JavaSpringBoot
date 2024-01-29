package dependencyinjection;

import gamerunningspring.AppGamingBasicSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 3 class Dependencies (thêm @Component) để Spring quản lý
@Component
class Dependency1 {

}
@Component
class Dependency2 {

}
@Component
class Dependency3 {

}

// Class chính sử dụng 3 dependency class bên trên
@Component
class DependencyInjection {
    // 3 loại Dep Injection. Về cơ bản đều phải thêm @Autowired để tự động lấy dep Class bên trên
    // Loại 1: Dependency inject trong Field
    @Autowired
    Dependency1 dependency1;
    // Loại 2: Dependency inject vs Setter
    Dependency2 dependency2;
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }
    // Loại 3: Dependency inject vs Constructor. K cần @autowired (tự động)
    //@Autowired
    Dependency3 dependency3;
    public DependencyInjection(Dependency3 dependency3) {
        this.dependency3 = dependency3;
    }

    @Override
    public String toString() {
        return "dependency1 + " + dependency1 + " dependency2 + " + dependency2 + " dependency3 + " + dependency3;
    }
}
@Configuration
@ComponentScan("dependencyinjection")
public class DependencyInjectionMain {
    public static void main(String[] args) {
        // Tạo context từ class config (main)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DependencyInjectionMain.class);

        // Gọi đến component chính vs getBean
        DependencyInjection dependencyInjection = context.getBean(DependencyInjection.class);
        System.out.println(dependencyInjection);
        // dependency1 + dependencyinjection.Dependency1@3c419631 dependency2 + dependencyinjection.Dependency2@418e7838 dependency3 + dependencyinjection.Dependency3@61230f6a
        // => Tự động wired các dep tg ứng (nếu khai báo bthg sẽ bị null do bên trên chưa set value cho dep1, dep2, dep3)
    }
}
