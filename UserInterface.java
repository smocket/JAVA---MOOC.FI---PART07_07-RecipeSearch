import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class UserInterface {
    private ArrayList<Recipe> listOfRecipes;
    private Scanner scanner;
    
    public UserInterface(Scanner scanner) {
        this.listOfRecipes = new ArrayList<>();
        this.scanner = scanner;
    }
    
    public void start() {
        
        //Reads the fle with recipes with user input
        System.out.println("File to read:");
        String fileName = scanner.nextLine();
        
        try(Scanner file = new Scanner(Paths.get(fileName))) {
            
            //Reads every line in the fil and creates Recipe objects with the informations
            while(file.hasNextLine()) {
                String name = file.nextLine();
                int time = Integer.valueOf(file.nextLine());
                Recipe recipe = new Recipe(name, time);

                //Adds ingredients to recipes
                while(file.hasNextLine()) {
                    String ingredient = file.nextLine();
                    if(ingredient.equals("")) {
                        break;
                    } else {
                        recipe.addIngredient(ingredient);
                    }
                }
                //Finally adding the recipe to the list
                listOfRecipes.add(recipe);
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Command list
        System.out.println("Commands:" + "\n" +
                "list - lists the recipes" + "\n" +
                "stop - stops the program");
        
        //Reading commands from the user
        while(true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            
            if(command.equals("stop")) { //Quit the prgoram
                break;
                
            }else if(command.equals("list")) { //Prints all recipes
                for(int i = 0; i < listOfRecipes.size(); i++) {
                    System.out.println(listOfRecipes.get(i));
                }
                
                //Prints recipes that contain the entered String in their name
            }else if(command.equals("find name")) {
                System.out.println("Searched word:");
                String word = scanner.nextLine();
                
                for(int i = 0; i < listOfRecipes.size(); i++) {
                    if(listOfRecipes.get(i).getName().contains(word)){
                        System.out.println(listOfRecipes.get(i));
                    }
                }
                
                //Prints recipes with a cooking time less the the one specified by the user
            }else if(command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int time = Integer.valueOf(scanner.nextLine());
                
                for(int i = 0; i < listOfRecipes.size(); i++) {
                    if(listOfRecipes.get(i).getTime() <= time) {
                        System.out.println(listOfRecipes.get(i));
                    }
                }
            
            //Prints recipes that contain the specified ingredient
            }else if(command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();
                
                for(int i = 0; i < listOfRecipes.size(); i++) {
                    if(listOfRecipes.get(i).getIngredients().contains(ingredient)) {
                        System.out.println(listOfRecipes.get(i));
                    }
                }
            }
        }  
    }
}
