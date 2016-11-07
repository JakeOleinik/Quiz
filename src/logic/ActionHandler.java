package logic;

import java.util.Scanner;

import entities.Group;

import java.util.List;

import persistency.GroupMapper;
import entities.Group;

public class ActionHandler {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	public static void createGroup() {
		System.out.print("Name: ");
		String name = reader.next();
		Group group = new Group(name);
		GroupMapper.INSTANCE.createGroup(group);
		System.out.println("Created group with id="+group.getId());
	}
	
	public static void createTeam() {
		System.out.print("Name: ");
		String name = reader.next();
		List<Group> groups = GroupMapper.INSTANCE.getGroups();
		System.out.println("Available groups:");
		System.out.println(groups);
	}
}
