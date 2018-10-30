package solent.ac.uk.ood.examples.hotellock.reception;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService;
import solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider;
import solent.ac.uk.ood.examples.hotellock.secretkey.SecretKeyProviderImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Controller implements Initializable{

    //Create Card Elements
    public Button createCard;
    public TextField ccRoomNumber;
    public TextField ccValidFrom;
    public TextField ccExpirationDate;
    public TextField ccCardCode;

    //Check Card Elements
    public Button checkCard;
    public TextField checkCardCode;
    public Label checkRomNumber;
    public Label checkValidFrom;
    public Label checkExpirationDate;

    HotelReceptionService hotelReceptionService = new HotelReceptionServiceImpl();
    SecretKeyProvider secretKeyProvider = new SecretKeyProviderImpl();
   
        
    public void guiCreateCardCode() {

        hotelReceptionService.setSecretKeyProvider(secretKeyProvider);

        // used to parse dates
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");

        String roomNumber = ccRoomNumber.getText();
        Date setStartDate = null;
        try {
            setStartDate = df.parse(ccValidFrom.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date setEndDate = null;
        try {
            setEndDate = df.parse(ccExpirationDate.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String cardCode = hotelReceptionService.createCardCode(roomNumber, setStartDate, setEndDate);
        ccCardCode.setText(cardCode);
    }


    public void guiCheckCardCode() {
        hotelReceptionService.setSecretKeyProvider(secretKeyProvider);

        String cardCode = checkCardCode.getText();

        CardKey cardKey = hotelReceptionService.readCard(cardCode);

        checkRomNumber.setText(cardKey.getRoomNumber());
        checkValidFrom.setText(cardKey.getStartDate().toString());
        checkExpirationDate.setText(cardKey.getEndDate().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date now = new Date();

        // constants used to generate default values
        Date tomorrow = new Date(now.getTime() + 1000 * 60 * 60 * 24); // 1 day later
        String timeStrNow = df.format(now);
        String timeStrTomorrow = df.format(tomorrow.getTime());
        ccValidFrom.setText(timeStrNow);
        ccExpirationDate.setText(timeStrTomorrow);
    }


}
