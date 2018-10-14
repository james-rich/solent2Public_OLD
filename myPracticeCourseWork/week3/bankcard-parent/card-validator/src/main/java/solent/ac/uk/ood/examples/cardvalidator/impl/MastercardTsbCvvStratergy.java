package solent.ac.uk.ood.examples.cardvalidator.impl;


import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;
import solent.ac.uk.ood.examples.cardvalidator.model.CvvAlgorythimStrategy;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 3richj71
 */
public class MastercardTsbCvvStratergy implements CvvAlgorythimStrategy {
    private String mastercardTsb(CreditCard card){
        String name = card.getName();

        String endDate = card.getEndDate();

        String cardnumber = card.getCardnumber();

        String iin = card.getIssuerIdentificationNumber();
        
        String issueNumber = card.getIssueNumber();

        String allInfo = name + endDate + cardnumber + iin + issueNumber;

        List<Integer> cvvList = new ArrayList<>();
        cvvList.add(0,3 * Integer.parseInt(iin));
        cvvList.add(1,7 * Integer.parseInt(iin));
        cvvList.add(2,9 * Integer.parseInt(iin));
        for(int i = 0; i < allInfo.length(); i++){
            int j = i % 3;
            switch (j) {
                case 0:
                    cvvList.set(j, cvvList.get(j) + (Character.getNumericValue(allInfo.charAt(i)) *  3));
                case 1:
                    cvvList.set(j, cvvList.get(j) + (Character.getNumericValue(allInfo.charAt(i)) *  7));
                case 2:
                    cvvList.set(j, cvvList.get(j) + (Character.getNumericValue(allInfo.charAt(i)) *  9));
            }
        }

        cvvList.set(0, cvvList.get(0) % 9);
        cvvList.set(1, cvvList.get(1) % 9);
        cvvList.set(2, cvvList.get(2) % 9);

        String res = cvvList.get(0).toString() + cvvList.get(1).toString() + cvvList.get(2).toString();

        return String.valueOf(res);


    }
   

    @Override
    public CreditCard addCvv(CreditCard card) {
        card.setCvv(mastercardTsb(card));
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        return card.getCvv().equals(mastercardTsb(card));
    }
}
