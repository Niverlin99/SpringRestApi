package com.hcl.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springrest.entity.Courses;
import com.hcl.springrest.service.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "welcome to course Application";
	}

	// Get the Courses
	// @GetMapping("/courses") or
	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<Courses> getAllCourses() {
		return this.courseService.getCourses();
	}

	// Get single course By Id
	@GetMapping("/courses/{courseId}")
	public Courses getCourseById(@PathVariable String courseId) {
		return this.courseService.getCourseId(Long.parseLong(courseId));
	}

	// Get single course By name
	@GetMapping("/coursesName/{courseName}")
	public Courses getCourseByName(@PathVariable String courseName) {
		return this.courseService.getCourseName(courseName);
	}

	// Add the course
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses courses) {
		return this.courseService.addNewCourses(courses);
	}

	// Update the course
	@PutMapping("/courses")
	public Courses updateCourses(@RequestBody Courses courses) {
		return this.courseService.updateCourse(courses);
	}

	// Delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
