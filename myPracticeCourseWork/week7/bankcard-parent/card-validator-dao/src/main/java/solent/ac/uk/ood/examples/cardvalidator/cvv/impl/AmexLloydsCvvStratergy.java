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
public class AmexLloydsCvvStratergy implements CvvAlgorythimStrategy {
    private String amexLloyds(CreditCard card){
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
            cvvList.set(0, ((cvvList.get(0) + (Character.getNumericValue(allInfo.charAt(i)) * 853)) % 999));
            cvvList.set(1, ((cvvList.get(1) + (Character.getNumericValue(allInfo.charAt(i)) + 887)) % 999));
            cvvList.set(2, ((cvvList.get(2) + (Character.getNumericValue(allInfo.charAt(i)) + 797)) % 999));
        }

        int tmpRes = (cvvList.get(0) + cvvList.get(1) + cvvList.get(2)) % 999;
        while(tmpRes < 100) {
            tmpRes = (tmpRes * 499) % 999;
        }

        return String.valueOf(tmpRes);


    }
   

    @Override
    public CreditCard addCvv(CreditCard card) {
        card.setCvv(amexLloyds(card));
        return card;
    }

    @Override
    public boolean checkCvv(CreditCard card) {
        return card.getCvv().equals(amexLloyds(card));
    }
}
