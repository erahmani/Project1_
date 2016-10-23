package deposit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;


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
