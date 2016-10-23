package depositException;

/**
 * Created by DotinSchool2 on 9/4/2016.
 */
public class IllegalDepositTypeException extends RuntimeException{
    public IllegalDepositTypeException(){
        super("IllegalDepositTypeException");
    }
    public IllegalDepositTypeException(String msg){
        super(msg);
    }
}
