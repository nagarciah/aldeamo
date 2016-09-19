package nagarciah.pocs.rest.mocking;

public class MyRequest {
	private String message;
	
	public MyRequest(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
