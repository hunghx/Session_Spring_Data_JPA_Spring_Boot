package ra.academy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.academy.entity.Student;

import java.util.List;

public interface IStudentService extends IGenericService<Student, Long> {
    Page<Student> getAllPangingAndSorting(int page, int size, String sort, String by);

    List<Student> findAllByNameContaining(String name);

    Page<Student> findAllByNameContaining(String name, int page, int size, String sort, String by);

    double getAvgAge();
}
