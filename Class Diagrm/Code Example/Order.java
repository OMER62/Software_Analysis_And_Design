
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class  Order implements Object_In_System
{
	//Fields
	String number;
	Date ordered;
	Date shipped;
	String ship_to;
	float balance;
	OrderStatus status;
	int SoftwareID;
	//Association classes:

	List<LineItem> Line_items;
	LinkedList<Payment> payments;
	//connection of <> and 1
	Account account;
	//Default constructor- dont must include the Line_items and the  payments objects
	public Order(int softwareID, String number, Date ordered, Date shipped, String ship_to, float balance, OrderStatus status,Account account) {
		this.number = number;
		this.ordered = ordered;
		this.shipped = shipped;
		this.ship_to = ship_to;
		this.balance = balance;
		this.status = status;
		this.account=account;
		this.SoftwareID = softwareID;
		//initialized the arrays
		this.Line_items=new LinkedList<>();
		this.payments=new LinkedList<>();

	}
	//Constructor that get List of LineItems:
	public Order(int softwareID,String number, Date ordered, Date shipped, String ship_to, float balance, OrderStatus status,Account account,List<LineItem> Line_items) {
		this.number = number;
		this.ordered = ordered;
		this.shipped = shipped;
		this.ship_to = ship_to;
		this.balance = balance;
		this.status = status;
		this.account=account;
		this.SoftwareID = softwareID;
		//
		this.Line_items=Line_items;
		this.payments = new LinkedList<>();
	}

//Constructor that get List of payments
	public Order(int softwareID,String number, Date ordered, Date shipped, String ship_to, float balance, OrderStatus status,Account account,LinkedList<Payment> payments) {
		this.number = number;
		this.ordered = ordered;
		this.shipped = shipped;
		this.ship_to = ship_to;
		this.balance = balance;
		this.status = status;
		this.account=account;
		this.SoftwareID = softwareID;
		//
		this.Line_items=new LinkedList<>();
		this.payments = payments;
	}
	//Constructor that get List of payments and LineItems and Payments:
	public Order(int softwareID,String number, Date ordered, Date shipped, String ship_to,float balance, OrderStatus status,Account account,List<LineItem> Line_items,LinkedList<Payment> payments) {
		this.number = number;
		this.ordered = ordered;
		this.shipped = shipped;
		this.ship_to = ship_to;
		this.balance = balance;
		this.status = status;
		this.account=account;
		this.SoftwareID = softwareID;
		//
		this.Line_items=Line_items;
		this.payments = payments;
	}
	//******************Methods:
	//Maintain the relationship Account (1)(connect to) <> Order (*)
	public void connect_to_Account(Account account){
		this.account=account;
		account.AddOrder(this);
	}
	//Maintain the relationship Order (1)(connect to) --- Payment(*)
	public void Add_Payment(Payment payment){
		if(payment.order.equals(this))
			this.payments.add(payment);

	}
	//Maintain the relationship Order (1)(connect to) --- LineItem(*)
	public void Add_LineItem(LineItem lineItem){
		if(lineItem.order.equals(this)){
			this.Line_items.add(lineItem);
			this.balance += lineItem.price;
		}


	}
	@Override
	public String toString() {
		return "Order"+SoftwareID;
	}

	public String Fields_ToString() {
		return "Order{" +
				"number='" + number + '\'' +
				", order='" + ordered + '\'' +
				", shipped=" + shipped +
				", ship_to=" + ship_to +
				", balance=" + balance +
				", status=" + status +
				'}';
	}

	public void delete() {
		account = null;
		for (int i = 0; i < payments.size(); i++) {
			payments.get(i).delete();
		}
		for (int i = 0; i < Line_items.size(); i++) {
			Line_items.get(i).delete();
		}
	}
	/**
	 * @return a String that includes all the Objects that connection to this object
	 */
	@Override
	public String The_Connection_Objects_ToString() {

		List<String> Output = new LinkedList<>();
		if(this.account!=null)
			Output.add(account.toString());
		for(LineItem lineItem: Line_items){
			if(lineItem!=null)
				Output.add(lineItem.toString());
		}
		for(Payment payment :payments)
		{
			if(payment!=null)
				Output.add(payment.toString());
		}
		return Output.toString();

	}

}