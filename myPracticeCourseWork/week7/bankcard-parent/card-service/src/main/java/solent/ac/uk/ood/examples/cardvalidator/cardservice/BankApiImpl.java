/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cardservice;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solent.ac.uk.ood.examples.cardcheck.CardCompany;
import solent.ac.uk.ood.examples.cardvalidator.accountdao.jaxbimpl.AccountDAOJaxbImpl;
import solent.ac.uk.ood.examples.cardvalidator.impl.SupportedCardIssuerIdentificationNumbers;
import solent.ac.uk.ood.examples.cardvalidator.model.Account;
import solent.ac.uk.ood.examples.cardvalidator.model.AccountDAO;
import solent.ac.uk.ood.examples.cardvalidator.model.BankApi;
import solent.ac.uk.ood.examples.cardvalidator.model.CardFactoryDAO;
import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;

/**
 *
 * @author cgallen
 */
public class BankApiImpl implements BankApi {

    private static final Logger LOG = LoggerFactory.getLogger(BankApiImpl.class);
    
    private static final Logger TRANSACTIONLOG = LoggerFactory.getLogger("transaction-log");

    private final CardFactoryDAO cardFactoryDao;

    private final AccountDAO accountDAO;

    public BankApiImpl(CardFactoryDAO cardFactoryDao, AccountDAO accountDAO) {
        this.cardFactoryDao = cardFactoryDao;
        this.accountDAO = accountDAO;
    }

    @Override
    public Account createAccount(String issuerIdentificationNumber, String name) {
        return new AccountDAOJaxbImpl("Accounts").createAccount(issuerIdentificationNumber, name);
        
    }

    @Override
    public boolean deleteAccount(String issuerIdentificationNumber, String individualAccountIdentifier) {
        return new AccountDAOJaxbImpl("Accounts").deleteAccount(issuerIdentificationNumber, individualAccountIdentifier);
    }

    @Override
    public Account retrieveAccount(String issuerIdentificationNumber, String individualAccountIdentifier) {
        return new AccountDAOJaxbImpl("Accounts").retrieveAccount(issuerIdentificationNumber, individualAccountIdentifier);
    }

    @Override
    public Account updateAccount(Account account) {
        return new AccountDAOJaxbImpl("Accounts").updateAccount(account);
    }

    @Override
    public List<Account> getAccountsForIssuer(String issuerIdentificationNumber) {
        return new AccountDAOJaxbImpl("Accounts").getAccountsForIssuer(issuerIdentificationNumber);
    }

    @Override
    public List<String> getSupportedIssuerNames() {
        List<String> res = null;
        for(CardCompany c: CardCompany.values()) {
            res.add(c.getIssuerName());
        }
        return res;
    }

    @Override
    public String getIssuerIdentifierNumberForName(String name) {
        return new
    }

    @Override
    public String getNameForIssuerIdentificationNumber(String issuerIdentificationNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CreditCard createNewCreditCard(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
