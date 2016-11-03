package logic;

import java.util.List;

import persistency.PersonMapper;

public class MainProgram {

	public static void main(String[] args) {
		PersonMapper pm = PersonMapper.UNIQUEINSTANCE;
		
		// get all person names
		List<String> names = pm.getPersonNames();
		for (String name: names) {
			System.out.println(name);
		}
		
	}

}
