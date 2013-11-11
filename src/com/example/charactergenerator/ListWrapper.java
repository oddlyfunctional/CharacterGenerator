package com.example.charactergenerator;

import java.util.ArrayList;
import java.util.List;

public class ListWrapper<T> {
	
	private List<T> list;
	
	public ListWrapper(List<T> list) {
		this.list = list;
	}

	public List<T> find(Object o) {
		ArrayList<T> result = new ArrayList<T>();
		for (T element : list) {
			if (element.equals(o)) {
				result.add(element);
			}
		}
		
		return result;
	}
}
