import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class UserInterface {
    private ArrayList<Recipe> listOfRecipes;
    private Scanner scanner;
    
    public UserInterface() {
        this.listOfRecipes = new ArrayList<>();
        this.scanner = scanner;
    }
    
    public void start() {
        
        System.out.println("File to read:");
        String fileName = scanner.nextLine();
        
        try(Scanner file = new Scanner(Paths.get(fileName))) {
            
            while(file.hasNextLine()) {
                String name = file.nextLine();
                int time = Integer.valueOf(file.nextLine());
                Recipe recipe = new Recipe(name, time);

                while(file.hasNextLine()) {
                    String ingredient = file.nextLine();
                    if(ingredient.equals("")) {
                        break;
                    } else {
                        recipe.addIngredient(ingredient);
                    }
                }
                listOfRecipes.add(recipe);
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        
        System.out.println("Commands:" + "\n" +
                "list - lists the recipes" + "\n" +
                "stop - stops the program");
        
        while(true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            
            if(command.equals("list")) {
                for(int i = 0; i < listOfRecipes.size(); i++) {
                    System.out.println(listOfRecipes.get(i).toString());
                }
            }
            
        }
        
    }
}
