package request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Todos {

    @SerializedName("userId")
    public Integer userId;

    @SerializedName("id")
    public Integer id;

    @SerializedName("title")
    public String title;

    @SerializedName("completed")
    public Boolean completed;

}
