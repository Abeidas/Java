
public class Condition {
	int movement;
	private String ouput;
	private String input;
	private Condition nextCondition;
	public Condition(String input,Condition nextCondition,String output, int movement) {
		this.movement = movement;
		this.ouput = output;
		this.input = input;
		this.setNextCondition(nextCondition);
	}
	public int getMovement() {
		return movement;
	}
	public String getOuput() {
		return ouput;
	}
	public String getInput() {
		return input;
	}
	public Condition getnextCondition() {
		return getnextCondition();
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public void setOuput(String ouput) {
		this.ouput = ouput;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public void setConditionChange(Condition nextCondition) {
		this.setNextCondition(nextCondition);
	}
	public Condition getNextCondition() {
		return nextCondition;
	}
	public void setNextCondition(Condition nextCondition) {
		this.nextCondition = nextCondition;
	}
}
