package logic;

import java.util.List;
import java.util.Scanner; 


import persistency.PersonMapper;

public class MainProgram {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

	// Supported actions
	private enum Action {
			CreatePerson, CreateTeam, CreateGroup,
			AddPersonToTeam, AddTeamToQuiz
	};
	
	private static void showMenu() {
		System.out.println("-----------------------");
		System.out.println("What do you want to do?");
		for (Action action: Action.values()) {
			System.out.println("" + action.ordinal() + ": " + action);
		}
		System.out.print("Type here: ");

		int n = reader.nextInt(); // Scans the next token of the input as an int
		if (n<0 || n>=Action.values().length) {
			System.out.println("Invalid value");
			return;
		}
		switch(Action.values()[n]) {
			case CreatePerson:
				ActionHandler.createPerson();
				break;
			
			case CreateTeam:
				ActionHandler.createTeam();
				break;
				
			case CreateGroup:
				ActionHandler.createGroup();
				break;
				
			case AddPersonToTeam:
				ActionHandler.addPersonToTeam();
				break;
				
			case AddTeamToQuiz:
				ActionHandler.addTeamToQuiz();
				break;
			
			default:
				break;
			
		}
	}

	public static void main(String[] args) {
		PersonMapper pm = PersonMapper.INSTANCE;
		
		// get all person names
		List<String> names = pm.getPersonNames();
		for (String name: names) {
			System.out.println(name);
		}
				
		System.out.println("Welcome to the Quiz Competition!");
		
		while (true) {
			showMenu();
		}				
	}
}
