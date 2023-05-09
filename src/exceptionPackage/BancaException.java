package exceptionPackage;

public class BancaException extends Exception {

    String message;
    public BancaException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString(){
        return this.message;
    }

}
