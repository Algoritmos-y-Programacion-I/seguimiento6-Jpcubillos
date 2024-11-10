package model;

public class FloraSpecies extends Species {

String flowers="";
String fruit="";
double height=0;

    public FloraSpecies (String name, String scientificName, String flowers, String fruit, double height){

    super(name, scientificName);
    this.flowers = flowers;
    this.fruit = fruit;
    this.height = height;

    }

    public String getFlowers() {
        return flowers;
    }

    public void setFlowers(String flowers) {
        this.flowers = flowers;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Flora species : " + super.toString()  + flowers +   ", " + fruit + ", Height: " + height + ". \n";
    }


    
    
}
