package practice;

public class DoSay {
	private Say say;
	
	public DoSay(){}
	
	public DoSay(Say say) {
		this.say = say;
	}
	
	public void setSay(Say say) {
		this.say = say;
	}
	
	public void doSay() {
		this.say.say();
	}
}
