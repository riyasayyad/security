package com.torus2.torus.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.torus2.torus.entities.Course;
public interface CourseDao extends JpaRepository<Course, Long> {

}
