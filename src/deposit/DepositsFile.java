package deposit;

import depositException.DepositValidationHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DepositsFile {
    public static Deposits parseXml(String addr) {
        try {
            StreamSource xml = new StreamSource(addr);
            JAXBContext jaxbContext = JAXBContext.newInstance(Deposits.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setListener(new DepositValidationHandler());
            jaxbUnmarshaller.setEventHandler(new DepositValidationHandler());
            return (Deposits) jaxbUnmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveDeposits(Deposits deposits) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("result.txt", "rw")) {
            for (Deposit deposit : deposits.getDeposits()) {
                System.out.println(deposit.toString());
                randomAccessFile.writeChars(deposit.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}