package consol;
import java.util.Scanner;
import control.User;

public abstract class Frame{
	private boolean exit = false;
	private Scanner sc;
	private User user;
	
	public Frame(Scanner sc, User user){
		this.sc = sc;
		this.user = user;
	}

	public boolean getExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public Scanner getSc() {
		return sc;
	}
	
	public User getUser() {
		return user;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	public abstract void main();
	
	public abstract void goTo(int i);
	
}