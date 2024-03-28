package springbootwithJPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootwithJPA.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Khởi tạo Controller cho REST API
@RestController
public class RestApiControllerJPA {
    // Tạo 1 instance từ JPA repository interface để chạy query/hàm
    @Autowired
    SpringBootWithJPARepository repository;

    // Get method và path tg ứng (~ http://localhost:8080/course)
    @GetMapping("/courses")
    public List<Course> helloWorldGetAPI() {
        // Dùng repository.findAll() (~ select *) để lấy hết dl trong bảng
        // Trả về ds các Course (1 course ~ 1 dòng)
        List<Course> listCourse = repository.findAll();
        return listCourse;
        // [{"id":1,"name":"author1","author":"name1"},{"id":2,"name":"author2","author":"name2"},
        // {"id":3,"name":"author3","author":"name3"}]
    }
    // Tg tự nhưng trả về 1 Course thay vì list Course như bên trên
    @GetMapping("/courses/1")
    public Course helloWorldGetAPI1() {
        Course course = new Course(1, "name1", "author1");
        // Trả về List các Course
        return course; // {"id":1,"name":"name1","author":"author1"}
    }
}
