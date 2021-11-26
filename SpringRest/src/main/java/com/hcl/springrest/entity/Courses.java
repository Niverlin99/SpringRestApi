package com.hcl.springrest.entity;

public class Courses {

	private long course_id;
	private String title;
	private String description;

	public Courses(long course_id, String title, String description) {
		super();
		this.course_id = course_id;
		this.title = title;
		this.description = description;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", title=" + title + ", description=" + description + "]";
	}

}
