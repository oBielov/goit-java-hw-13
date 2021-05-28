package request;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    @SerializedName("name")
    public String name;

    @SerializedName("catchPhrase")
    public String catchPhrase;

    @SerializedName("bs")
    public String bs;
}
