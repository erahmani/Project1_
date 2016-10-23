/**
* Created by DotinSchool2 on 9/3/2016.
*/

import deposit.Deposits;
import deposit.DepositsFile;
import javax.xml.stream.XMLStreamException;

public class Main {
    public static void main(String[] args) {
        Deposits deposits = DepositsFile.parseXml("src\\xmlFiles\\deposits.xml");
        DepositsFile.saveDeposits(deposits);
    }
}