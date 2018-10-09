package solent.ac.uk.ood.examples.cardvalidator.impl;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;
import solent.ac.uk.ood.examples.cardvalidator.model.CvvAlgorythimStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 3richj71
 */
public class VisaNatwestCvvStratergy implements CvvAlgorythimStrategy {
    private String visaNatwest(CreditCard card){
        String name = card.getName();

        String endDate = card.getEndDate();

        String cardnumber = card.getCardnumber();

        String iin = card.getIssuerIdentificationNumber();
        
        String issueNumber = card.getIssueNumber();

        String allInfo = name + endDate + cardnumber + iin + issueNumber;
        
        int res = 0;
        for(char c: allInfo.toCharArray()){
            res = (res * Character.getNumericValue(c));
        }
        System.out.println("NEW CVV = " +res);
        return String.valueOf(res);
    }
   

    @Override
    public CreditCard addCvv(CreditCard card) {
        card.setCvv(visaNatwest(card));
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        return card.getCvv().equals(visaNatwest(card));
    }
}
