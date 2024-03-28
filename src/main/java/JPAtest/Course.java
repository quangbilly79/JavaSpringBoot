package JPAtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// Class trả về trong rest api vs constructor và getter các thứ
// Mapping class vs bảng với @Entity(name="tableName"), cùng tên thì k cần (name=)
@Entity(name="course_test")
public class Course {
    // Map các cột vs @Column(name="colname"), cùng tên thì k cần annotation này luôn
    // riêng cột Id có thể map riêng với @Id.
    // Class JPA luôn cần 1 cột với @Id làm identifier (k sẽ lỗi)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;

    public Course(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    // Default constructor cho query select, đề phòng TH k tìm thấy giá trị
    public Course() {
        this.id = -1;
        this.name = "default_name";
        this.author = "default_author";
    }
    // Nếu field là private thì cần thêm Getter để Spring Boot gọi đc đến
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
    // Cần setter trong TH query select
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
