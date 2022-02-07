package com.torus2.torus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.torus2.torus.entities.Course;

public interface CourseService {
	public List<Course> getCourse();
	public Optional<Course> getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public Course deleteCourse(long parseLong);
	public List<Course> findCourseWithSorting(String field);

	public Page<Course> findCoursesWithPagination(int offSet, int pageSize);

	public Page<Course> findCoursesWithPaginationAndSorting(int offset, int pageSize, String field);}