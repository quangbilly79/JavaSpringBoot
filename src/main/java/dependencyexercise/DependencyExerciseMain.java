package dependencyexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Tạo interface cho các dep
interface DataService {
    int[] retrieveData();
}

// Tạo các Dependency, thêm @Component để Spring quản lý
@Component
class MongodbDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{1,2,3,4,5};
    }
}
// Xét class Mysql làm Primary
@Component
@Primary
class MysqlDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{2,3,7,8,9};
    }
}
// Business Class phụ thuộc vào 2 Dep bên trên (Dataservice Interface)
@Component
class BusinnessClass {
    DataService dataService;
    // Constructor, @Autowired vs Dep tg ứng
    @Autowired
    public BusinnessClass(DataService dataService) {
        this.dataService = dataService;
    }
    // Method tìm max trong 1 trong 2 Array, mysql hoặc mongo (tùy vào @Primary)
    public int findmax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

// lấy Class chứa main làm config class luôn
// Scan component (vì ở trong cg 1 file nên k cần đg dẫn package)
@Configuration
@ComponentScan
public class DependencyExerciseMain {
    public static void main(String[] args) {
        // Tạo context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyExerciseMain.class);
        // Get instance class tg ứng vs getBean
        BusinnessClass businnessClass = context.getBean(BusinnessClass.class);
        System.out.println(businnessClass.findmax()); // 9 or 5 tùy vào @Primary
    }
}
