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
        repository.insert(new JPATest.Course(1, "JPA_1", "z"));
        repository.insert(new JPATest.Course(1, "JPA_1_update", "y"));
        repository.insert(new JPATest.Course(2, "JPA_2", "g"));
        repository.insert(new JPATest.Course(3, "JPA_1", "a"));
        repository.insert(new JPATest.Course(4, "JPA_2", "a"));
        repository.insert(new JPATest.Course(5, "JPA_2", "a"));

        // repository.delete(1);

        System.out.println(repository.findById(2)); // Course{id=2, name='JPA', author='g'} (toString method)
        System.out.println(repository.findById(3)); // Course{id=3, name='JPA', author='a'}

        // Hibernate: select course0_.name as col_0_0_, count(course0_.id) as col_1_0_ from course_test course0_
        // where course0_.id>=2 group by course0_.name having count(course0_.id)>1
        repository.findDuplicateCourses(2).stream().forEach(System.out::println); // Name: JPA_2, Count: 3

    }
}
