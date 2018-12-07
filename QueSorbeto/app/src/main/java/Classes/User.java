package Classes;

public class User {

    //Variables
    public String Mail;
    public String Password;

    //Builder
    public User(String _Mail, String _Password) {
        this.Mail = _Mail;
        this.Password= _Password;
    }

    //Getter's
    public String getMail() {
        return Mail;
    }

    public String getPassword() {
        return Password;
    }

    //To_String
    @Override
    public String toString(){
        return "Accediendo con el correo: " + Mail;
    }
}
