package request;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String apartment;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("geo")
    private Geo geo;

}
