import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

class Restaurant {
    private String name;
    private String cuisine;
    private double rating;
    private double distance;
    private double wait;
    private String cost;
    private String hours;
    // private fields
    public Restaurant(String name, String cuisine, double rating, double distance, double wait, String cost, String hours) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
        this.distance = distance;
        this.wait = wait;
        this.cost = cost;
        this.hours = hours;
    }
    //setting fields if object is initialized with proper args
    public String getName() {
        return name;
    }
    //getting name via method
    public void setName(String name) {
        this.name = name;
    }
    //setting name via method
    public String getCuisine() {
        return cuisine;
    }
    //getting cuisine via method
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    //setting cuisine via method
    public double getRating() {
        return rating;
    }
    //getting rating via method
    public void setRating(double rating) {
        this.rating = rating;
    }
    //setting rating via method
    public String toString() {
        return ("Restaurant: "+this.name+"\n  Cuisine: "+this.cuisine+"\n  Rating: "+this.rating+" / 5.0\n  Distance: "+this.distance+" miles\n  Wait time: "+this.wait+" minutes\n  Cost: "+this.cost+"\n  Hours: "+this.hours);
    }
    //method for returning a neatly formated string when object is called in main method
}



public class RestaurantApp {
    public static void randRestaurant(ArrayList <Restaurant> a, Random b ) {

        int randNum = b.nextInt(0,a.size()-1) ;
        System.out.println(a.get(randNum));
    }

    public static void restauranttextinput(String filename, ArrayList <Restaurant> a ) {
        Scanner textscanner = new Scanner(RestaurantApp.class.getResourceAsStream(filename));
        // used getResourceAsStream rather than creating a new file object 
        textscanner.useDelimiter(",");
        int restnum = 0;
        try {
            while (textscanner.hasNextLine()){
                String name1 = textscanner.next() ;
                double rating1 = textscanner.nextDouble() ;
                double dist1 = textscanner.nextDouble() ;
                double wait1 = textscanner.nextDouble() ;
                String cost1 = "$" + textscanner.next() ;
                String hours1 = textscanner.next() ;
                String cuisine1 = "N/A" ;
                Restaurant restaurant = new Restaurant(name1, cuisine1, rating1, dist1, wait1, cost1, hours1 ) ;
                a.add(restaurant);
                System.out.println(a.get(restnum));
                restnum ++ ;
            }
        } catch (NoSuchElementException e) {
        }
        textscanner.close();
    }
    public static void main(String[] args) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        restauranttextinput("rest_text.txt", restaurants) ;

        Random randomRest = new Random();
        // instantiating a random object

        Scanner scanner = new Scanner(System.in);
        // create a new scanner and arraylist to hold restaurant objects

        mainloop: while (true) {
            System.out.print("Enter restaurant name (e.g., Bistro Bella): ");
            String name = scanner.nextLine();

            System.out.print("Enter cuisine type (e.g., Italian): ");
            String cuisine = scanner.nextLine();

            System.out.print("Enter rating on a 0-5 scale (e.g., 4.5): ");
            double rating = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter a distance (miles) to the restaurant (e.g., 2.1): ");
            double distance = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter the average wait (minutes) (e.g., 7): ");
            double wait = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter the averagae cost of a meal (e.g., 8.2): $");
            String cost = "$"+ (scanner.nextLine());

            System.out.print("Enter the hours of operation (e.g., 10:00am-6:00pm): ");
            String hours = (scanner.nextLine());


            Restaurant restaurant = new Restaurant(name, cuisine, rating, distance, wait, cost, hours);
            restaurants.add(restaurant);
            //added new fields corresponding the txt doc

            System.out.println("\nAdded Restaurant:");
            System.out.println(restaurants.get(restaurants.size()-1));
            // Prompt user for restaurant fields, then add new restaurant object to array list and print out restaurant in nice format

            loop: while (true) {
                // main loop so that new restaurants can be created
                System.out.println("To get a existing restaurants name, cuisine,rating, press 1.\n" +
                        "To change a existing restaurants name, cuisine or rating, type 2. \nTo exit, type 3.\nTo create a new restaurant, type 4." +
                        "To get a random restaurant, type 5.");
                int treePrompt = Integer.parseInt(scanner.nextLine());
                switch (treePrompt) {
                    // switch prompt tree to ask user if they want to create new restaurant, view or modify existing restaurants fields, or quit program.
                    case 1:
                        System.out.println("Which restaurant would you like to get? Type the number of the displayed restaurants. Current restaurants:");

                        for (int i = 0; i <= restaurants.size()-1; i++) {
                            System.out.println(i + ")" + restaurants.get(i).getName());
                        }
                        int restSelect2 = Integer.parseInt(scanner.nextLine());

                        System.out.println("To get name, press 1. To get cuisine, press 2. To get rating, press 3.");
                        int setPrompt = Integer.parseInt(scanner.nextLine());

                        switch (setPrompt) {
                            case 1:
                                System.out.println(restaurants.get(restSelect2).getName());
                                break;
                            case 2:
                                System.out.println(restaurants.get(restSelect2).getCuisine());
                                break;
                            case 3:
                                System.out.println(restaurants.get(restSelect2).getRating());
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Which restaurant would you like to modify? Type the number of the displayed restaurants. Current restaurants:");
                        for (int i = 0; i <= restaurants.size()-1; i++) {
                            System.out.println(i + ")" + restaurants.get(i).getName());
                        }

                        int restSelect = Integer.parseInt(scanner.nextLine());
                        System.out.println("To set name, press 1. To set cuisine, press 2. To set rating, press 3.");
                        int getPrompt = Integer.parseInt(scanner.nextLine());

                        switch (getPrompt) {
                            case 1:
                                System.out.println("Enter a new name: ");
                                String newname = scanner.nextLine();
                                restaurants.get(restSelect).setName(newname);
                                break;
                            case 2:
                                System.out.println("Enter a new cuisine: ");
                                String newcuisine = scanner.nextLine();
                                restaurants.get(restSelect).setCuisine(newcuisine);
                                break;
                            case 3:
                                System.out.println("Enter a new rating: ");
                                Double newrating = scanner.nextDouble();
                                restaurants.get(restSelect).setRating(newrating);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        break mainloop;
                        // exits program
                    case 4:
                        break loop;
                        // exits choice tree to get back to restaurant creation
                    case 5:
                        randRestaurant(restaurants, randomRest);
                        break;
                        // gets and prints a random restaurant
                    default:
                        break;
                        // if the user enters an invalid answer
                }
            }
        }
        scanner.close();
    }
}