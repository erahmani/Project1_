package depositException;

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
        } catch(IllegalDepositTypeRuntimeException e){
            System.out.println(e.getMessage());
            return true;
        }catch(IllegalDepositBalanceRuntimeException e){
            System.out.println(e.getMessage());
            return true;
        } catch(IllegalDurationInDaysRuntimeException e){
            System.out.println(e.getMessage());
            return true;
        } catch (Throwable throwable) {
            return false;
        }
    }
}
