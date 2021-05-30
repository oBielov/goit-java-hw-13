package request;

import lombok.SneakyThrows;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args){

        List<User> userByName = Utils.getUserByName("Bret");
        System.out.println(userByName);

        User newUser = Utils.createUser();
        System.out.println(newUser);

        User updateUser = Utils.updateUser(1);
        System.out.println(updateUser);

        Utils.deleteUser(1);

        List<User> allUsers = Utils.getAllUsers();
        System.out.println(allUsers);

        Utils.commentsToJson(2);

        List<Todos> openTodos = Utils.getOpenTodos(1);
        System.out.println(openTodos);
    }



}
