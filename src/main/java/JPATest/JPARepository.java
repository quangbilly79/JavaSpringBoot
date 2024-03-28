package JPATest;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

// Ngoài @Repository như JDBC, cần thêm @Transactional
@Repository
@Transactional
public class JPARepository {
    // Thêm EntityManager để quản lý và chạy các query liên quan đến Entity (bảng map vs @Entity class)
    // @PersistenceContext tương tự @AutoWired, nhưng chuyên dùng cho EntityManager
    @PersistenceContext
    public EntityManager entityManager;

    // Insert/Update nếu trùng id 1 class instance (~ 1 dòng) với entityManager.merge(class instance)
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

    // Vẫn có thể dùng query phức tạp (JPQL) với
    // TypedQuery<Object[]> query = entityManager.createQuery(jpqlQuery, Object[].class);
    // Trả về nh cột thì luôn dùng Object[] để hứng, có thể convert sau
    // Ngoài ra có thể dùng @Query, mà syntax sẽ khác chút
    public List<String> findDuplicateCourses(int id) {
        String jpqlQuery = "SELECT c.name, COUNT(c) AS count_name FROM course_test c where c.id >= " +
                id +
                " GROUP BY c.name HAVING COUNT(c) > 1";
        TypedQuery<Object[]> query = entityManager.createQuery(jpqlQuery, Object[].class);
        List<Object[]> resultList = query.getResultList();
        List<String> formattedResults = new ArrayList<>();
        for (Object[] result : resultList) {
            String name = (String) result[0];
            Long count = (Long) result[1];
            formattedResults.add(String.format("Name: %s, Count: %d", name, count));
        }
        return formattedResults;
    }

}
