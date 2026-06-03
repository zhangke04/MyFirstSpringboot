package com.example.fristproject.Controller;
import com.example.fristproject.entity.Student;
import com.example.fristproject.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController//标识这是一个控制器类，专门用于处理http请求
@RequestMapping("/student")//将url路径映射到这个控制器上
public class StudentController {
    private final Studentrepository studentrepository;
    @Autowired//将写好的Repository注入进来
   public StudentController(Studentrepository studentrepository){
        this.studentrepository=studentrepository;
    }//构造函数注入依赖
    @GetMapping("/add")
    public String addStudent(@RequestParam long id,@RequestParam String name,@RequestParam Integer age){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        studentrepository.save(student);
        return "插入成功，请去PostgreSQL查看表";
    }
    @GetMapping("/list")
    public List<Student> getStudentList(){
        return studentrepository.findAll();
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam long id){
        studentrepository.deleteById(id);
        return "删除成功，请去PostgreSQL查看表";
    }

    @GetMapping("/ageGreater")
    public List<Student> getStudentsOlderThan(@RequestParam(defaultValue = "18") Integer age){
        return studentrepository.findByAgeGreaterThan(age);
    }


}
