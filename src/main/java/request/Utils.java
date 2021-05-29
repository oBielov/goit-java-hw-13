package request;

public class Utils {


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

}
