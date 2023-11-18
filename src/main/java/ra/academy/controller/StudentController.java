package ra.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.academy.entity.Student;
import ra.academy.service.IStudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    // lấy về tất cả học sinh
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    // lấy sinh viên theo id
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    // thêm mới
    @PostMapping
    public ResponseEntity<Student> doAdd(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    // cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Student> doUpdate(@RequestBody Student student, @PathVariable Long id) {
        return new ResponseEntity<>(studentService.update(student, id), HttpStatus.OK);
    }

    // xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> doDelete(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/todo")
    public ResponseEntity<?> getAllAndPanging(@RequestParam int page, @RequestParam int size, @RequestParam String sort, @RequestParam String by) {
        return new ResponseEntity<>(studentService.getAllPangingAndSorting(page, size, sort, by), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String name, @RequestParam int page, @RequestParam int size, @RequestParam String sort, @RequestParam String by) {
        return new ResponseEntity<>(studentService.findAllByNameContaining(name, page, size, sort, by), HttpStatus.OK);
    }
    @GetMapping("/get-avg")
    public ResponseEntity<?> getAgeAvg() {
        return new ResponseEntity<>(studentService.getAvgAge(), HttpStatus.OK);
    }
}
