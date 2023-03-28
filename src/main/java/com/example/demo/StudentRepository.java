package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("select s from Student s where s.firstName = ?1 and s.age = ?2")
    List<Student> selectStudentWhereFirstNameAndAgeEquals(String firstName, Integer age);

    @Query(
            value = "select * from Student where first_name = :firstName and age = :age",
            nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeEqualsNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

    @Transactional
    @Modifying
    @Query("delete from Student u where u.id = ?1")
    void deleteStudentById(Long id);

    @Transactional
    void deleteStudentByAge(Integer age);
}
