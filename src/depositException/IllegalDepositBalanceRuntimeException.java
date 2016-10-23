package depositException;


public class IllegalDepositBalanceRuntimeException extends RuntimeException{
    public IllegalDepositBalanceRuntimeException(){
        super("IllegalDepositBalanceException");
    }
    public IllegalDepositBalanceRuntimeException(String msg){
        super(msg);
    }
}
