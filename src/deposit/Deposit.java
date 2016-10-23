package deposit;

import exceptions.*;
import exceptions.IllegalDepositTypeException;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "deposit")
public class Deposit implements Comparable{
    private BigDecimal payedInterest;
    private DepositType depositType;
    private String customerNumber;
    private BigDecimal depositBalance;
    private Integer durationInDays;
    @XmlElement(name="customerNumber")
    private void setCustomerNumber(String customerNumber){
           this.customerNumber = customerNumber;
    }
    @XmlElement(name="depositType")
    private void setDepositType(String depositType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        try {
            this.depositType = (DepositType) Class.forName(depositType).newInstance();
        } catch( ClassNotFoundException e ) {
            throw new IllegalDepositTypeException("Illegal Deposit Type for Customer Number:" + customerNumber);
        }
    }
    @XmlElement(name="depositBalance")
    private void setDepositBalance(BigDecimal depositBalance) {
        if(depositBalance.compareTo(new BigDecimal(0)) < 0)
            throw new IllegalDepositBalanceException("Illegal DepositBalance Exception for Customer Number:" + customerNumber);
        this.depositBalance = depositBalance;
    }
    @XmlElement(name="durationInDays")
    private void setDurationInDays(Integer durationInDays) {
        if(durationInDays.compareTo(0) <= 0)
            throw new IllegalDepositBalanceException("Illegal DurationInDays Exception for Customer Number:" + customerNumber);
        this.durationInDays = durationInDays;
    }

    private BigDecimal computePayedInterest(){
        if(depositType != null && depositBalance != null && durationInDays != null)
            return depositBalance.multiply(new BigDecimal((depositType.getInterestRate()*durationInDays)/36500));
        return new BigDecimal(-1);
    }

    public void setPayedInterest(){
        this.payedInterest = computePayedInterest();
    }

    @Override
    public String toString() {
        return customerNumber+"#"+payedInterest+"\n";
    }

    @Override
    public int compareTo(Object o) {
        return payedInterest.compareTo(((Deposit)o).payedInterest);
    }
}