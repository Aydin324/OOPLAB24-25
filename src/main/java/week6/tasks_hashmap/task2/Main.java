package week6.tasks_hashmap.task2;

public class Main {
    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);
        mattisNote.setLoan("Arto", 0.5);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("f"));
    }
}
