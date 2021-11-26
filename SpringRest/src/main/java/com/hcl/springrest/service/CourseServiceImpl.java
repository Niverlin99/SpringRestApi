package com.hcl.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.springrest.entity.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> courseList;

	public CourseServiceImpl() {

		courseList = new ArrayList<>();
		courseList.add(new Courses(101, "Java", "Java Edition"));
		courseList.add(new Courses(102, "Struts", "Struts Framework"));
	}

	@Override
	public List<Courses> getCourses() {
		return courseList;
	}

	@Override
	public Courses getCourseId(long courseId) {
		Courses cId = null;
		for (Courses courses : courseList) {
			if (courses.getCourse_id() == courseId) {
				cId = courses;
				break;
			}
		}
		return cId;
	}

	@Override
	public Courses getCourseName(String courseName) {
		Courses cName = null;
		for (Courses courses : courseList) {
			if (courses.getTitle().equals(courseName)) {
				cName = courses;
				break;
			}
		}
		return cName;
	}

	@Override
	public Courses addNewCourses(Courses courses) {
		courseList.add(courses);
		return courses;
	}

	@Override
	public Courses updateCourse(Courses courses) {
		courseList.forEach(e -> {
			if (e.getCourse_id() == courses.getCourse_id()) {
				e.setTitle(courses.getTitle());
				e.setDescription(courses.getDescription());
			}
		});
		return courses;
	}

	@Override
	public void deleteCourse(long courseId) {
		courseList = this.courseList.stream().filter(e -> e.getCourse_id() != courseId).collect(Collectors.toList());
	}

}
