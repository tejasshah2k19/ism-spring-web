package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.EmployeeBean;

@RestController
public class EmployeeController {

	List<EmployeeBean> list = new ArrayList<EmployeeBean>();

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public EmployeeBean insertUser(EmployeeBean employeeBean) {
		// dao.insert(employeeBean);
		list.add(employeeBean);
		return employeeBean;

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<EmployeeBean> listUsers() {
		return list;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public EmployeeBean getDataById(@PathVariable("id") int id) {

		for (EmployeeBean e : list) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

}
