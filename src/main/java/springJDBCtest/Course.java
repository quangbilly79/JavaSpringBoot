package springJDBCtest;


// Class trả về trong rest api vs constructor và getter các thứ
public class Course {
    private long id;
    private String name;
    private String author;

    public Course(long id, String name, String author) {
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
    public void setId(long id) {
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
