package depositException;

public class IllegalDepositTypeRuntimeException extends RuntimeException{
    public IllegalDepositTypeRuntimeException(){
        super("IllegalDepositTypeException");
    }
    public IllegalDepositTypeRuntimeException(String msg){
        super(msg);
    }
}
