package springbootstarted;

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
