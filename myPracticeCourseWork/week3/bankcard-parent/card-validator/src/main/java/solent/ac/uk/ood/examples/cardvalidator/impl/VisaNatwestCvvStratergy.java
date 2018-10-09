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
        
        long res = 3;
        for(char c: allInfo.toCharArray()){
            int charToInt = Character.getNumericValue(c);
            if(charToInt > 0){
                res = (res * charToInt) % 999;
            }else{
                res = (res - -charToInt) % 999;
                System.out.println("INT: " + String.valueOf(res) + " -> " + Character.getNumericValue(c));
            }
        }
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
