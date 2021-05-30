package request;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import static request.RetrofitConfig.createClient;
import static request.RetrofitConfig.execute;

public class Utils {

    private static final String FILEPATH = "src/main/resources/";
    private static final RetrofitClient client = createClient("http://jsonplaceholder.typicode.com",
            RetrofitClient.class);


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
    public static void commentsToJson(Integer userId){

        Gson gson = new Gson();
        List<Post> userPosts = execute(client.getUserPosts(userId));
        Integer latestPostNumber = getLatestPost(userPosts);
        List<Comments> comments = execute(client.getComments(latestPostNumber));
        List<String> commentBodies = new ArrayList<>();
        for (Comments comment : comments){
            commentBodies.add(comment.getBody());
        }
        gson.toJson(commentBodies, new FileWriter(FILEPATH + "user-" + userId + "-post-" + latestPostNumber
                                                  + "-comments.json"));

    }

    public static List<Todos> getOpenTodos(Integer userId){

        List<Todos> allTodos = execute(client.getTodos(userId));
        List<Todos> openTodos = new ArrayList<>();

        for (Todos todo : allTodos) if (!todo.getCompleted()) openTodos.add(todo);

        return openTodos;
    }

    public static List<User> getUserByName(String userName){
        return execute(client.getUserByName(userName));
    }

    public static User createUser(){
        User newUser = Utils.CreateNewUser();
        return execute(client.userCreate(newUser));
    }

    public static User updateUser(Integer userId){
        User userToUpdate = execute(client.getUserById(userId));
        return execute(client.userUpdate(userId, userToUpdate));
    }

    public static void deleteUser(Integer userId){
        execute(client.userDelete(userId));
        System.out.println("User has been deleted");
    }

    public static List<User> getAllUsers(){
        return execute(client.getUsers());
    }





}
