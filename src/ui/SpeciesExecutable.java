package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController controller;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		controller = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Consult a Species");
			System.out.println("4. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerSpecies();
				break;

			case 2:
				editSpecies();
				break;

			case 3:
			    consultSpecies();
				break;

			case 4:
				deleteSpecies();
				break;

			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}

	public void registerSpecies() {
		reader.nextLine();

		String flowers="";
		String fruit="";
		String migratory="";

		System.out.println("Type the new Species' name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.nextLine();
		
		boolean stopFlag = false;

		while (!stopFlag) {
		System.out.println("Enter the Specie type: (1.) Flora / (2.) Fauna ");
		int op = reader.nextInt();
		reader.nextLine();

		switch (op){

			case 1: 
			boolean stopFlag1 = false;

		    while (!stopFlag1) {
			System.out.println("Does it have flowers?: (1.) Yes / (2.) No ");
		    int opFlowers = reader.nextInt();
			
			if (opFlowers == 1){
			flowers= "Have flowers";
			stopFlag1 = true;

			}else if (opFlowers == 2){
			flowers= "Doesn't have flowers";
			stopFlag1 = true;

			} else {
			System.out.println("You must type a valid option");
			stopFlag1 = false;
			}
			
			reader.nextLine();

		}

			boolean stopFlag2 = false;

			while (!stopFlag2) {
			System.out.println("Does it have fruits?: (1.) Yes / (2.) No ");
		    int opFruit = reader.nextInt();
			reader.nextLine();

			if (opFruit == 1){
			fruit= "Have fruits";
			stopFlag2 = true;

			} else if (opFruit == 2){
			fruit= "Doesn't have fruits";
			stopFlag2 = true;

			} else{
			System.out.println("You must type a valid option");
			stopFlag2 = false;
			
			}
		}

			System.out.println("Type the height: (Cm)");
		    double height = reader.nextDouble();
			reader.nextLine();

			System.out.println(controller.registerFloraSpecie(name, scientificName , flowers, fruit, height));
			stopFlag = true;
			break;


			case 2:
			
			boolean stopFlag3 = false;

			while (!stopFlag3) {
			System.out.println("Is it migratory?: (1.) Yes / (2.) No ");
		    int opMigratory = reader.nextInt();
			reader.nextLine();

			if (opMigratory == 1){
			migratory= "Its migratory";
			stopFlag3 = true;

			}else if (opMigratory == 2){
			migratory= "It is not migratory";
			stopFlag3 = true;

			}else{
			System.out.println("You must type a valid option");
			stopFlag3 = false;
			}

			}

			System.out.println("Type the maximum weight it can have: (Grams)" );
			double weight = reader.nextDouble();
			reader.nextLine();

			System.out.println(controller.registerFaunaSpecie(name, scientificName , migratory, weight));
			stopFlag = true;
			break;


			default:
			System.out.println("You must type a valid option");
			break;

		}


		}

	}

	public void editSpecies() {
		reader.nextLine(); 

		String mod="";
        int op_f=0;
		String nameToModif="";

		System.out.println("Which Species do you want to edit?");
		String query = controller.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Enter the name of the species you want to edit");
			nameToModif = reader.nextLine();

            String list = controller.showInfComplete(nameToModif);

            System.out.println("The complete species information is: " + list);

			
			if (controller.searchSpecies(nameToModif) == null){
			System.out.println("Erorr: species not found");
			
			}else{

				if (controller.searchInstance(nameToModif)){

					boolean stopFlag1 = false;

		            while (!stopFlag1) {
					System.out.println("Enter the number according to the information you want to modify: (1.) Name / (2.) Scientific Name / (3.) Flowers / (4.) Fruit / (5.) Height ");
					int op = reader.nextInt();
					reader.nextLine();  
			
					switch (op) {
			
					case 1:
						System.out.println("Type the new Species' name: ");
						mod = reader.nextLine();
						stopFlag1 = true;
						break;
			
					case 2:
						System.out.println("Type the new Species' scientific name: ");
						mod = reader.nextLine();
						stopFlag1= true;
						break;
			

					case 3:
						System.out.println("Does it have flowers?: (1.) Yes / (2.) No ");
						int opFlowers = reader.nextInt();
					
						if (opFlowers == 1){
						mod= "Have flowers";
						}
						else {
						mod= "Doesn't have flowers";
						}
						stopFlag1 = true;
						break;
			

					case 4:
						System.out.println("Does it have fruits?: (1.) Yes / (2.) No ");
						int opFruit = reader.nextInt();
						reader.nextLine();
		
						if (opFruit == 1){
						mod= "Have fruits";
						}
						else {
						mod= "Doesn't have fruits";
						}
						stopFlag1 = true;
						break;

						
					case 5:
						System.out.println("Type the height:");
						mod= reader.nextDouble() + "";
						stopFlag1 = true;
						break;


					default:
						System.out.println("You must type a valid option");
						break;
				}
				op_f = op;
				}

				}else{

					boolean stopFlag2 = false;

		            while (!stopFlag2) {
					System.out.println("Enter the number according to the information you want to modify: (1.) Name / (2.) Scientific Name / (3.) Migratory / (4.) Weight ");
					int op = reader.nextInt();
					reader.nextLine();
			
					switch (op) {
			
					case 1:
						System.out.println("Type the new Species' name: ");
						mod = reader.nextLine();
						stopFlag2 = true;
						break;

			
					case 2:
						System.out.println("Type the new Species' scientific name: ");
						mod = reader.nextLine();
						stopFlag2= true;
						break;

			
					case 3:
						System.out.println("Is it migratory?: (1.) Yes / (2.) No ");
						int opMigratory = reader.nextInt();
						reader.nextLine();
		
						if (opMigratory == 1){
						mod= "Its migratory";
						}
						else {
						mod= "It is not migratory";
						}
						stopFlag2 = true;
						break;

			
					case 4:
						System.out.println("Type the maximum weight it can have:" );
						mod = reader.nextDouble() + "";
						stopFlag2 = true;
						break;	

			
					default:
						System.out.println("You must type a valid option");
						break;
				}
				op_f = op;

				}
				}
			}

			System.out.println(controller.editSpecies(nameToModif, mod, op_f));

    		System.out.println("The new information is: " + controller.showSpeciesList());

			
		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void deleteSpecies() {
		reader.nextLine();

		System.out.println("Which Species do you want to delete?");

		String query = controller.showNames();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Enter the name of the species you want to edit");
			String nameToModif = reader.nextLine();

			System.out.println(controller.deleteSpecies(nameToModif));

			System.out.println("\nlist of remaining species: \n ");
			System.out.println(controller.showSpeciesList());


		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void consultSpecies() {
		reader.nextLine();

		System.out.println("Which Species do you want to review?");

		String query = controller.showNames();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Enter the name of the species you want to edit");
			String nameToModif = reader.nextLine();

            String list = controller.showInfComplete(nameToModif);

            System.out.println("The complete species information is: " + list);
			

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
