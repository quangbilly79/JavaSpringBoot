package springbootwithJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootwithJPA.Course;

import java.util.List;

// Muốn dùng Spring JPA thì extends JpaRepository<EntityClass, TypeOfIdColumn>
// Khác vs JPA thg, k cần khai báo Entity cx như các hàm/query tg ứng
public interface SpringBootWithJPARepository extends JpaRepository<Course, Integer> {

    // Riêng cần custom query thì ms cần tạo riêng 1 hàm trong này
    // Trả về List<Object[]>, có thể convert sau tùy tình huống
    @Query("SELECT c.name, COUNT(c) AS count_name FROM course_test c GROUP BY c.name HAVING COUNT(c) > 1")
    List<Object[]> findDuplicateCourses();

    }

