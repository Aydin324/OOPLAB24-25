package week15;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//enums
enum TextFormat{
    CAPITALIZE, LOWER, PLAIN
}
enum CurrencyFormat{
    USD, EURO, INR
}

//custom annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat{
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}

//custom exception
class InvalidInvoiceException extends RuntimeException{
    public InvalidInvoiceException(String message){
        super(message);
    }
    public InvalidInvoiceException(String message, Throwable cause){
        super(message, cause);
    }
}

//invoice class
class Invoice{
    private Date invoiceDate;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;
    private int qtr;
    private int year;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;
    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;
    @FieldFormat(currency_format = CurrencyFormat.EURO)
    private double taxAmount;
    private double netAmount;

    //constructor
    public Invoice(InvoiceBuilder ib){
        this.invoiceDate = ib.invoiceDate;
        this.invoiceNumber = ib.invoiceNumber;
        this.totalAmount = ib.totalAmount;
        this.year = ib.year;
        this.qtr = ib.qtr;
        this.customerName = ib.customerName;
        this.taxAmount = ib.taxAmount;
        this.netAmount = ib.netAmount;
    }

    //toString
    @Override
    public String toString(){
        return this.invoiceNumber + " " + this.invoiceDate + " " + this.totalAmount;
    }

    //static inner class
    public static class InvoiceBuilder{
        private Date invoiceDate;
        @FieldFormat(text_format = TextFormat.CAPITALIZE)
        private String invoiceNumber;
        private int qtr;
        private int year;
        @FieldFormat(text_format = TextFormat.CAPITALIZE)
        private String customerName;
        @FieldFormat(currency_format = CurrencyFormat.USD)
        private double totalAmount;
        @FieldFormat(currency_format = CurrencyFormat.EURO)
        private double taxAmount;
        private double netAmount;

        public InvoiceBuilder(){}

        public InvoiceBuilder setInvoiceDate(Date invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }
        public InvoiceBuilder setInvoiceNumber(String number){
            this.invoiceNumber = number;
            return this;
        }
        public InvoiceBuilder setQtr(int qtr){
            this.qtr = qtr;
            return this;
        }
        public InvoiceBuilder setYear(int year){
            this.year = year;
            return this;
        }
        public InvoiceBuilder setCustomerName(String name){
            this.customerName = name;
            return this;
        }
        public InvoiceBuilder setTotalAmount(double amount){
            this.totalAmount = amount;
            return this;
        }
        public InvoiceBuilder setTaxAmount(double amount){
            this.taxAmount = amount;
            return this;
        }
        public InvoiceBuilder setNetAmount(double amount){
            this.netAmount = amount;
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }

}

//data loading
class InvoiceProcessor{
    private static List<Invoice> invoices = new ArrayList<>();

    public static List<Invoice> loadInvoices(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            List<String> rows = br.lines().collect(Collectors.toList());
            for(int i=1; i<rows.size(); i++){
                String[] attributes = rows.get(i).split(",");
                if(attributes[0]==null || attributes[1]==null || attributes[5]==null){
                    throw new InvalidInvoiceException("Missing required field", new ClassCastException());
                }
                //invoiceDate,invoiceNumber,qtr,year,customerName,totalAmount,taxAmount,netAmount
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                invoices.add(new Invoice.InvoiceBuilder()
                        .setInvoiceDate(sdf.parse(attributes[0]))
                        .setInvoiceNumber(attributes[1])
                        .setQtr(Integer.parseInt(attributes[2]))
                        .setYear(Integer.parseInt(attributes[3]))
                        .setCustomerName(attributes[4])
                        .setTotalAmount(Double.parseDouble(attributes[5]))
                        .setTaxAmount(Double.parseDouble(attributes[6]))
                        .setNetAmount(Double.parseDouble(attributes[7]))
                        .build()
                );
            }
        } catch(IOException | ParseException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }

        return invoices;
    }

    public static List<Invoice> getInvoices() {
        return invoices;
    }
}

//data writing
class CSVReportGenerator{
    public static void generateReport(String outputFileName, List<Invoice> invoices){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))){
            //get Invoice class fields
            Field[] fields = Invoice.class.getDeclaredFields();

            //write header
            for(int i=0; i<fields.length; i++){
                fields[i].setAccessible(true);
                bw.write(
                        i!=fields.length-1 ?
                                fields[i].getName().concat(",") :
                                fields[i].getName().concat("\n")
                );
            }

            //write values
            for(Invoice invoice : invoices){
                for(int i=0; i<fields.length; i++){
                    if(fields[i].isAnnotationPresent(FieldFormat.class) && fields[i].get(invoice) instanceof String){
                        switch(fields[i].getAnnotation(FieldFormat.class).text_format()){
                            case LOWER -> bw.write(
                                    i!=fields.length-1 ?
                                            fields[i].get(invoice).toString().toLowerCase().concat(",") :
                                            fields[i].get(invoice).toString().toLowerCase().concat("\n")
                            );
                            case CAPITALIZE -> {
                                String a = fields[i].get(invoice).toString();
                                String str = "";
                                str.concat(a.substring(0,1).toUpperCase());
                                str.concat(a.substring(1));
                                bw.write(
                                        i!= fields.length-1 ?
                                                a.concat(",") :
                                                a.concat("\n")
                                );
                            }
                            case PLAIN -> bw.write(
                                    i!=fields.length ?
                                            fields[i].get(invoice).toString().concat(",") :
                                            fields[i].get(invoice).toString().concat("\n")
                            );
                        }
                    } else if(fields[i].isAnnotationPresent(FieldFormat.class)){
                        switch(fields[i].getAnnotation(FieldFormat.class).currency_format()){
                            case USD -> bw.write(
                                    i!=fields.length-1 ?
                                            "$"+fields[i].get(invoice).toString().concat(",") :
                                            "$"+fields[i].get(invoice).toString().concat("\n")
                            );
                            case EURO -> bw.write(
                                    i!=fields.length-1 ?
                                            "€".concat(fields[i].get(invoice).toString().concat(",")) :
                                            "€".concat(fields[i].get(invoice).toString().concat("\n"))
                            );
                            case INR -> bw.write(
                                    i!=fields.length-1 ?
                                            "₹".concat(fields[i].get(invoice).toString().concat(",")) :
                                            "₹".concat(fields[i].get(invoice).toString().concat("\n"))
                            );
                        }
                    } else if(fields[i].get(invoice) instanceof Date){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        bw.write(
                                i!=fields.length-1 ?
                                        sdf.format(fields[i].get(invoice)).concat(",") :
                                        sdf.format(fields[i].get(invoice)).concat("\n")
                        );
                    } else {
                        bw.write(
                                i!= fields.length-1 ?
                                        fields[i].get(invoice)+"," :
                                        fields[i].get(invoice)+"\n"
                        );
                    }
                }
            }
        } catch(IOException | IllegalAccessException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
        System.out.println("Report generated!");
    }
}

public class InvoiceManagementSystem {
    public static void main(String[] args){
        List<Invoice> invoices = InvoiceProcessor.loadInvoices("invoice-sample-csv.csv");
        CSVReportGenerator.generateReport("invoice-sample-report.csv", invoices);
    }
}
