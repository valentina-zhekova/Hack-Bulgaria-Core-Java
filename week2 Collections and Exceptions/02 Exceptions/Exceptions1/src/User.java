public class User {
    private String username;

    public User(String username) {
        this.setUsername(username);
    }

    public void setUsername(String username)  {
        if (username != "\"\"") {
            this.username = username;
        } else {
            throw new DatabaseCorruptedException("username", username);
        }
    }
    
    public String getUsername() {
        return this.username;
    }

    public static void main(String[] args) {
        try {
            User first = new User("Kosta");
            System.out.println(first.getUsername());
            User second = new User("\"\"");
            System.out.println(second.getUsername());
        } catch (DatabaseCorruptedException e) {
            System.out.println(e.message());
            e.printStackTrace();
        }
    }

}
