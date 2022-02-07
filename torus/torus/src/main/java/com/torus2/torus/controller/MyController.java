package com.torus2.torus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.torus2.torus.entities.Course;
import com.torus2.torus.service.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	@GetMapping("/contact")
	public String contactUs() {
		return "Please contact us on 9999888777";
	}

	// to get courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourse();
	}
	
	@GetMapping("/course/{field}")
	public List<Course> findCourseWithSorting(@PathVariable String field){
		List<Course> allCourses = this.courseService.findCourseWithSorting(field);
		return  allCourses;
	}
	
	// pagination
	@GetMapping("courses/pagination/{offSet}/{pageSize}")
	public Page<Course> getCourseWithPagination(@PathVariable int offSet, @PathVariable int pageSize){
		Page<Course> allCourses = this.courseService.findCoursesWithPagination(offSet, pageSize);
		return allCourses;
	}
	
	@GetMapping("courses/pagination/{offSet}/{pageSize}/{field}")
	public Page<Course> getCoursesWithPaginationAndSorting(@PathVariable int offSet, @PathVariable int pageSize, @PathVariable String field)
	{
		Page<Course> allCourses=this.courseService.findCoursesWithPaginationAndSorting(offSet, pageSize, field);
		return allCourses;
	}

//	to get single course
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}