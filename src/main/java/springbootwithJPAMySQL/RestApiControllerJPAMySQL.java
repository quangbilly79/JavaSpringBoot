package springbootwithJPAMySQL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Khởi tạo Controller cho REST API
@RestController
public class RestApiControllerJPAMySQL {
    // Tạo 1 instance từ JPA repository interface để chạy query/hàm
    @Autowired
    SpringBootWithJPARepositoryMySQL repository;

    // Get method và path tg ứng (~ http://localhost:8081/courses)
    @GetMapping("/courses")
    public List<Course> getAllCourse() {
        // Dùng repository.findAll() (~ select *) để lấy hết dl trong bảng
        // Trả về ds các Course (1 course ~ 1 dòng)
        List<Course> listCourse = repository.findAll();
        return listCourse;
        // [{"id":1,"name":"author1","author":"name1"},{"id":2,"name":"author2","author":"name2"},
        // {"id":3,"name":"author3","author":"name3"}]
    }
    // Trả về course theo id tg ứng
    // Tạo url dynamic vs tham số truyền vào vs {param} và (@PathVariable param)
    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        // Tìm theo id, trả về Optional<T>,
        // check tồn tại vs .isPresent(), lấy giá trị về vs .get()
        Optional<Course> course = repository.findById(id);
        if (!course.isPresent()) {
            throw new RuntimeException(String.format("Not found id: %s", id));
        }
        return course.get();
        // curl -X GET http://localhost:8081/courses/1
        // {"id":1,"name":"author1","author":"name1"}
    }
    // POST method (@PostMapping) để thêm 1 course ms vào bảng
    // Đầu vào là dạng json, tuy vậy có thể dùng @RequestBody + Class tg ứng
    // Cần update thì thêm id tg ứng vào body course
    @PostMapping("/courses/")
    public String postNewCourse(@RequestBody Course course) {
        // Sử dụng save để thêm/update record
        repository.save(course);
        return course.getName() + ", " + course.getAuthor();
        // curl -X POST -H "Content-Type: application/json" -d
        // '{"name":"YourRandomName1","author":"YourRandomAuthor1"}' http://localhost:8081/courses/
        // YourRandomName1, YourRandomAuthor1
    }
    // Ngoài insert/update, có thể xóa luôn với POST vs .delete
    @PostMapping("/courses_del/")
    public String postDeleteCourse(@RequestBody Course course) {
        // Sử dụng save để thêm/update record
        repository.delete(course);
        return course.getName() + ", " + course.getAuthor();
        // curl -X POST -H "Content-Type: application/json" -d'
        // {"id": 100, "name":"name1","author":"author1"}'
        // http://localhost:8081/courses_del/
    }

    // Có thể chạy custom query vs post/get
    @GetMapping("/courses_custom_query/")
    public String postCustomQuery() {
        // Chạy custom query
        List<Object[]> returnResult = repository.findDuplicateCourses();
        String result = "";
        for (Object[] object:returnResult) {
            String name = (String) object[0];
            Long count = (Long) object[1];
            result += " " + name + " " + count + "\n";
        }
        return result;

    }


}
