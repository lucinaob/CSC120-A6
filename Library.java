/* This is a stub for the Library class */

import java.util.Enumeration;
import java.util.Hashtable;

public class Library extends Building {

  //Unique attributes of a library
  private Hashtable<String, Boolean> collection = new Hashtable<>(); //Collection hashtable

  //Library constructor
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors); //Create a building 
    System.out.println("You have built a library: 📖");
  }

  /**
   * Method to add a title
   * @param title - The book being added to the collection
   */
  public void addTitle(String title){
    //If the book is already in the collection,
    if (containsTitle(title)){
      //Print that the book is already in the collection
      System.out.println(title + " is already in the collection and cannot be added.");
    } else{ //If the book isn't,
      //Add it to the Hashtable and print a confirmation method
      collection.put(title, true);
      System.out.println(title + " has been added to the collection!");
    }
  }

  /**
   * Method to remove a title
   * @param title - the book to be removed
   */
  public void removeTitle(String title){
    //If the collection contains the title,
    if (containsTitle(title)){
      //Remove the title and print confirmation
      collection.remove(title);
      System.out.println(title + " has been removed from the collection.");
    } else{ //If the title is not in the collection,
      //Print an error message
      System.out.println(title + " is not in the collection and cannot be removed.");
    }
  }

  /**
   * Method to check out a book
   * @param title - title of the book to be checked out
   */
  public void checkOut(String title){
    //If the book is in the collection,
    if (containsTitle(title)){
      //Check if the book is avaliable
      if (isAvaliable(title)){
        //Change boolean of avaliability from true to false
        collection.replace(title, true, false);
        System.out.println(title + " has been checked out.");
      } else{ //If book is not avaliable
        //Print error message
        System.out.println(title + " is currently checked out.");
      }
    } else{ //If book is not in collection
      //Print error message
      System.out.println(title + " is not in the collection, and cannot be checked out.");
    }
  }

  /**
   * Method to return a book
   * @param title - title of the book to be returned
   */
  public void returnBook(String title){
    //If book is in the collection,
    if (containsTitle(title)){
      //Check if book is checked out
      if (!isAvaliable(title)){ //If it is
        //Change boolean of avaliability from false to true
        collection.replace(title, false, true);
        //Print confirmation method
        System.out.println(title + " has been checked in.");
      } else { //If book is not checked out
        //Print error message
        System.out.println(title + " was not checked out and cannot be checked back in.");
      } } else { //If book is not in collection
        //Print error message
        System.out.println(title + " is not in the collection and cannot be returned.");
    }
  }

  /**
   * Method to check if book is in collection
   * @param title - title of book
   * @return - boolean indicating if book is in the collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * Method to check if book is avaliable
   * @param title - title of book
   * @return - boolean indicating if book is avaliable
   */
  public boolean isAvaliable(String title){
    //Check value of Hashtable for given key (title)
    return collection.get(title).booleanValue();
  }

  /**
   * Method to print the library's collection
   */
  public void printCollection(){
    //Print buffer line
    System.out.println("");
    //Print title of collection
    System.out.println(name.toUpperCase() + "'S COLLECTION: ");
    //Create enumeration of keys in the hashtable
    Enumeration<String> collectionList = collection.keys();
    if (collection.isEmpty()){     //Print message if collection is empty
        System.out.println("There are no books in the collection");
    } else{
        while(collectionList.hasMoreElements()) { //For each item in the hashtable collection
          System.out.println(collectionList.nextElement()); //print the book key
      } 
    }
    System.out.println(""); //Print buffer line
}


  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA", 5);
    neilson.addTitle("Free Food for Millionaires by Min Jin Lee");
    neilson.addTitle("Science Studies During the Cold War and Beyond by Elena Aronova");
    neilson.addTitle("Stone Fruit by Lee Lai");
    neilson.addTitle("The Cholera Years by Charles Rosenberg");
    neilson.addTitle("White Horizon by Jen Hill");
    neilson.printCollection();
    neilson.checkOut("Station Eleven by Emily St. John Mandel");
    neilson.checkOut("Stone Fruit by Lee Lai");
    neilson.removeTitle("The Cholera Years by Charles Rosenberg");
    neilson.returnBook("Stone Fruit by Lee Lai");
    neilson.printCollection();
  }
  
  }