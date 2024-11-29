package com.example.API.Model;

public class ChatMessage {


	 private String senderName;
	 private String receiverName;
	 private String message;
	 private Status status;
	 
	
	public ChatMessage() {
		
	}


	public ChatMessage(String senderName, String receiverName, String message, Status status) {
		super();
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.message = message;
		this.status = status;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ChatMessage [senderName=" + senderName + ", receiverName=" + receiverName + ", message=" + message
				+ ", status=" + status + "]";
	}
}
