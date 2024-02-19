package springbootstarted;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Khởi tạo Controller cho REST API
@RestController
public class RestApiController {
    // Get method và path tg ứng (~ http://localhost:8080/course)
    @GetMapping("/course")
    public List<Course> helloWorldGetAPI() {
        List<Course> listCourse = new ArrayList<>();
        Collections.addAll(listCourse, new Course(1, "name1", "author1"),
                new Course(2, "name2", "author2"));
        // Trả về List các Course
        return listCourse; // [{"id":1,"name":"name1","author":"author1"}]
    }
    // Tg tự nhưng trả về 1 Course thay vì list Course như bên trên
    @GetMapping("/course/1")
    public Course helloWorldGetAPI1() {
        Course course = new Course(1, "name1", "author1");
        // Trả về List các Course
        return course; // {"id":1,"name":"name1","author":"author1"}
    }
}
