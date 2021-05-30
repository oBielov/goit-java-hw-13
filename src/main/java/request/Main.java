package request;

import lombok.SneakyThrows;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;
import static request.RetrofitConfig.createClient;
import static request.RetrofitConfig.execute;

public class Main {
    @SneakyThrows
    public static void main(String[] args){
        RetrofitClient client = createClient("http://jsonplaceholder.typicode.com",
                RetrofitClient.class);

//        List<User> userByName = execute(client.getUserByName("Bret"));
//        System.out.println(userByName);
//
//        User newUser = Utils.CreateNewUser();
//
//        User createUser = execute(client.userCreate(newUser));
//        System.out.println(createUser);
//
//        User userToUpdate = execute(client.getUserById(1));
//        System.out.println(userToUpdate);
//
//        execute(client.userDelete(1));
//
//        User updateUser = execute(client.userUpdate(1, userToUpdate));
//        System.out.println(updateUser);
//
//        List<User> allUsers = execute(client.getUsers());
//        System.out.println(allUsers);

        List<Post> userPosts = execute(client.getUserPosts(2));
        //System.out.println(userPosts);

        List<Comments> comments = execute(client.getComments(Utils.getLatestPost(userPosts)));
        //System.out.println(comments);
        Utils.commentsToJson("src/main/resources/comments.json", comments);

    }



}
