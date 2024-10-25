/* This is a stub for the Cafe class */
public class Cafe extends Building {

    //Unique attributes of a cafe
    //Items in a cafe's inventory (coffee grounds, sugar, cream, cups)
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor of a cafe building
     * @param name - name of the cafe
     * @param address - address of the cafe
     * @param nFloors - floors the building has
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors); //Create a cafe building
        //Initialize the cafe inventory
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 8;
        this.nCreams = 10;
        this.nCups = 12;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method to sell coffee
     * @param size - Size of the coffee being sold
     * @param nSugarPackets - Sugars in the coffee being sold
     * @param nCreams - Creams in the coffee being sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        //If there isn't enough coffee, sugar, or cream to make the coffee bought,
        if (nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
            //Restock the cafe
            this.restock();
            System.out.println("Restocking inventory...");
            //Re-run sell coffee with the same information
            this.sellCoffee(size, nSugarPackets, nCreams);
        } else{ //If there is enough material to make the coffee,
            //Decrease the coffee, sugar, and cream by the amount ordered
            nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            //Remove 1 cup
            this.nCups -= 1;
            System.out.println("One size " + size + " coffee with " + nSugarPackets + " sugar(s) and " + nCreams + " cream(s) sold!");
        }
    }
    
    /**
     * Restock inventory method
     */
    private void restock(){
        //Bring levels of attributes back to default levels
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 8;
        this.nCreams = 10;
        this.nCups = 12;
    }

    /**
     * Print inventory of the cafe
     */
    public void printInventory(){
        //Buffer line
        System.out.println("");
        //Print name of cafe
        System.out.println(name.toUpperCase() + " INVENTORY: ");
        //Print attributes/materials of the cafe
        System.out.println("Coffee Ounces: " + nCoffeeOunces);
        System.out.println("Sugar Packets: " + nSugarPackets);
        System.out.println("Creams: " + nCreams);
        System.out.println("Cups: " + nCups);
        //Buffer line
        System.out.println("");
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "100 Elm Street, Northampton, MA", 3);
        campusCenter.sellCoffee(3, 2, 3);
        campusCenter.sellCoffee(2, 4, 4);
        campusCenter.printInventory();
        campusCenter.sellCoffee(3, 0, 1);
        campusCenter.sellCoffee(2, 1, 3);
        campusCenter.printInventory();
    }
    
}
