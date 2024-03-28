package springJPAtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// Chạy query với Spring JPA
@Component
public class SpringJPACommandLineRunner implements CommandLineRunner {
    // Khởi tạo 1 instance từ SpringJPARepository Interface. Vì là field nên cần @Autowired
    @Autowired
    private SpringJPARepository repository;

    // Override method run,
    // Chaỵ các query trực tiếp trong này với repository
    // chứ k phải chạy thông qua Entity giống JPA chay
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner run------------");
        // save: insert/update nếu trùng id
        repository.save(new Course(1, "JPA_1", "z"));
        repository.save(new Course(1, "JPA_1_update", "y"));
        repository.save(new Course(2, "JPA_2", "g"));
        repository.save(new Course(3, "JPA_1", "a"));
        repository.save(new Course(4, "JPA_2", "a"));
        repository.save(new Course(5, "JPA_2", "a"));

        // Xóa theo id
        repository.deleteById(1);

        // Select theo id
        System.out.println(repository.findById(2)); // Optional[Course{id=2, name='JPA_2', author='g'}]
        System.out.println(repository.findById(3)); // Optional[Course{id=3, name='JPA_1', author='a'}]

        // Chạy custom query vs hàm custom tg ứng trong repository
        // Trả về List<Object[]>, convert thành kdl tg ứng tùy TH
        List<Object[]> resultList = repository.findDuplicateCourses();
        for (Object[] result : resultList) {
            String name = (String) result[0];
            Long count = (Long) result[1];
            System.out.println(String.format("Name: %s, Count: %d", name, count));
            // Name: JPA_2, Count: 3
        }


    }
}
