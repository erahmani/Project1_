package depositException;

public class IllegalDurationInDaysRuntimeException extends RuntimeException{
    public IllegalDurationInDaysRuntimeException(){
        super("IllegalDurationInDaysException");
    }
    public IllegalDurationInDaysRuntimeException(String msg){
        super(msg);
    }
}
