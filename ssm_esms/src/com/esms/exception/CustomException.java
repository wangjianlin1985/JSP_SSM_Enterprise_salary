// 
// 
// 

package com.esms.exception;

public class CustomException extends Exception
{
    private String message;
    
    public CustomException(final String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
}
