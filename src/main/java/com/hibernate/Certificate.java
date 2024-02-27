package com.hibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {
	private int course_id;
	private String course;
	private String duration;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(int id, String course, String duration) {
		super();
		this.course_id = id;
		this.course = course;
		this.duration = duration;
	}

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	@Override
	public String toString() {
		return "Certificate [id=" + course_id + ", course=" + course + ", duration=" + duration + "]";
	}
	
	
}
