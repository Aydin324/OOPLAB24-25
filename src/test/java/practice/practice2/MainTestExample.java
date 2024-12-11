package practice.practice2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static practice.practice2.Main.toDoubleTransformAdd;

class MainTestExample {
    @Test
    public void fiveTransformDouble_ReturnsFiveAndHalf(){
        assertEquals(5.50, toDoubleTransformAdd(4), "Test has not returned correct value.");
    }

}