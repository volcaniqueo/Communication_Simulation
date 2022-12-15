
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private double limitingAmount;
	private double currentDebt;
	private double totalMoneySpent;
	
	public Bill(double limitingAmount) {
		this.limitingAmount = limitingAmount;
		this.currentDebt = 0.0;
		this.totalMoneySpent = 0.0;
	}
	protected boolean check(double amount) {
		if (amount + this.currentDebt <= this.limitingAmount)
			return true;
		else
			return false;
	}
	protected void add(double amount) {
		this.currentDebt += amount;
	}
	protected void pay(double amount) {
		this.totalMoneySpent += Math.min(amount, this.currentDebt);
		this.currentDebt -= amount;
		if (this.currentDebt < 0)
			this.currentDebt = 0.0;
	}
	protected void changeTheLimit(double amount) {
		if (amount >= this.currentDebt)
			this.limitingAmount = amount;
	}
	public double getLimitingAmount() {
		return this.limitingAmount;
	}
	public double getCurrentDebt() {
		return this.currentDebt;
	}
	public double getTotalMoneySpent() {
		return totalMoneySpent;
	}
	public void setTotalMoneySpent(double totalMoneySpent) {
		this.totalMoneySpent = totalMoneySpent;
	}
	
	
	



	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

