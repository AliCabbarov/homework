package proxyPattern;

public class Proxy implements User{
    private User user;
    private boolean isAdmin;
    private static String[][] users;
    static {
        users = new String[][]{
                {"srthealik","admin"},
                {"Ali","user"},
                {"rahim","admin"},
                {"leyla","user"}
        };
    }



    public Proxy(String username ){
         this.isAdmin = isUserAdmin(username);
    }

    private boolean isUserAdmin(String username) {
        boolean isTrue =  false;
        for (int i = 0; i < users.length; i++) {
            if(users[i][0].equals(username)){
                isTrue = true;
                if(users[i][1].equals("admin")){
                    return true;
                }
            }
            
        }
        if(!isTrue) throw new RuntimeException("user not found!!!");
        return false;
    }

    @Override
    public void create() {
        if(isAdmin){
            new Admin().create();
        }else new RealUser().create();

    }

    @Override
    public void update() {

        if(isAdmin){
            new Admin().update();
        }else new RealUser().update();
    }

    @Override
    public void delete() {

        if(isAdmin){
            new Admin().delete();
        }else new RealUser().delete();
    }

    @Override
    public void read() {

        if(isAdmin){
            new Admin().read();
        }else new RealUser().read();
    }
}
