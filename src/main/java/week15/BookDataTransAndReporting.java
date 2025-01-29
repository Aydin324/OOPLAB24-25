package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//enums
enum CaseFormatter{
    ORDINARY, UPPER_CASE, LOWER_CASE
}
enum NumberFormatter{
    COMMA, PERCENTAGE
}

//custom annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteConcerns{
    public CaseFormatter case_format() default CaseFormatter.ORDINARY;
    public NumberFormatter number_format() default NumberFormatter.COMMA;
}

//custom exception
class WrongFormatException extends RuntimeException{
    public WrongFormatException(String message){
        super(message);
    }
    public WrongFormatException(String message, Throwable cause){
        super(message, cause);
    }
}

//Data loading
class FinalPrep{
    private static List<Book> books = new ArrayList<>();
    //read books from file
    public static void loadBooks(String filename){
        try(BufferedReader rd = new BufferedReader(new FileReader(filename))){
            List<String> rows = new ArrayList<>(rd.lines().collect(Collectors.toList()));
            for(int i=1; i<rows.size(); i++){
                String[] args = rows.get(i).split(",");
                Book.BookBuilder bb = new Book.BookBuilder();
                if (args[0] != null && args[1] != null && args[2] != null) {
                    bb.setDate(new SimpleDateFormat("yy-MM-dd").parse(args[0]));
                    bb.setCustomerId(args[1]);
                    bb.setTotalAmount(Double.parseDouble(args[2]));
                } else {
                    throw new WrongFormatException("Values are empty", new ClassCastException());
                }
                bb.setQuarter(args[3]);
                bb.setQtr(Integer.parseInt(args[4]));
                bb.setYear(Integer.parseInt(args[5]));
                bb.setProfitPercentage(Double.parseDouble(args[6]));
                bb.setProfitInr(Double.parseDouble(args[7]));
                bb.setCostPrice(Double.parseDouble(args[8]));
                books.add(new Book(bb));
            }
        } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Something went wrong while loading books.");
        }
    }

    public static List<Book> getBooks(){
        return books;
    }
}

//Data writing
class ReportWriter{
    public static void writeReport(String filename, List<Book> books){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            Field[] fields = Book.class.getDeclaredFields();
            //write header
            for(int i=0; i<fields.length-1; i++){
                bw.write(fields[i].getName().concat(","));
            }
            bw.write(fields[fields.length-1].getName().concat("\n"));
            //write books
            for(Book book : books){
                for(int i=0; i<fields.length; i++){
                    fields[i].setAccessible(true);
                    if(fields[i].isAnnotationPresent(WriteConcerns.class)){
                        if(fields[i].get(book) instanceof String){
                            switch(fields[i].getAnnotation(WriteConcerns.class).case_format()){
                                case LOWER_CASE -> {bw.write(
                                            i==fields.length-1 ?
                                                    (fields[i].get(book)).toString().toLowerCase().concat("\n") :
                                                    ((String) fields[i].get(book)).toLowerCase() + ","
                                        );
                                }
                                case UPPER_CASE -> {bw.write(
                                        i==fields.length-1 ?
                                                ((String) fields[i].get(book)).toUpperCase() + "\n" :
                                                ((String) fields[i].get(book)).toUpperCase() + ","
                                );
                                }
                                case ORDINARY -> {bw.write(
                                        i==fields.length-1 ?
                                                ((String) fields[i].get(book)) + "\n" :
                                                ((String) fields[i].get(book)) + ","
                                );
                                }
                            }
                        } else if(fields[i].get(book) instanceof Number) {
                            switch(fields[i].getAnnotation(WriteConcerns.class).number_format()){
                                case COMMA -> {
                                    DecimalFormat df = new DecimalFormat("#,###.##");
                                    df.setGroupingUsed(true);
                                    df.setGroupingSize(3);
                                    DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
                                    dfs.setGroupingSeparator(' '); // Use space instead of comma
                                    df.setDecimalFormatSymbols(dfs);

                                    bw.write(
                                            i != fields.length - 1 ?
                                                    df.format(fields[i].get(book)) + "," :
                                                    df.format(fields[i].get(book)) + "\n"
                                    );
                                }
                                case PERCENTAGE -> {bw.write(
                                        i!=fields.length-1 ?
                                                fields[i].get(book) + "%," :
                                                fields[i].get(book) + "%\n"
                                );
                                }
                            }
                        } else {
                            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                            bw.write(
                                    i!=fields.length-1 ?
                                            sdf.format(fields[i].get(book)) + "," :
                                            sdf.format(fields[i].get(book)) + "\n"
                            );
                        }
                    } else {
                        bw.write(
                                i!=fields.length-1 ?
                                        fields[i].get(book).toString().concat(",") :
                                        fields[i].get(book).toString().concat("\n")
                        );
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class Book{
    @WriteConcerns
    private Date date;
    @WriteConcerns(case_format=CaseFormatter.ORDINARY)
    private String quarter;
    private int qtr;
    private int year;
    @WriteConcerns(case_format=CaseFormatter.UPPER_CASE)
    private String customerId;
    @WriteConcerns(number_format=NumberFormatter.COMMA)
    private double totalAmount;
    @WriteConcerns(number_format=NumberFormatter.PERCENTAGE)
    private double profitPercentage;
    private double profitInr;
    private double costPrice;

    //constructor
    public Book(BookBuilder builder) {
        this.date = builder.date;
        this.quarter = builder.quarter;
        this.qtr = builder.qtr;
        this.year = builder.year;
        this.customerId = builder.customerId;
        this.totalAmount = builder.totalAmount;
        this.profitPercentage = builder.profitPercentage;
        this.profitInr = builder.profitInr;
        this.costPrice = builder.costPrice;
    }

    @Override
    public String toString(){
        return "Date: " + this.date + " | Quarter : " + this.quarter
                + " | qtr: " + this.qtr + " | Year: " + this.year;
    }

    static class BookBuilder{
        private Date date;
        private String quarter;
        private int qtr;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitInr;
        private double costPrice;

        public BookBuilder(){}

        public BookBuilder setDate(Date date){
            this.date = date;
            return this;
        }
        public BookBuilder setQuarter(String quarter){
            this.quarter = quarter;
            return this;
        }
        public BookBuilder setQtr(int qtr){
            this.qtr = qtr;
            return this;
        }
        public BookBuilder setYear(int year){
            this.year = year;
            return this;
        }
        public BookBuilder setCustomerId(String customerId){
            this.customerId = customerId;
            return this;
        }
        public BookBuilder setTotalAmount(double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }
        public BookBuilder setProfitPercentage(double profitPercentage){
            this.profitPercentage = profitPercentage;
            return this;
        }
        public BookBuilder setProfitInr(double profitInr){
            this.profitInr = profitInr;
            return this;
        }
        public BookBuilder setCostPrice(double costPrice){
            this.costPrice = costPrice;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}

public class BookDataTransAndReporting {
    public static void main(String[] args){
        FinalPrep.loadBooks("books-sample-csv.csv");
        ReportWriter.writeReport("books-sample-report.csv", FinalPrep.getBooks());
    }
}