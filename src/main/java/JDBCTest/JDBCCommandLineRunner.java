package JDBCTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Chạy query từ repo template tg ứng vs class implement interface CommandLineRunner
// Cần implement 1 method run thôi
@Component
public class JDBCCommandLineRunner implements CommandLineRunner {
    // Khởi tạo 1 repo từ JDBCTemplate Class. Vì là field nên cần @Autowired
    @Autowired
    JDBCTemplate repository;

    // Override method run, chạy method tg ứng trong repo bên trên (insert/delete dl)
    // với tham số truyền vào tg ứng
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner run------------");
        repository.insert(new Course(1, "z", "y"));
        repository.insert(new Course(2, "g", "g"));
        repository.insert(new Course(3, "a", "a"));

        repository.deleteById(1);

    }
}
