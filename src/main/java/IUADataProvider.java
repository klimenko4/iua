import org.testng.annotations.DataProvider;

public class IUADataProvider {

    public static class RegisteredUsersDataProvider {
        @DataProvider (name = "getRegisteredUsersData")
        public static Object[][] getData() {
            return new Object[][]{
                    {"logintest1@i.ua", "123456A"},
                    {"logintest2@i.ua", "123456A"},
                    {"logintest3@i.ua", "123456A"}
            };
        }
    }
}
