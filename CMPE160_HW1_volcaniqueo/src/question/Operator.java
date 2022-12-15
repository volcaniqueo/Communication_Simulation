
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	private int providedTalkingTime;
	private int providedNumMessages;
	private double providedInternetUsage;
	
	
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		this.providedInternetUsage = 0.0;
		this.providedNumMessages = 0;
		this.providedTalkingTime = 0;
	}
	protected double calculateTalkingCost(int minute, Customer customer) {
		double fee;
		if (customer.getAge() < 18 || customer.getAge() > 65)
			fee = (minute * customer.getOperator().talkingCharge * (100 - customer.getOperator().discountRate)) / 100;
		else
			fee = minute * customer.getOperator().talkingCharge;
		return fee;
	}
	protected double calculateMessageCost(int quantity, Customer customer, Customer other) {
		double fee;
		if (customer.getOperator().ID == other.getOperator().ID)
			fee = (quantity * customer.getOperator().messageCost * (100 - customer.getOperator().discountRate)) / 100;
		else
			fee = quantity * customer.getOperator().messageCost;
		return fee;
	}
	protected double calculateNetworkCost(double amount) {
		double fee;
		fee = amount * this.networkCharge;
		return fee;
	}
	public double getTalkingCharge() {
		return talkingCharge;
	}
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	public double getMessageCost() {
		return messageCost;
	}
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	public double getNetworkCharge() {
		return networkCharge;
	}
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public int getProvidedTalkingTime() {
		return providedTalkingTime;
	}
	public void setProvidedTalkingTime(int providedTalkingTime) {
		this.providedTalkingTime = providedTalkingTime;
	}
	public int getProvidedNumMessages() {
		return providedNumMessages;
	}
	public void setProvidedNumMessages(int providedNumMessages) {
		this.providedNumMessages = providedNumMessages;
	}
	public double getProvidedInternetUsage() {
		return providedInternetUsage;
	}
	public void setProvidedInternetUsage(double providedInternetUsage) {
		this.providedInternetUsage = providedInternetUsage;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	



	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

