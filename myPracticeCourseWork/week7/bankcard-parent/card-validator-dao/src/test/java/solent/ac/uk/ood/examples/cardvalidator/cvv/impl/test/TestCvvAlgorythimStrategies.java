/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cvv.impl.test;

import org.junit.Test;
import static org.junit.Assert.*;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.MastercardTsbCvvStratergy;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.MastercardLloydsCvvStratergy;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.VisaNatwestCvvStratergy;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.AmexLloydsCvvStratergy;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.VisaBoiCvvStratergy;
import solent.ac.uk.ood.examples.cardvalidator.cvv.impl.TrivialCvvAlgorythimStrategy;
import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;
import solent.ac.uk.ood.examples.cardvalidator.model.CvvAlgorythimStrategy;

/**
 *
 * @author cgallen
 */
public class TestCvvAlgorythimStrategies {

    private static final String VALID_MASTERCARD_1 = "5500005555555559";
    private static final String VALID_VISA_1 = "4444444444444448";
    public static final String VALID_AMEX_1 = "371449635398431";
    

    // very trivial test - you need to implement and test several  better algorythims
    @Test
    public void testTrivialCvvAlgorythimStrategy() {

        CreditCard card = new CreditCard();
        card.setCardnumber(VALID_MASTERCARD_1);
        card.setEndDate("0120");
        card.setIssueNumber("01");
        card.setName("Fred Bloggs");
        
        CvvAlgorythimStrategy cvvStrategy = new TrivialCvvAlgorythimStrategy();
        cvvStrategy.addCvv(card);
        System.out.println("testTrivialCvvAlgorythimStrategy CVV: " + card.getCvv());
        assertTrue(cvvStrategy.checkCvv(card));

    }
    
    @Test
    public void testVisaNatwestCvvAlgorythimStrategy() {

       CreditCard card = new CreditCard();
       card.setCardnumber(VALID_VISA_1);
       card.setEndDate("0222");
       card.setIssueNumber("03");
       card.setName("James Richardson");

       CvvAlgorythimStrategy cvvStrategy = new VisaNatwestCvvStratergy();
       cvvStrategy.addCvv(card);
       System.out.println("testVisaNatwestCvvAlgorythimStrategy CVV: " + card.getCvv());
       assertTrue(cvvStrategy.checkCvv(card));

    }

    @Test
    public void testVisaBoiCvvAlgorythimStratergy() {

       CreditCard card = new CreditCard();
       card.setCardnumber(VALID_VISA_1);
       card.setEndDate("0222");
       card.setIssueNumber("03");
       card.setName("James Richardson");

       CvvAlgorythimStrategy cvvStrategy = new VisaBoiCvvStratergy();
       cvvStrategy.addCvv(card);
       System.out.println("testVisaBoiCvvAlgorythimStratergy CVV: " + card.getCvv());
        assertTrue(cvvStrategy.checkCvv(card));

    }

    @Test
    public void testMastercardTsbCvvAlgorythimStratergy() {
        CreditCard card = new CreditCard();
        card.setCardnumber(VALID_MASTERCARD_1);
        card.setEndDate("0120");
        card.setIssueNumber("01");
        card.setName("Fred Bloggs");

        CvvAlgorythimStrategy cvvStrategy = new MastercardTsbCvvStratergy();
        cvvStrategy.addCvv(card);
        System.out.println("testMastercardTsbCvvAlgorythimStratergy CVV: " + card.getCvv());
        assertTrue(cvvStrategy.checkCvv(card));

    }

    @Test
    public void testMastercardLloydsCvvAlgorythimStratergy() {
        CreditCard card = new CreditCard();
        card.setCardnumber(VALID_MASTERCARD_1);
        card.setEndDate("0120");
        card.setIssueNumber("01");
        card.setName("Fred Bloggs");

        CvvAlgorythimStrategy cvvStrategy = new MastercardLloydsCvvStratergy();
        cvvStrategy.addCvv(card);
        System.out.println("testMastercardLloydsCvvAlgorythimStratergy CVV: " + card.getCvv());
        assertTrue(cvvStrategy.checkCvv(card));

    }

    @Test
    public void testAmexLloydsCvvAlgorythimStratergy() {
        CreditCard card = new CreditCard();
        card.setCardnumber(VALID_AMEX_1);
        card.setEndDate("0120");
        card.setIssueNumber("02");
        card.setName("Fred Bloggs");

        CvvAlgorythimStrategy cvvStrategy = new AmexLloydsCvvStratergy();
        cvvStrategy.addCvv(card);
        System.out.println("testAmexLloydsCvvAlgorythimStratergy CVV: " + card.getCvv());
        assertTrue(cvvStrategy.checkCvv(card));

    }
}
