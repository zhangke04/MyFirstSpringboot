//数据访问层，负责与数据库交互的部分
package com.example.fristproject.repository;

import com.example.fristproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;//类直接继承jpaRepository接口，可以直接拥有全部若干种包括不限于增删改查的方法
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepository extends JpaRepository<Student, Long> {
    // 泛型解释：<操作的实体类, 主键的数据类型>

    // 你不用写任何实现代码，Spring Boot 会在底层自动帮你生成 SQL
    // 如果你想自定义查询，比如“通过名字找学生”，只需按规则命名方法：
    // List<Student> findByName(String name);
}