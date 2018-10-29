/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.service.rest.client.test.manual;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.service.rest.client.HotelLockRestClientImpl;

/**
 *
 * @author cgallen
 */
public class HotelLockRestClientImplTest {

    String baseUrl = "http://localhost:8680";
    MediaType mediaType = MediaType.APPLICATION_XML_TYPE;

    @Test
    public void testCreateCard() {

        HotelLockRestClientImpl client = new HotelLockRestClientImpl(baseUrl, mediaType);
        System.out.println("Door should stay locked!");
        String roomNumber = "101";
        String cardCode = "3130312C31363662366339353565302C31363662626566623165302C323A6239353539396632";
        Boolean generatedCardCode = client.unlockDoor(roomNumber, cardCode);
        if(generatedCardCode){
            System.out.println("The door is UNLOCKED");
        }else{
            System.out.println("the door is LOCKED");
        }
        
        System.out.println("Door should be unlocked!");
        String roomNumber1 = "101";
        String cardCode1 = "3130312C31363662666364363134302C31363663346633626434302C313A3237356134363539";
        Boolean generatedCardCode1 = client.unlockDoor(roomNumber1, cardCode1);
        if(generatedCardCode1){
            System.out.println("The door is UNLOCKED");
        }else{
            System.out.println("the door is LOCKED");
        }
        
        
        
        
        
       // assertEquals(requestStartDateStr, receivedStartDateStr);
       // assertEquals(requestEndDateStr, receivedEndDateStr);

    }

}
