package logic;

import java.util.Scanner;

import entities.Group;

import java.time.LocalDate;
import java.util.List;

import persistency.*;
import entities.*;

public class ActionHandler {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	public static void createGroup() {
		System.out.print("Name: ");
		String name = reader.nextLine();
		Group group = new Group(name);
		int createdId = GroupMapper.INSTANCE.createGroup(group);
		if (createdId==-1) {
			System.out.println("Failed to create a group");
			return;
		}
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
		int createdId = TeamMapper.INSTANCE.createTeam(team);
		if (createdId==-1) {
			System.out.println("Failed to create a team");
			return;
		}
		System.out.println("Created team '"+team.getName()+"' with id="+team.getId());
	}
	
	public static void createPerson() {
		//	public Person(String email) {		
		Person dummy = new Person();
		String lastName;
		String firstName;
		String dob;
		String phoneNumber;
		String email;
		List<Group> groups;
		int groupId;
		do {
			System.out.print("Last name: ");
			lastName = reader.nextLine();
		} while (!dummy.setLastName(lastName));
		do {
			System.out.print("First name: ");
			firstName = reader.nextLine();
		} while (!dummy.setFirstName(firstName));
		do {
			System.out.print("Date of birth: ");
			dob =  reader.nextLine();
		} while (!dummy.setDateOfBirthFromString(dob));
		do {
			System.out.print("Phone number: ");
			phoneNumber = reader.nextLine();
		} while (!dummy.setPhone(phoneNumber));
		do {
			System.out.print("Email: ");
			email = reader.nextLine();
		} while (!dummy.setEmail(email));
		do {
			groups = GroupMapper.INSTANCE.getGroups();
			System.out.println("Available groups:");
			System.out.println(groups);
			System.out.print("Enter group id: ");
			groupId = reader.nextInt();
		} while (!existsGroup(groups, groupId));
		final int finalGroupId = groupId;
		Group group = groups.stream().filter(x -> x.getId() == finalGroupId).findFirst().get();
		Person realPerson = new Person(lastName, firstName, phoneNumber, email, dob, group);
		int createdId = PersonMapper.INSTANCE.createPerson(realPerson);
		if (createdId==-1) {
			System.out.println("Failed to create a person");
			return;
		}
		System.out.println("Created person "+realPerson.getFirstName()+" "+realPerson.getLastName()+
				" with id="+realPerson.getId());
	}
	
	private static boolean existsGroup(List<Group> groups, int groupId) {
		if (!groups.stream().anyMatch(x -> x.getId() == groupId)) {
			System.out.println(""+groupId+" is an invalid group id");
			return false;
		}
		return true;
	}
}
