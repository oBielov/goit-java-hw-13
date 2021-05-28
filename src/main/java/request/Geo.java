package request;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Geo {

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lgn")
    private double longitude;

}
