package com.lfj.demo.entity;

import com.lfj.demo.utils.CompareCompartor;
import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "persion_inf")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "training_inf", joinColumns = @JoinColumn(name = "persion_id", nullable = false))
    @Column(name = "training_name", nullable = false)
    //@SortNatural
    //@SortComparator(value = CompareCompartor.class) /* 没有起什么作用 */
    @OrderBy("training_name desc") /* 没有起什么作用 */
    private SortedSet<String> trainings = new TreeSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SortedSet<String> getTrainings() {
        return trainings;
    }

    public void setTrainings(SortedSet<String> trainings) {
        this.trainings = trainings;
    }
}
