package DataPackage;
import com.github.javafaker.Faker;

public interface DataObject {
    Faker faker = new Faker();
    String
            email = "anukigochashvili@gmail.com",
            password = "komkom@123",
            wrongEmail = faker.bothify("?????????###@gmail.com");


}
