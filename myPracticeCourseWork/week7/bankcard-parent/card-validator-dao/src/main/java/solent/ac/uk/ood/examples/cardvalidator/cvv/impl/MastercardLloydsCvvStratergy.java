package solent.ac.uk.ood.examples.cardvalidator.cvv.impl;


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
public class MastercardLloydsCvvStratergy implements CvvAlgorythimStrategy {
    private String mastercardLloyds(CreditCard card){
        String name = card.getName();

        String endDate = card.getEndDate();

        String cardNumber = card.getCardnumber();

        String iin = card.getIssuerIdentificationNumber();
        
        String issueNumber = card.getIssueNumber();

        String allInfo = name + endDate + cardNumber + iin + issueNumber;

        List<Integer> cvvList = new ArrayList<>();
        cvvList.add(0,347);
        cvvList.add(1,277);
        cvvList.add(2,283);
        for(int i = 0; i < allInfo.length(); i++){
            int j = i % 3;
            switch (j) {
                case 0:
                    cvvList.set(j, ((cvvList.get(j) % 45 * Integer.parseInt(issueNumber)) + (Character.getNumericValue(allInfo.charAt(i)) + 277)) % 999);
                case 1:
                    cvvList.set(j, ((cvvList.get(j) % 45 * Integer.parseInt(issueNumber)) + (Character.getNumericValue(allInfo.charAt(i)) + 283)) % 999);
                case 2:
                    cvvList.set(j, ((cvvList.get(j) % 45 * Integer.parseInt(issueNumber)) + (Character.getNumericValue(allInfo.charAt(i)) + 347)) % 999);

            }
        }

        int tmpRes = (cvvList.get(0) + cvvList.get(1) + cvvList.get(2)) % 999;
        while(tmpRes < 100) {
            tmpRes = (tmpRes * 47) % 999;
        }

        return String.valueOf(tmpRes);


    }
   

    @Override
    public CreditCard addCvv(CreditCard card) {
        card.setCvv(mastercardLloyds(card));
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        return card.getCvv().equals(mastercardLloyds(card));
    }
}
