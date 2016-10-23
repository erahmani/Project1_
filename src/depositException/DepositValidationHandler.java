package depositException; /**
 * Created by DotinSchool2 on 9/5/2016.
 */

import deposit.Deposit;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class DepositValidationHandler extends Unmarshaller.Listener implements ValidationEventHandler {
    @Override
    public void afterUnmarshal(Object target, Object parent)   {
        super.afterUnmarshal(target, parent);
            if (target instanceof Deposit) {
                 ((Deposit)target).setPayedInterest();
            }
    }

    @Override
    public boolean handleEvent(ValidationEvent event) {
        try {
            throw event.getLinkedException();
        }catch(depositException.IllegalDepositTypeException iDTE){
            System.out.println(iDTE.getMessage());
            return true;
        }catch(depositException.IllegalDepositBalanceException iDBE){
            System.out.println(iDBE.getMessage());
            return true;
        }catch(depositException.IllegalDurationInDaysException iDIDE){
            System.out.println(iDIDE.getMessage());
            return true;
        }catch (Throwable throwable) {
            return false;
        }
    }
}
