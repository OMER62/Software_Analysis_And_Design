import java.util.LinkedList;
import java.util.List;

public class Customer implements Object_In_System {
    //fields
    String id;
    String Address;
    String phone;
    String email;
    int SoftwareID;
    //Associations:
    //Customer connect to user in (0-1)
    User user;
    //Customer connect to account in <> of 1
    Account account;
    //-Each Customer Should be connect to the Class object of account:
    //Default Constructor-Should be connect to the Class object of account:
    public Customer(int softwareID, String id, String address, String phone, String email) {
        this.id = id;
        Address = address;
        this.phone = phone;
        this.email = email;
        this.SoftwareID = softwareID;
    }


    //-Should be connect to the Class object of account:
    //Constructor that receives user:
    public Customer(int softwareID, String id, String address, String phone, String email, User user, Account account) {
        this.id = id;
        Address = address;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.account = account;
        this.SoftwareID = softwareID;
    }
    //******************Methods:

    public void RemoveUser(User user){
        if(user==this.user)
            this.user=null;

    }
    public void AddUser(User user){
        if(this.user == null){
            this.user=user;
        }
    }

    public void addAccount(Account account){
        if(this.account == null){
            this.account = account;
        }
    }

    @Override
    public String toString() {
        return "Customer"+SoftwareID;
    }
    public String Fields_ToString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * @return a String that includes all the Objects that connection to this object
     */
    @Override
    public String The_Connection_Objects_ToString() {
        List<String> Output = new LinkedList<>();
        if(user!=null)
            Output.add(user.toString());
        if(account!=null)
            Output.add(account.toString());
        return Output.toString();
    }


    public void delete() {
        account.delete();
    }
}
