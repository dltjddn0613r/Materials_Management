package service;

public class QuoteNotFoundException extends RuntimeException {
	public QuoteNotFoundException() {
        super();
    }

    public QuoteNotFoundException(String message) {
        super(message);
    }
}
