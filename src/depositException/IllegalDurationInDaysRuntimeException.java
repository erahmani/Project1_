package depositException;

/**
 * Created by DotinSchool2 on 9/4/2016.
 */
public class IllegalDurationInDaysRuntimeException extends RuntimeException{
    IllegalDurationInDaysRuntimeException(){
        super("IllegalDurationInDaysException");
    }
    IllegalDurationInDaysRuntimeException(String msg){
        super(msg);
    }
}
