package request;

import java.io.IOException;
import java.util.List;
import static request.RetrofitConfig.createClient;
import static request.RetrofitConfig.execute;

public class Main {
    public static void main(String[] args) throws IOException {
        RetrofitClient client = createClient("http://jsonplaceholder.typicode.com",
                RetrofitClient.class);

        List<User> result = execute(client.getUsers());
        for (User user : result) System.out.println(user.getCompany().getName());
    }
}
