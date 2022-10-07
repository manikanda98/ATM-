package atm;
import java.io.Serializable;
import java.util.Scanner;

public class Customers implements Serializable {
	private int account_number;
	private String account_holder;
	private String  phone_number;
	private String dob;
	private  int bal;
	private   int pin;
	public Customers(){

	}
	public Customers(int account_number, String account_holder, String phone_number, String dob, int bal,int pin) {
		super();
		this.account_number = account_number;
		this.account_holder = account_holder;
		this.phone_number = phone_number;
		this.dob = dob;
		this.bal = bal;
		this.pin = pin;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getBal() {
		return bal;
	}
	public  void setBal(int bal) {
		this.bal = bal;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "[account_number=" + account_number + "|account_holder=" + account_holder + " |phone_number="
				+ phone_number + "   |dob=" + dob + "   |bal=" + bal + "]";
	}
}


