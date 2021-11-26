package com.hcl.springrest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.springrest.entity.Courses;

public interface CourseService {

	public List<Courses> getCourses();

	public Courses getCourseId(long courseId);

	public Courses getCourseName(String courseName);

	public Courses addNewCourses(Courses courses);

	public Courses updateCourse(Courses courses);

	public void deleteCourse(long courseId);
}
