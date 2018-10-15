/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.reception.test;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService;
import solent.ac.uk.ood.examples.hotellock.reception.HotelReceptionServiceImpl;

/**
 *
 * @author cgallen
 */
public class LoggingMessagesTest {
    
    public static final Logger LOG = LogManager.getLogger(LoggingMessagesTest.class);
    
    public static final Logger TRANSACTIONLOG = LogManager.getLogger("transaction-log");
    
//    @Test
//    public void hello() {
//        LOG.debug("JUST SAYING HELLO DEBUG MESSAGE");
//        LOG.warn("JUST SAYING HELLO WARN MESSAGE");
//        LOG.info("JUST SAYING HELLO INFO MESSAGE");
//        HotelReceptionService hotelReceptionServiceImpService = new HotelReceptionServiceImpl();
//        hotelReceptionServiceImpService.createCardCode(105, startDate, endDate)
//        
//        
//        try {
//            throw new RuntimeException("this is a test exception deliberately thrown");
//        } catch (Exception ex) {
//            LOG.error("JUST SAYING HELLO ERROR MESSAGE - the following stack trace is deliberate: ", ex);
//        }
//    }

    
    @Test
    public void testHotelReceptionServiceImplCreateCardCOde() {
        CardKey cardKey = new CardKey();
        cardKey.setRoomNumber("100a");
        cardKey.setIssueNumber(01);
        cardKey.setStartDate(new Date());
        cardKey.setEndDate(new Date(cardKey.getStartDate().getTime() + 1000 * 60 * 60 * 24)); // 1 day later
    
        HotelReceptionService hotelReceptionServiceImpl = new HotelReceptionServiceImpl();
        String cardCode = hotelReceptionServiceImpl.createCardCode(cardKey.getRoomNumber(), cardKey.getStartDate(), cardKey.getEndDate());
        System.out.println("Date HERE: " + cardCode);
        //TRANSACTIONLOG.info("door opened");
    }
}
