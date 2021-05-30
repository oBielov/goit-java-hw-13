package request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Comments {

    @SerializedName("postId")
    public Integer postId;

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("body")
    public String body;

}
