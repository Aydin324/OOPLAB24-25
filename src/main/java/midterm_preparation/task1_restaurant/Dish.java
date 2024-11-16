package midterm_preparation.task1_restaurant;

public class Dish extends MenuItem{
    CuisineType cuisineType;
    String mainIngredient;

    public Dish(String code, String name, double price, CuisineType cuisineType, String mainIngredient) {
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription(){
        return "Code: " + getCode() + "\nName: " + getName() + "\nPrice: " + getPrice()
                + "\nCuisine Type: " + cuisineType + "\nMain Ingredient: " + mainIngredient;
    }

    //getters and setters
    public CuisineType getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }
    public String getMainIngredient() {
        return mainIngredient;
    }
    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }
}
