package com.drs.pojo;

import java.util.Date;
import java.util.List;

public class OrderQueryVo {
	
	private List<Integer> ids;
	
	private List<TbStudent> students;
	
	private List<TbCar> cars;
	
	private List<TbTime> times;
	
	private List<Date> submitDates;
	

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<TbStudent> getStudents() {
		return students;
	}

	public void setStudents(List<TbStudent> students) {
		this.students = students;
	}

	public List<TbCar> getCars() {
		return cars;
	}

	public void setCars(List<TbCar> cars) {
		this.cars = cars;
	}

	public List<TbTime> getTimes() {
		return times;
	}

	public void setTimes(List<TbTime> times) {
		this.times = times;
	}

	public List<Date> getSubmitDates() {
		return submitDates;
	}

	public void setSubmitDates(List<Date> submitDates) {
		this.submitDates = submitDates;
	}
	
	
	

}
