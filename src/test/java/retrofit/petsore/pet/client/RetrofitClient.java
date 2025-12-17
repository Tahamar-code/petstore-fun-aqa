package retrofit.petsore.pet.client;

import okhttp3.MultipartBody;
import retrofit.petsore.pet.model.Pet;
import retrofit.petsore.pet.model.UploadImageResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitClient {

    @POST("pet")
    Call<Pet> createPet(@Body Pet pet);


    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<UploadImageResponse> uploadPetImage(@Path("petId") int petId, @Part MultipartBody.Part file);
}
