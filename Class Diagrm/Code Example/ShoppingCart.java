import javax.sound.sampled.Line;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements Object_In_System
{
	//Fields:
	int SoftwareID;
	Date created;
	//Associations:
	//ShoppingCart connection to user in connection of 1
	User user;
	//ShoppingCart connection to LineItem in connection of *
	List<LineItem> LineItems;
	//
	Account account;
	//Default Constructor-Must include on element of user
	public ShoppingCart(int softwareID,Date created, User user) {
		this.created = created;
		this.user = user;
		this.SoftwareID = softwareID;
		//initialized the list of items:
		this.LineItems = new LinkedList<>();
	}
	//Constructor that get the LineItems list as input:
	public ShoppingCart(int softwareID,Date created, User user,LineItem lineItems) {
		this.created = created;
		this.user = user;
		this.SoftwareID = softwareID;
		//initialized the list of items:
		this.LineItems = new LinkedList<>();
		//
		this.LineItems=LineItems;
	}
	//Maintain the relationship ShoppingCart (1)(connect to) --- LineItem(*)
	public void AddItem(LineItem lineItem){
		if (lineItem.shoppingCart.equals(this)){
			this.LineItems.add(lineItem);
		}
	}

	public void addUser(User user){
		if(this.user == null){
			this.user= user;
		}
	}

	public void addAccount(Account account){
		if(this.account == null){
			this.account = account;
		}
	}

	public void DeleteItem(LineItem lineItem){
			this.LineItems.remove(lineItem);
	}

	@Override
	public String toString() {
		return "ShoppingCart"+SoftwareID;
	}


	public void delete() {
		user = null;
		for (int i = 0; i < LineItems.size(); i++) {
			LineItems.get(i).delete();
		}
	}

	@Override
	public String Fields_ToString() {
		return "ShoppingCart{" +
				"SoftwareID=" + SoftwareID +
				", created=" + created +
				", user=" + user +
				", LineItems=" + LineItems +
				", account=" + account +
				'}';
	}

	@Override
	public String The_Connection_Objects_ToString() {
		List<String> Output = new LinkedList<>();
		if(account!=null)
			Output.add(account.toString());
		if (user!=null)
			Output.add(user.toString());
		for(LineItem lineItem: LineItems){
			if(lineItem!=null)
				Output.add(lineItem.toString());
		}
		return Output.toString();
	}

}