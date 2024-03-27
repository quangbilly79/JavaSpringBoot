package JPATest;

import JPATest.Course;
import JPATest.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Chạy query với JPA, các hàm định nghĩa trong JPARepository
// Cần implement 1 method run thôi
@Component
public class JPACommandLineRunner implements CommandLineRunner {
    // Khởi tạo 1 repo từ JPARepository Class. Vì là field nên cần @Autowired
    @Autowired
    JPARepository repository;

    // Override method run, chạy method tg ứng trong JPARepository
    // với tham số truyền vào tg ứng
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner run------------");
        repository.insert(new JPATest.Course(1, "JPA", "y"));
        repository.insert(new JPATest.Course(2, "JPA", "g"));
        repository.insert(new JPATest.Course(3, "JPA", "a"));

        repository.delete(1);

        System.out.println(repository.findById(2)); // Course{id=2, name='JPA', author='g'} (toString method)
        System.out.println(repository.findById(3)); // Course{id=3, name='JPA', author='a'}

    }
}
