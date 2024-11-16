package midterm_preparation.task1_restaurant;

import com.mysql.cj.xdevapi.Table;

import java.util.Date;
import java.util.HashMap;

public class TableReservation<T extends MenuItem & Billable> {
    private String reservationId;
    Date reservationDate;
    HashMap<T, Integer> orderedItems = new HashMap<>();
    int tableNumber;

    public TableReservation(String reservationId, Date reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
    }

    public void addItemToOrder(T item, int quantity){
        orderedItems.put(item, quantity);
    }

    public double calculateTotalAmount(){
        double total = 0;
        for(T t : orderedItems.keySet()){
            total += orderedItems.get(t)*t.getPrice();
        }
        return total;
    }

    //setters and getters
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public HashMap<T, Integer> getOrderedItems() {
        return orderedItems;
    }
    public void setOrderedItems(HashMap<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
