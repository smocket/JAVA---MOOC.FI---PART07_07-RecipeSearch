import java.util.ArrayList;

public class Recipe {
    private String name;
    private int time;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int time) {
        this.name = name;
        this.time = time;
        ingredients = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public ArrayList getIngredients() {
        return ingredients;
    }
    
    public String toString() {
        return this.name + ", cooking time: " + this.time;
    }  
}
