package runtime;

public class OptionIndex {

	private int index;
	
	private String tempAlignment;
	
	public OptionIndex() {
		index = 0;
		tempAlignment = "";
	}
	
	public int getIndex() {
		return index;
	}
	
	// This just sets the index back to 0 after it reaches the end of the expected index
	public void incrementIndex() {
		index++;
		index %= 5;
	}
	
	public String getTempAlignment() {
		return tempAlignment;
	}
	
	public void setTempAlignment(String temp) {
		tempAlignment = temp;
	}
		
}
