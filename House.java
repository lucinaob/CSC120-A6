import java.util.ArrayList;

public class House extends Building {

  //Attributes of houses
  ArrayList<String> residents = new ArrayList<>(); //Array list of resident names
  public boolean hasDiningRoom; //Whether or not a house has a dining room

  /**
   * House constructor
   * @param name - name of the house
   * @param address - address of the house
   * @param nFloors - floors the house
   * @param hasDiningRoom - whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //creating a house building
    this.hasDiningRoom = hasDiningRoom; 
    ArrayList<String> residents;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Method to move in a resident
   * @param s - student name
   */
  public void moveIn(String s){
    //If the person already is in the resident list,
    if (residents.contains(s)){
      //Print an error message
      System.out.println(s + " is already in " + name + ".");
    } else{ //If they do not live in the house,
      //Add the person to the list of residents
      residents.add(s);
      //Print a confirmation message
      System.out.println(s + " has moved into " + name + "!");
    }
  }

  /**
   * Method to move a student out 
   * @param s - student to move out
   */
  public void moveOut(String s){
    //If a student lives in the house, 
    if (residents.contains(s)){
      //Remove the student from the resident array list
      residents.remove(s);
      //Print an confirmation message
      System.out.println(s + " has moved out of " + name + ".");
    } else { //If they don't live in the house
      //Print error message
      System.out.println(s + " does not live in " + name + "and cannot be removed.");
    }
  }

  /**
   * Method to check if a student is a resident
   * @param s - student name
   * @return - true or false if the student is a resident of the house
   */
  public boolean isResident(String s){
    //If the student is a resident of the house,
    if (residents.contains(s)){
      //Print that they are a resident
      System.out.println(s + " is a resident of " + name + '.');
      return true;
    } else{ //If they are not,
      //Print that they are not a resident
      System.out.println(s + " is NOT a resident of " + name + '.');
      return false;
    }
  }

  /**
   * Getter to check if a house has a dining room
   * @return - boolean if a house has a dining room 
   */
  public boolean getHasDiningRoom(){
    //If a house has a dining room,
    if (hasDiningRoom){
      //Print that it has a dining room
      System.out.println(name + " has a dining room.");
    } else{ //If not,
      //Print that it does not have a dining room
      System.out.println(name + " does not have a dining room.");
    }
    //Return boolean
    return hasDiningRoom;
  }

  /**
   * Method to get the number of residents in a house
   * @return - int of the number of residents
   */
  public int nResidents(){
    //Print and return the number of residents
    System.out.println(name + " has " + residents.size() + " residents.");
    return residents.size();
  }

  public static void main(String[] args) {
    House duckettHouse = new House("Duckett House", "41 Elm Street, Northampton, MA", 4, true); //Create a house
    System.out.println(duckettHouse); //Print information about Duckett House
    //Move in residents
    duckettHouse.moveIn("Lucy");
    duckettHouse.moveIn("Hala");
    duckettHouse.moveIn("Nellie");
    duckettHouse.moveIn("Becca");
    duckettHouse.moveIn("Amber");
    //Print number of residents
    duckettHouse.nResidents();
    //Print if Duckett has a dining room
    duckettHouse.getHasDiningRoom();
    //Check if Becca is a resident
    duckettHouse.isResident("Becca");
    //Move out Hala
    duckettHouse.moveOut("Hala");
    //Check number of residents
    duckettHouse.nResidents();
    //Check if Hala is a resident
    duckettHouse.isResident("Hala");
  }

}