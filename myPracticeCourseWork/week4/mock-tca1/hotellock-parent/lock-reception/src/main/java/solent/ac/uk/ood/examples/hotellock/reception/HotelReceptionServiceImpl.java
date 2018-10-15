/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.reception;

import java.util.Date;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService;
import solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider;

/**
 *
 * @author cgallen
 */
public class HotelReceptionServiceImpl implements HotelReceptionService {

    private SecretKeyProvider secretKeyProvider;
    
    int issueNumber = 0;
    
    @Override
    public String createCardCode(String roomNumber, Date startDate, Date endDate) {
        System.err.println(startDate);
        String startDateArray[] = String.valueOf(startDate).split("");
        String cardCode = roomNumber + startDate + endDate + String.valueOf(issueNumber);
        issueNumber += 1;
        return cardCode;
    }

    @Override
    public CardKey readCard(String cardCode) {
        System.err.println("Read Card");
        return null;
    }

    @Override
    public void setSecretKeyProvider(SecretKeyProvider secretKeyProvider) {
        this.secretKeyProvider= secretKeyProvider;
    }
    
}
