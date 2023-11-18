package ra.academy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.academy.entity.Student;

// CrudRepository : interface hõ trợ các phương thức crud trong jpa
@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
        Iterable<Student> findAllByNameContaining(String name);
        Page<Student> findAllByNameContaining(String name, Pageable pageable);

        @Query(nativeQuery = true,value = "Select avg(age) from students")
        double getAvgAgeStudent();
}
