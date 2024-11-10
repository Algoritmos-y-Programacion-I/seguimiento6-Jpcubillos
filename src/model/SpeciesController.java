package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	
	public String registerFaunaSpecie(String name, String scientificName, String migratory, double weight) {
		
		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {

				species[i] = new FaunaSpecies(name , scientificName , migratory , weight);

				return "Specie registered successfully";

			}

		}

		return "Error, the limits of species to be registered has been reached";
	}

	

	public String registerFloraSpecie(String name, String scientificName, String flowers, String fruit, double height) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {

				species[i] = new FloraSpecies(name , scientificName ,flowers, fruit , height);

				return "Specie registered successfully";

			}

		}

		return "Error, the limits of species to be registered has been reached";

	}
	
	public String showNames(){

		String msg = "";
	
		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + "- " + species[i].getName();
				}
			}
	
			return msg;
	
		}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				if (species[i] instanceof FloraSpecies) {
				msg += "\n" + "- " + ((FloraSpecies) species[i]).toString();

				}else{
				msg += "\n" + "- " + ((FaunaSpecies) species[i]).toString();
				}
			}
		}

		if (msg.isEmpty()) {
			msg = "There are no registered species.";
		}
	

		return msg;

	}

	public String showInfComplete(String name){
	
		String msg = "";
		Species species = searchSpecies(name);

            if (species != null) {
				if (species instanceof FloraSpecies) {
						
						msg=((FloraSpecies) species).toString();
			
					}else {
						
						msg=((FaunaSpecies) species).toString();
					}
                    return msg;
                }
    
			msg= "The species was not found.";

        return msg;

	}

	public String editSpecies(String nameTomodify, String mod, int op){

		Species specieToUpdate = searchSpecies(nameTomodify);

        if (specieToUpdate == null) {
            return "The species was not found.";
        }

        String msg = "";

        if (specieToUpdate instanceof FloraSpecies) {
            msg = editFloraSpecie((FloraSpecies) specieToUpdate, mod, op);

        } else if (specieToUpdate instanceof FaunaSpecies) {
            msg = editFaunaSpecie((FaunaSpecies) specieToUpdate, mod, op);
        } else {
            msg = "Invalid species type.";
        }

        return msg;

	}

	public String editFloraSpecie(FloraSpecies specieToUpdate, String mod, int op){


		String msg = "";
  
		switch (op) {
		  case 1:
				specieToUpdate.setName(mod); 
				msg = "The species name was successfully modified.";
				break;
	
		  case 2:
		  		specieToUpdate.setScientificName(mod); 
		  		msg = "The scientific name was successfully modified.";
		  		break;
	
		  case 3:
				specieToUpdate.setFlowers(mod); 
				msg = "The flowers information was successfully modified.";
				break;

		  case 4:
		  		specieToUpdate.setFruit(mod);
		  		msg = "The fruit information was successfully modified.";
		  		break;
			
		  case 5:
	
		  double height = Double.parseDouble(mod);
	
				specieToUpdate.setHeight(height);
				msg = "The height was successfully modified.";
				break;
			  
		  default:
				  msg = "Opcion invalida, intentelo de nuevo";
				  break;
		  }
	  
		  return msg;


	}

	public String editFaunaSpecie(FaunaSpecies specieToUpdate, String mod, int op){


		String msg = "";
  
		switch (op) {
		  case 1:
		  		specieToUpdate.setName(mod);
		  		msg = "The species name was successfully modified.";
		  		break;
				  
			
	
		  case 2:
		  		specieToUpdate.setScientificName(mod);
		  		msg = "The scientific name was successfully modified.";
		  		break;

	
		  case 3:
		  		specieToUpdate.setMigratory(mod);
		  		msg = "The migratory information was successfully modified.";
		  		break;	
	

		  case 4:
	
		 		double weight = Double.parseDouble(mod);

				specieToUpdate.setWeight(weight);
				msg = "The weight was successfully modified.";
				break;


		  default:
                msg = "Invalid option, please try again.";
                break;

		}
	  
		  return msg;

	}


	public String deleteSpecies(String nameToDelete) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[i].getName().equalsIgnoreCase(nameToDelete)) {
				species[i] = null; 
				return "The species " + nameToDelete + " has been deleted successfully.";
			}
		}
		return "Error: The species " + nameToDelete + " was not found.";
	}


	public Species searchSpecies(String name) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if (species[i].getName().equalsIgnoreCase(name)) {
					return species[i];
				}
			}
		}

		return null;

	}

	public boolean searchInstance(String name) {

		Species specie= searchSpecies(name);

		if(specie instanceof FloraSpecies){

			return true;

		}else{

			return false;

		}
		}

}
