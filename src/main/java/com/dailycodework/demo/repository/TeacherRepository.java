package com.dailycodework.demo.repository;
import com.dailycodework.demo.model.Student;
import com.dailycodework.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Bu sınıfın bir repository olduğunu belirtir.
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // JpaRepository, CRUD işlemlerini otomatik olarak sağlar.

}
