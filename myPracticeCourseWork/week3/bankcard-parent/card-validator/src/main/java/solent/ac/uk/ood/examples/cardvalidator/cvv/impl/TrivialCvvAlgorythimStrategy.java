/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cvv.impl;

import solent.ac.uk.ood.examples.cardvalidator.model.CardOrganisation;
import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;
import solent.ac.uk.ood.examples.cardvalidator.model.CvvAlgorythimStrategy;

/**
 *
 * @author cgallen
 */
public class TrivialCvvAlgorythimStrategy implements CvvAlgorythimStrategy {

    private final String CVV = "000";
    @Override
    public CreditCard addCvv(CreditCard card) {
        if(card.getIssuerIdentificationNumber().equals("428586")){
            card.setCvv(VISA(card));
            return card;
        }
        card.setCvv(CVV);
        return card;
    }

    private final String VISA(CreditCard card){
        String name = card.getName();

        String endDate = card.getEndDate();

        String cardnumber = card.getCardnumber();

        String iin = card.getIssuerIdentificationNumber();

        Integer nameChar = Integer.valueOf(Integer.toBinaryString(name.charAt(name.length() - 1)));
        String dateChar = String.valueOf(((int) endDate.charAt(3) * Integer.valueOf(iin)) + (int) cardnumber.charAt(7) + nameChar);
        String cvv = String.valueOf(dateChar.substring(0 ,3));
        return cvv;
    }
    private CreditCard AMEX(CreditCard card){
        return card;
    }
    private CreditCard DINERS(CreditCard card){
        return card;
    }
    private CreditCard DISCOVER(CreditCard card){
        return card;
    }
    private CreditCard JCB(CreditCard card){
        return card;
    }
    private CreditCard MASTERCARD(CreditCard card){
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        System.out.println("CARD CVV = " + card.getCvv());
        System.out.println("CHECK CVV = " + VISA(card));
        if(card.getIssuerIdentificationNumber().equals("428586")) {
            return card.getCvv().equals(VISA(card));
        }

        return card.getCvv().equals(CVV);
    }
    
}
