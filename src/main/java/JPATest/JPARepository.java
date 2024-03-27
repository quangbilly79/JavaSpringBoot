package JPATest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Ngoài @Repository như JDBC, cần thêm @Transactional
@Repository
@Transactional
public class JPARepository {
    // Thêm EntityManager để quản lý và chạy các query liên quan đến Entity (bảng map vs @Entity class)
    // @PersistenceContext tương tự @AutoWired, nhưng chuyên dùng cho EntityManager
    @PersistenceContext
    public EntityManager entityManager;

    // Insert 1 class instance (~ 1 dòng) với entityManager.merge(class instance)
    public void insert(Course course) {
        entityManager.merge(course);
    }
    // Select và query kq theo id với find(Entity Class.class, args)
    // KDL trả về là <T> ~ Entity Class
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }
    // Xóa theo id với remove(Object). Cần find trc
    // K thể xóa trực tiếp = cách truyền vào 1 Course, vì entityManager k quản lý cái course này
    // Trong khi Course trả về bởi entityManager.find sẽ đc quản lý
    public void delete(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
