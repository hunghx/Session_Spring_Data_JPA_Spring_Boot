package ra.academy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.academy.entity.Student;
import ra.academy.repository.IStudentRepository;
import ra.academy.service.IStudentService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        Iterable<Student> iterator = studentRepository.findAll();
        return (List<Student>) iterator;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Student delete(Long id) {
        Student s = findById(id);
         studentRepository.deleteById(id); // thực hiện xóa
         return s; // trả về đối tượng vừa xóa
    }

    @Override
    public Page<Student> getAllPangingAndSorting(int page, int size,String sort, String by) {
        Sort sortFor;
        if(by.equalsIgnoreCase("desc")){
            sortFor =Sort.by(sort).descending();
        }else {
            sortFor =Sort.by(sort).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sortFor);// là đối tượng dùng để phân trâng và sắp xếp
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findAllByNameContaining(String name) {
        return (List<Student>) studentRepository.findAllByNameContaining(name);
    }

    @Override
    public Page<Student> findAllByNameContaining(String name, int page, int size, String sort, String by) {
        Sort sortFor;
        if(by.equalsIgnoreCase("desc")){
            sortFor =Sort.by(sort).descending();
        }else {
            sortFor =Sort.by(sort).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sortFor);
        return  studentRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public double getAvgAge() {
        return studentRepository.getAvgAgeStudent();
    }
}
