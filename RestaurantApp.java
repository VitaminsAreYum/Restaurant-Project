import java.util.ArrayList;
import java.util.Scanner;

class Restaurant {
    private String name;
    private String cuisine;
    private double rating;
    // private fields
    public Restaurant(String name, String cuisine, double rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
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
        return ("Restaurant: "+this.name+"\n  Cuisine: "+this.cuisine+"\n  Rating: "+this.rating+" / 5.0");
    }
    //method for returning a neatly formated string when object is called in main method
}



public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        // create a new scanner and arraylist to hold restaurant objects
        mainloop: while (true) {
            System.out.print("Enter restaurant name (e.g., Bistro Bella): ");
            String name = scanner.nextLine();

            System.out.print("Enter cuisine type (e.g., Italian): ");
            String cuisine = scanner.nextLine();

            System.out.print("Enter rating on a 0-5 scale (e.g., 4.5): ");
            double rating = Double.parseDouble(scanner.nextLine());

            Restaurant restaurant = new Restaurant(name, cuisine, rating);
            restaurants.add(restaurant);

            System.out.println("\nAdded Restaurant:");
            System.out.println(restaurants.get(0));
            // Prompt user for restaurant fields, then add new restaurant object to array list and print out restaurant in nice format

            loop: while (true) {
                // main loop so that new restaurants can be created
                System.out.println("To get a existing restaurants name, cuisine,rating, press 1.\n" +
                        "To change a existing restaurants name, cuisine or rating, type 2. \nTo exit, type 3.\nTo create a new restaurant, type 4.");
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
                    default:
                        break;
                        // if the user enters an invalid answer
                }
            }
        }
        scanner.close();
    }
}