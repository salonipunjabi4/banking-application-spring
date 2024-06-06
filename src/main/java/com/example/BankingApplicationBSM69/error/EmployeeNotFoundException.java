package com.example.BankingApplicationBSM69.error;

public class EmployeeNotFoundException extends Exception{
	 public EmployeeNotFoundException() {
	        super();
	    }

	    public EmployeeNotFoundException(String message) {
	        super(message);
	    }

	    public EmployeeNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public EmployeeNotFoundException(Throwable cause) {
	        super(cause);
	    }

	   
}
