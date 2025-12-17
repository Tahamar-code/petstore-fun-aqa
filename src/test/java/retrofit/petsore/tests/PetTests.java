package retrofit.petsore.tests;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;
import retrofit.petsore.pet.client.RetrofitClient;
import retrofit.petsore.pet.model.Pet;
import retrofit.petsore.pet.model.UploadImageResponse;
import retrofit.petsore.utils.PetFactoryUtils;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static retrofit.petsore.config.PetsoreConfig.BASE_URL;

public class PetTests {

    private final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                            .addConverterFactory(JacksonConverterFactory.create())
                                                            .build();

    private final RetrofitClient client = retrofit.create(RetrofitClient.class);

    @Test
    void uploadImageShouldBe_Success() throws IOException {

        Pet testPet = PetFactoryUtils.randomPet();

        Response<Pet> createResponse = client.createPet(testPet).execute();

//
        File file = new File(getClass().getClassLoader()
                                       .getResource("spunch.jpg")
                                       .getFile());

        MultipartBody.Part part = MultipartBody.Part.createFormData("file",
                                                                    file.getName(),
                                                                    RequestBody.create(MediaType.parse("image/jpeg"),
                                                                                       file));

        Response<UploadImageResponse> response = client.uploadPetImage(testPet.getId(), part)
                                                       .execute();

        assertThat(response.isSuccessful()).isTrue();


    }



    @Test
    void createPetShouldBe_Success() throws IOException {
        Pet testPet = PetFactoryUtils.randomPet();

        Response<Pet> response = client.createPet(testPet).execute();

        int x = 0;

        assertThat(response.isSuccessful()).isTrue();
        System.out.println(response.body());
        assertThat(response.body()).isEqualTo(testPet);


    }
}
