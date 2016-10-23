/**
* Created by DotinSchool2 on 9/3/2016.
*/

import deposit.Deposit;
import deposit.Deposits;
import depositException.DepositValidationHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    static Deposits parseXml(String addr){
        try {
            StreamSource xml = new StreamSource(addr);
            JAXBContext jaxbContext = JAXBContext.newInstance(Deposits.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setListener(new DepositValidationHandler());
            jaxbUnmarshaller.setEventHandler(new DepositValidationHandler());
            Deposits deposits = (Deposits) jaxbUnmarshaller.unmarshal( xml );
            return deposits;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void saveDeposits(Deposits deposits){
        try(RandomAccessFile raf = new RandomAccessFile("result.txt", "rw");) {
            for (Deposit deposit: deposits.getDeposits()
                    ) {
                System.out.println(deposit.toString());
                raf.writeChars(deposit.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public static void main(String[] args) throws XMLStreamException {
    Deposits deposits = parseXml("src\\xmlFiles\\deposits.xml");
    saveDeposits(deposits);
}
}