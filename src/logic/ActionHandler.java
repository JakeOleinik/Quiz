package logic;

import java.util.Scanner;

import entities.Group;

import java.util.List;

import persistency.*;
import entities.*;

public class ActionHandler {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	public static void createGroup() {
		System.out.print("Name: ");
		String name = reader.nextLine();
		Group group = new Group(name);
		GroupMapper.INSTANCE.createGroup(group);
		System.out.println("Created group '"+group.getName()+"' with id="+group.getId());
	}
	
	public static void createTeam() {
		System.out.print("Name: ");
		String name = reader.nextLine();
		List<Group> groups = GroupMapper.INSTANCE.getGroups();
		System.out.println("Available groups:");
		System.out.println(groups);
		System.out.print("Enter group id: ");
		int groupId = reader.nextInt();
		Team team = new Team(name, groupId);
		TeamMapper.INSTANCE.createTeam(team);
		System.out.println("Created team '"+team.getName()+"' with id="+team.getId());
	}
}
