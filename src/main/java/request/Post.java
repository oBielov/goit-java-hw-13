package request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Post {

    @SerializedName("userId")
    public Integer userId;

    @SerializedName("id")
    public Integer id;

    @SerializedName("title")
    public String title;

    @SerializedName("body")
    public String body;

}
