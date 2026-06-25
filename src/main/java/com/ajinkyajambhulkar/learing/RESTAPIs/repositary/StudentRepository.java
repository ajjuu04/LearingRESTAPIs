package com.ajinkyajambhulkar.learing.RESTAPIs.repositary;

import com.ajinkyajambhulkar.learing.RESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
