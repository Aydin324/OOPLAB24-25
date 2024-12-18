    package quiz_practice_december_test;

    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import practice.quiz_practice_december.User;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    public class UserTest {
        private static User user;

        @BeforeAll
        public static void setUp(){
            user = new User("Aydin2", "abcde", 99, "some@email");
            user.writeToFile();
        }

        @Test
        public void checkIfFileContainsExactlyTwoLines(){
            try(BufferedReader br = new BufferedReader(new FileReader("userDetails.txt"))){
                int counter = 0;
                String line;
                while((line=br.readLine())!=null){
                    counter++;
                    if(counter==1){
                        assertEquals(user.getUsername(), line, "Data should match name and pass only.");
                    } else if(counter==2){
                        assertEquals(user.getPassword(), line, "Data should match name and pass only.");
                    }
                }
                assertEquals(2, counter, "There should be exactly two lines in the file");

            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }
