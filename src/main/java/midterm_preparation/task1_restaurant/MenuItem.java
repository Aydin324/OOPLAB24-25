package midterm_preparation.task1_restaurant;

public abstract class MenuItem implements Billable{
    private String code;
    private String name;
    private double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public double applyDiscount(double discountRate){
        return price*(1-discountRate);
    }

    public String getDescription(){
        return "Code: " + code + "\nName: " + name + "\nPrice: " + price;
    }

    //setters and getters
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
