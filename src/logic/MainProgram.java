package logic;

import java.util.List;
import java.util.Scanner; 


import persistency.PersonMapper;

public class MainProgram {
	
	private static Scanner reader = new Scanner(System.in);  // Reading from System.in

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
				
				break;
			
			case CreateTeam:
				
				break;
				
			case CreateGroup:
				
				break;
				
			case AddPersonToTeam:
				
				break;
				
			case AddTeamToQuiz:
				
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
