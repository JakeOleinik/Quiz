package logic;

import java.util.Scanner;

import persistency.GroupMapper;

public class ActionHandler {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	public static void createGroup() {
		System.out.print("Name: ");
		String name = reader.next(); // Scans the next token of the input as an int
		int id = GroupMapper.INSTANCE.createGroup(name);
		System.out.println("Created group with id="+id);
	}
}
