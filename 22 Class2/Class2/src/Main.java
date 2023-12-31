import java.util.Scanner;

class User implements equals {
    private String login;
    private String password;
    private String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getInfo() {
        String pass = "";
        for (int i = 0; i < password.length(); i++) {
            pass += "*";
        }
        return this.name + "  ( " + this.login + " " + pass + " ) ";
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Override
    public boolean equals(String login) {
        if (this.login == login) return true;
        if (login == null ) return false;
        return (this.login == login);
    }

}


public class Main {

    static public boolean checkUnikalLogin(User[] users , String login){
        for (int i = 0; i < users.length; i++) {
            if (users[i]!=null &&
                    users[i].equals(login)){
                return  true;
            }
        }

        return false;
    }

    public static User[] changeLogin(User[] users, String login, int user) {
        if (!checkUnikalLogin(users, login)) {
            users[user].setLogin(login);
            System.out.println("Login is edit");
        } else {
            System.out.println("Login is busy");
        }
        return users;
    }

    public static User[] changePass(User[] users, String password, int user) {
        if (!password.equals(users[user].getPassword())) {
            users[user].setPassword(password);
            System.out.println("Password is edit");
        } else {
            System.out.println("Password already in use");
        }
        return users;
    }

    public static User[] changeName(User[] users, String name, int user) {
        if (!name.equals(users[user].getName())) {
            users[user].setName(name);
            System.out.println("Name is edit");
        } else {
            System.out.println("Name already in use");
        }
        return users;
    }

    public static void main(String[] args) {
        String action, name, login, password, repeatPassword;

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        User[] users = new User[10];

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("1 - Sign in");
            System.out.println("2 - Registration");
            System.out.println("3 - Print Users");
            System.out.println("4 - Exit");
            action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println("Sign in");
                scanner = new Scanner(System.in);
                System.out.println("Enter Login : ");
                login = scanner.nextLine();
                System.out.println("Enter Password : ");
                password = scanner.nextLine();

                boolean isSignIn = false;
                int user = 0;
                for (int i = 0; i < index; i++) {
                    if (users[i].getPassword().equals(password) &&
                            users[i].getLogin().equals(login)) {
                        isSignIn = true;
                        user = i;
                        break;
                    }
                }

                while (isSignIn) {
                    scanner = new Scanner(System.in);
                    System.out.println("Dobro pojolovat v proqramu " + users[user].getName());
                    System.out.println("1 - Change login");
                    System.out.println("2 - Change password");
                    System.out.println("3 - Change name");
                    System.out.println("4 - Back");
                    System.out.println("5 - Exit");


                    action = scanner.nextLine();
                    if (action.equals("1")) {
                        System.out.println("Enter new login");
                        login = scanner.nextLine();
                        users = changeLogin(users, login, user);
                    } else if (action.equals("2")) {
                        System.out.println("Enter new password");
                        password = scanner.nextLine();
                        System.out.println("Enter repeat password");
                        repeatPassword = scanner.nextLine();
                        if (repeatPassword.equals(password)) {
                            users = changePass(users, password, user);
                        } else {
                            System.out.println("Passwords no repeat");
                        }
                    } else if (action.equals("3")) {
                        System.out.println("Enter new name");
                        name = scanner.nextLine();
                        users = changeName(users, name, user);

                    } else if (action.equals("4")) {
                        break;
                    } else if (action.equals("5")) {
                        System.out.println("Bye Bye");
                        return;
                    } else {
                        System.out.println("Ne pravilniy vvod");
                    }
                }
            } else if (action.equals("2")) {
                System.out.println("Registration");
                scanner = new Scanner(System.in);
                System.out.println("Enter Login : ");
                login = scanner.nextLine();
                System.out.println("Enter Name : ");
                name = scanner.nextLine();
                System.out.println("Enter Password : ");
                password = scanner.nextLine();
                System.out.println("Enter Repeat Password : ");
                repeatPassword = scanner.nextLine();

                if (repeatPassword.equals(password)) {
                    if (!checkUnikalLogin(users, login)) {
                        User user = new User(login, password, name);

                        users[index] = user;
                        index++;

                        System.out.println("Vas polzovatel bil zaregistrirovan");
                    } else {
                        System.out.println("Danniy login zanet");
                    }
                } else {
                    System.out.println("Paroli ne sovpadayut");
                }


            } else if (action.equals("4")) {
                System.out.println("Bye bye");
                break;
            } else if (action.equals("3")) {
                if (index > 0) {
                    System.out.println("Print Users");
                    for (int i = 0; i < index; i++) {
                        System.out.println(users[i].getInfo());
                    }
                } else {
                    System.out.println("Users empty");
                }

            } else {
                System.out.println("Error enter number");
            }
        }
    }
}