package depositException;

/**
 * Created by DotinSchool2 on 9/4/2016.
 */
public class IllegalDepositBalanceException extends RuntimeException{
    public IllegalDepositBalanceException(){
        super("IllegalDepositBalanceException");
    }
    public IllegalDepositBalanceException(String msg){
        super(msg);
    }
}
