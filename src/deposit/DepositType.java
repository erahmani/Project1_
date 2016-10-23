package deposit;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by DotinSchool2 on 9/3/2016.
 */
@XmlType
public abstract class DepositType {
    private double interestRate;
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getInterestRate() { return interestRate;}
}
