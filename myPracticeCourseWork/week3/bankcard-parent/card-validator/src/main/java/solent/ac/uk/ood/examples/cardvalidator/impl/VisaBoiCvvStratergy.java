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
public class VisaBoiCvvStratergy implements CvvAlgorythimStrategy {
    private String VisaBoi(CreditCard card){
        String name = card.getName();

        String endDate = card.getEndDate();

        String cardNumber = card.getCardnumber();

        String iin = card.getIssuerIdentificationNumber();
        
        String issueNumber = card.getIssueNumber();

        String allInfo = name + endDate + cardNumber + iin + issueNumber;
        
        List<Integer> cvvList = new ArrayList<>();
        cvvList.add(0,0);
        cvvList.add(1,0);
        cvvList.add(2,0);
        for(int i = 0; i < allInfo.length(); i++){
            int j = i % 3;
            switch (j) {
                case 0:
                    cvvList.set(j, cvvList.get(j) + Character.getNumericValue(allInfo.charAt(i)));
                case 1:
                    cvvList.set(j, cvvList.get(j) + Character.getNumericValue(allInfo.charAt(i)));
                case 2:
                    cvvList.set(j, cvvList.get(j) + Character.getNumericValue(allInfo.charAt(i)));
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
        card.setCvv(VisaBoi(card));
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        return card.getCvv().equals(VisaBoi(card));
    }
}
