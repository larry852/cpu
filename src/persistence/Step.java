package persistence;

public class Step {
	private String componet;
	private String instruction;
	
	public Step(String componet, String instruction) {
		this.componet = componet;
		this.instruction = instruction;
	}
	
	public String getComponet() {
		return componet;
	}
	public void setComponet(String componet) {
		this.componet = componet;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
}
