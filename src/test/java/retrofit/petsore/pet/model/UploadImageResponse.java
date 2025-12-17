package retrofit.petsore.pet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadImageResponse {

    private int code;

    private String type;

    private String message;
}


