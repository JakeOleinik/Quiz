package logic;

import java.util.Scanner;
import java.util.List;


import persistency.GroupMapper;

public class ActionHandler {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	public static void createGroup() {
		System.out.print("Name: ");
		String name = reader.next();
		int id = GroupMapper.INSTANCE.createGroup(name);
		System.out.println("Created group with id="+id);
	}
	
	public static void createTeam() {
		System.out.print("Name: ");
		String name = reader.next();
		List<String> groups = GroupMapper.INSTANCE.getGroupIdsAndNames();
		System.out.println("Available groups:");
		System.out.println(groups);
	}
}
