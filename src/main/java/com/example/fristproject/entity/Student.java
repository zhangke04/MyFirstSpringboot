//创建实体类
package com.example.fristproject.entity;
import lombok.Data;
import lombok.Getter;
import javax.persistence.*;
@Entity
@Table(name="my_tinyuser")
@Data
public class Student {
    @Id//标志实体的主键属性，必须有且只能有一个
    @GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增策略，可以避免手动赋值，保证主键值不重复
    private long id;
    @Column(name="name",length=50)//name属性将被映射到name列，且长度最大为50
    private String name;
    private Integer age;
}
