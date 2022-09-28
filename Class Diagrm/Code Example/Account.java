import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Account implements Object_In_System {
    //Fields:
    String id;
    String billing_address;
    boolean is_closed;
    Date open;
    Date closed;
    int balance;
    int SoftwareID;

    //Associations:
    //Must include one connected object of shopping cart
    ShoppingCart shoppingCart;
    //Must include one connected object of Customer
    Customer customer;
    //connect to order and payments in * connection:
    //Account (1)(connect to) --- Payment (*)
    List<Payment> payments;
    //Account (1)(connect to) <> Order (*)
    LinkedList<Order> orders;
    //Default Constructor-Must connect to shopping cart and Customer
    public Account(int softwareID, String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balanced;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.SoftwareID = softwareID;
        //initializing the list:
        this.payments=new LinkedList<>();
        this.orders=new LinkedList<>();
    }
    public void addShoppingcart(ShoppingCart shoppingCart){
        if(this.shoppingCart == null){
            this.shoppingCart = shoppingCart;
        }
    }

    public void addCustomer(Customer customer){
        if(this.customer == null){
            this.customer = customer;
        }
    }

    public Account(int softwareID, String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced, ShoppingCart shoppingCart, Customer customer) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balanced;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.SoftwareID = softwareID;
        //initializing the list:
        this.payments=new LinkedList<>();
        this.orders=new LinkedList<>();
    }
    //Constructor-Must connect to shopping cart and Customer+get as input list of payments:
    public Account(int softwareID, String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced, ShoppingCart shoppingCart, Customer customer,List<Payment>payments) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balanced;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.SoftwareID = softwareID;
        //
        this.payments=payments;
        //initializing the list:
        this.orders=new LinkedList<>();
    }
    //Constructor -Must connect to shopping cart and Customer +get as input list of orders:
    public Account(int softwareID, String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced, ShoppingCart shoppingCart, Customer customer,LinkedList<Order>orders) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balanced;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.SoftwareID = softwareID;
        //initializing the list:
        this.payments=new LinkedList<>();
        //
        this.orders=orders;
    }
    //Constructor -Must connect to shopping cart and Customer+get as input 2 lists:one of order and the second of payments
    public Account(int softwareID, String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced, ShoppingCart shoppingCart, Customer customer,LinkedList<Order>orders,LinkedList<Payment>payments) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balanced;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.SoftwareID = softwareID;
        //
        this.payments=payments;
        this.orders=orders;
    }
    //******************Methods:
    //Maintain the relationship Account (1)(connect to) <> Order (*)
    public void AddOrder(Order order){
        //Because Order must had exactly one Account
        if (order.account.equals(this)) {
            //Because that Account (connect to) <> Order -validation that the new order not exist in the list:
            if(!orders.contains(order))
                orders.add(order);
        }
    }
    //Maintain the relationship Account (1)(connect to) --- Payment (*)
    public void AddPayment(Payment payment){
        //Because Order must had exactly one Account
        if (payment.account.equals(this)) {
            payments.add(payment);
        }
    }

    @Override
    public String toString() {
        return "Account"+SoftwareID;
    }

    public void delete() {
        for (int i = 0; i < payments.size(); i++) {
            payments.get(i).delete();
        }
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).delete();
        }

    }
    public String Fields_ToString(){
        return "Account{" +
                "id='" + id + '\'' +
                ", billing_address='" + billing_address + '\'' +
                ", is_closed=" + is_closed +
                ", open=" + open +
                ", closed=" + closed +
                ", balance=" + balance +
                '}';
    }

    /**
     * @return a String that includes all the Objects that connection to this object
     */
    @Override
    public String The_Connection_Objects_ToString() {
        List<String> Output = new LinkedList<>();
        if(shoppingCart!=null)
            Output.add(shoppingCart.toString());
        if(customer!=null)
            Output.add(customer.toString());
        for(Payment payment: payments){
            if(payment!=null)
                Output.add(payment.toString());
        }
        for(Order order :orders)
        {
            if(order!=null)
                Output.add(order.toString());
        }
        return Output.toString();
    }



}
