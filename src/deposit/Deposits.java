package deposit;

import java.util.ArrayList;
/**
 * Created by DotinSchool2 on 9/3/2016.
 */
import java.util.Collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "deposits")
@XmlAccessorType (XmlAccessType.FIELD)
public class Deposits {
    @XmlElement(name = "deposit")
    private ArrayList<Deposit> deposits;
    public ArrayList<Deposit> getDeposits() {
        Collections.sort(deposits);
        Collections.reverse(deposits);
        return deposits;
    }
    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }
}
