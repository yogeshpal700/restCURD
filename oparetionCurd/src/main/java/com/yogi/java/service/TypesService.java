package com.yogi.java.service;

import java.util.List;

import com.yogi.java.beans.Types;

public interface TypesService {
	
	public Types getTypesId(int id);
	public Types getTypesName(String name);
	public List<Types> getAllTypes();
	public void addTypes(Types types);
	public void editTypes(Types types);
	public void deleteTypes(int id);
	public void deleteAll();
	boolean isTypesExist();
	
}
