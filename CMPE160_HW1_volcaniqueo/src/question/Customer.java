
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	private int talkingTime;
	private int numMessages;
	private double internetUsage;
	
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);
	}
	protected void talk(int minute, Customer other) {
		if (this.ID == other.ID)
			return;
		double fee = this.operator.calculateTalkingCost(minute, this);
		if (bill.check(fee)) {
			bill.add(fee);
			this.talkingTime += minute;
			other.talkingTime += minute;
			this.operator.setProvidedTalkingTime(this.operator.getProvidedTalkingTime() + minute);
			other.operator.setProvidedTalkingTime(other.operator.getProvidedTalkingTime() + minute);
		}
		else
			return;
	}
	protected void message(int quantity, Customer other) {
		if (this.ID == other.ID)
			return;
		double fee = this.operator.calculateMessageCost(quantity, this, other);
		if (this.bill.check(fee)) {
			this.bill.add(fee);
			this.numMessages += quantity;
			this.operator.setProvidedNumMessages(this.operator.getProvidedNumMessages() + quantity);
		}
		else
			return;
		
	}
	protected void connection(double amount) {
		double fee = this.operator.calculateNetworkCost(amount);
		if (this.bill.check(fee)) {
			this.bill.add(fee);
			this.internetUsage += amount;
			this.operator.setProvidedInternetUsage(this.operator.getProvidedInternetUsage() + amount);
		}
		else
			return;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTalkingTime() {
		return talkingTime;
	}
	public void setTalkingTime(int talkingTime) {
		this.talkingTime = talkingTime;
	}
	public int getNumMessages() {
		return numMessages;
	}
	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}
	public double getInternetUsage() {
		return internetUsage;
	}
	public void setInternetUsage(double internetUsage) {
		this.internetUsage = internetUsage;
	}
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

