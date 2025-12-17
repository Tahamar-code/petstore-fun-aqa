package retrofit.petsore.pet.client;

import retrofit.petsore.pet.model.UploadImageResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitClient {

    @POST("/pet/{petId}/uploadImage")
    Call<UploadImageResponse> uploadImage(@Path("{petId}") int petId);
}
