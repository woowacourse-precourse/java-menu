package menu.model;



import org.junit.jupiter.api.Test;

class GenerateRandomNumberTest {

    @Test
    void setRandomNumbers_TEST() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        generateRandomNumber.setRandomNumbers();
        System.out.println(generateRandomNumber.getRandomNumbers());
    }
}