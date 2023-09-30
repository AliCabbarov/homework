package Singleton;

public class User {
    private static User user = null;


    public static User getInstance(){
        if(user == null){
            user = new User();
        }
        return user;                                  //SINGLETON PATTERN
    }
    private User(){
        System.out.println("Object created");
    }

}
