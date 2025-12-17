package retrofit.petsore.utils;

import com.github.javafaker.Faker;
import retrofit.petsore.pet.model.Category;
import retrofit.petsore.pet.model.Pet;
import retrofit.petsore.pet.model.Tag;

import java.util.List;
import java.util.Random;

public class PetFactoryUtils {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Pet randomPet() {
        return new Pet(
                faker.number().numberBetween(1, 10_000),
                randomCategory(),
                faker.animal().name(),
                List.of(faker.internet().image()),
                List.of(randomTag()),
                randomStatus()
        );

    }

    public static Pet randomPetWithoutName() {
        return new Pet(
                faker.number().numberBetween(1, 10_000),
                randomCategory(),
                null,
                List.of(faker.internet().image()),
                List.of(randomTag()),
                randomStatus()
        );



    }

    public static Pet randomPetWithInvalidStatus() {
        return new Pet(
                faker.number()
                     .numberBetween(1, 10_000),
                randomCategory(),
                faker.animal().name(),
                List.of(faker.internet()
                             .image()),
                List.of(randomTag()),
                invalidStatus()
        );
    }
    private static Category randomCategory() {
        return new Category(
                faker.number().numberBetween(1, 1000),
                faker.animal().name()
        );
    }

    private static Tag randomTag() {
        return new Tag(
                faker.number().numberBetween(1, 1000),
                faker.lorem().word()
        );
    }

    private static String randomStatus() {
        return List.of("available", "pending", "sold")
                   .get(random.nextInt(3));
    }

    private static String invalidStatus(){
        return "invalid";
    }
}
