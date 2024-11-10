package model;

public class FaunaSpecies extends Species {

    String migratory="";
    double weight=0;

    public FaunaSpecies (String name, String scientificName, String migratory, double weight){

        super(name, scientificName);
        this.migratory = migratory;
        this.weight = weight;
        
        }

    public String getMigratory() {
        return migratory;
    }

    public void setMigratory(String migratory) {
        this.migratory = migratory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    

    @Override
    public String toString() {
        return "Fauna species : " + super.toString() + migratory + ", Weight: " + weight + ". \n";
    }
}
