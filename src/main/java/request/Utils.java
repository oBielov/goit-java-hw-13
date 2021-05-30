package request;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private final String FILEPATH = "src/main/resources/";


    public static User CreateNewUser() {
        return new User.UserBuilder()
                .id(13)
                .name("Freddy Krueger")
                .userName("Bladerunner")
                .email("sweet.dreams@horrormail.com")
                .address(new Address.AddressBuilder()
                        .street("Elm street")
                        .apartment("1428")
                        .city("Springfield")
                        .zipcode("000000")
                        .geo(new Geo.GeoBuilder()
                                .latitude(-30.25)
                                .longitude(150.55)
                                .build())
                        .build())
                .phoneNumber("00 0 000-00-00")
                .website("https://horror.fandom.com/wiki/Freddy_Krueger_(original_timeline)")
                .company(new Company.CompanyBuilder()
                        .name("Dreamland")
                        .catchPhrase("Every Town Has An Elm Street!")
                        .bs("CutCutChopChop").build())
                .build();


    }

    public static Integer getLatestPost(List<Post> posts){

        Integer postId = 0;

        for (Post post : posts){
            if(post.getId() > postId) postId = post.getId();
        }
        return postId;

    }

    @SneakyThrows
    public static void commentsToJson(String filepath, List<Comments> comments){

        Gson gson = new Gson();
        List<String> commentBodies = new ArrayList<>();
        for (Comments comment : comments){
            commentBodies.add(comment.getBody());
        }
        System.out.println(commentBodies);
        gson.toJson(commentBodies, new FileWriter(filepath));

    }

}
