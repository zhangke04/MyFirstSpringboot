//数据访问层，负责与数据库交互的部分
package com.example.fristproject.repository;
import java.util.List;
import com.example.fristproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;//类直接继承jpaRepository接口，可以直接拥有全部若干种包括不限于增删改查的方法
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepository extends JpaRepository<Student, Long> {
    // 泛型解释：<操作的实体类, 主键的数据类型>

    // Spring Data JPA 根据方法命名规则自动生成 SQL
    // 例如: List<Student> findByName(String name);

    /** 查找年龄大于指定值的学生 */
    List<Student> findByAgeGreaterThan(Integer age);
}