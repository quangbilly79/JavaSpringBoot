package SpringJDBCTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Khởi tạo class dùng để kết nối vs cac db
// @Repository chuyên dùng làm anno cho class mà giao tiếp vs db
// Đã bao gồm @Component
@Repository
public class JDBCTemplateRepository {
    // Tạo template tg ứng vs JdbcTemplate (1 class của Spring). Vì là field nên cần @Autowired
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Query chạy
    // Muốn truyền tham số thì thay = ? (k cân qtâm string hay int)
    String insertQuery = "insert into course_test(id, name, author) values (?, ?, ?)";
    String deleteQuery = "delete from course_test where id = ?";
    String selectQuery = "select * from course_test where id = ?";

    // Tạo 1 hàm để Execute insert query vs template.update(query), tên là update nhưng chạy query gì cx đc
    // Truyền vào tham số là 1 instance của Course,
    // Trong hàm update giá trị 3 cột tg ứng vs 3 field của class
    public void insert(Course course) {
        jdbcTemplate.update(insertQuery, course.getId(), course.getName(), course.getAuthor());
    }

    // Tạo 1 hàm để Execute delete query vs template.update(query), tên là update nhưng chạy query gì cx đc
    // Truyền vào tham số là 1 id,
    // Trong hàm update giá trị là id nhập vao tg ứng
    public void deleteById(int id) {
        jdbcTemplate.update(deleteQuery, id);
    }

    // Tạo 1 hàm để Execute select query và trả về kdl mong muốn vs template.queryForObject(query)
    // Truyền vào tham số là 1 id (các tham số cuối)
    // Kq trả về có thể map vs Object/Class <T> mong muốn vs BeanPropertyRowMapper<T> (tham số t2)
    // Có thể dùng queryForList để trả về List<Map<String, Object>>
    public Course findById(int id) {
        return jdbcTemplate.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
