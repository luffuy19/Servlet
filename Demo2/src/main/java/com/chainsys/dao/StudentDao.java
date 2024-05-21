package com.chainsys.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Person;

public interface StudentDao {
	public ArrayList<Person> saveStudent(Person p) throws SQLException;
}
