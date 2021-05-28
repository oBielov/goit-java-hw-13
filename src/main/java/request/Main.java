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

//    public static User newUser() {
//        return new User.UserBuilder()
//                .id(13)
//                .name("Roman Petrenko")
//                .userName("Romchansky")
//                .email("petrenko.roman@hotmail.com")
//                .address(new Address.AddressBuilder()
//                        .street("St Claude Ave")
//                        .apartment("Apt. 4808")
//                        .city("New Orleans")
//                        .zipcode("704545")
//                        .geo(new Geo.GeoBuilder()
//                                .latitude(29.58)
//                                .longitude(90.06)
//                                .build())
//                        .build())
//                .phoneNumber("+38066666666")
//                .website("https://github.com/Romchansky")
//                .company(new Company.CompanyBuilder()
//                        .name("Sun microsystems")
//                        .catchPhrase("Hello world")
//                        .bs("Java").build())
//                .build();
//
//
//    }
}
