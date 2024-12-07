package week10.task3_events;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

enum EventType{
    LOGIN, LOGOUT, PURCHASE, VIEWPAGE, ERROR
}

public class Main {
    public static void main(String[] args) throws IOException {
        generateEventsFile("test374879.txt", 15);
        printEventsFromFile("test374879.txt");
    }

    public static void generateEventsFile(String filename, int numOfRecords) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        Random random = new Random();

        LocalDateTime randomTimestamp;
        String formattedTimestamp;
        EventType[] eventTypes = EventType.values();
        String randomEventType;
        String randomUserId;
        String event;

        for(int i=0; i<numOfRecords; i++){
            //generate new random data
            randomTimestamp = LocalDateTime.now()
                    .minusDays(random.nextInt(365)) // Randomize within the last year
                    .minusHours(random.nextInt(24))
                    .minusMinutes(random.nextInt(60))
                    .minusSeconds(random.nextInt(60));
            formattedTimestamp = randomTimestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            randomEventType = eventTypes[random.nextInt(eventTypes.length)].name();
            randomUserId = String.valueOf(random.nextInt(1000));
            event = formattedTimestamp + " | Event type: " + randomEventType + " | UserID: " + randomUserId;

            bw.write(event + "\n");
        }

        bw.close();
    }

    public static void printEventsFromFile(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static ArrayList<String> readEventsFromFile(String filename){
        ArrayList<String> events = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null){
                events.add(line);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }

        return events;
    }
}
