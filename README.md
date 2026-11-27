# Restaurant-Project
# **Restaurant project part 1**
- **User Interactions**
  - Taking input from the user via a scanner, then parsing the input into a valid data format so that they could interact with the program. The idea behind this was to make it so that someone (aka. a restaurant reviewer) could create a organized list without having to understand the program too deeply. The user was mostly prompted with numbers so that switches could be used for decision making. \
- **Getters and Setters**
  - Creating methods in the restaurant class for getting the info from pre-existing restaurant and modifying restaurant fields after creation since fields are set to private. This is done so that the object is not hard-coded and is safer programming practice so that fields are not as easily modifying.\
- **ArrayList**
  - Creating a array list to hold newly created objects so that modifying and retrieving specific objects after they are created. This is done so access specifics objects can be done with its corresponding index, making it significantly easier to develop in the future.\
- **toString()**
  - adding a toString() method so that the get.(#) method for the array list returns a nicely formatted string so that when printed it is easily read  by the user. \
# **Restaurant project part 2**
- **Scan the text file to create Restaurant objects from the data**
  - Using a scanner to scan the text in the .txt and properly processing each token to create a new restaurant for each set of data. This was done so that a large list of restaurants could be created and saved before running the program so that the user did not have to add all the restaurants each time the program is run.\
- **Add the Restaurants to an ArrayList**
  - Taking the input stream from the text file and adding it to the array list as if a user was entering the data for the restaurant, again for the purpose of saving the user from having to manually create every restaurant object.\
- **Have the program print a random Restaurant object from the list.**
  - Generating a random integer from the 0 to the index size - 1 using the random class and then getting the corresponding element. This is done possibly so that the user could have the program give a random restaurant if they cant make a decision or to test if the program is working correctly.\
- **Organize the tasks into methods**
  - Organized both the scanning text doc and getting random element tasks in to their respective methods in the restaurantapp class, with the scanning text doc taking a string for the file name of the text doc and a array list to hold the new restaurant objects, and the random selector taking a random object and the Arraylist that it would draw from. This is done so that the code is more readable, more easy to build off of if we want to call the method again, and to avoid hard=coding in the main method. 
