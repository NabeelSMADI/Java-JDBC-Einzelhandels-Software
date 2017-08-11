import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Smady91 on 28.06.2017.
 */
public class Kunde {

    public SimpleIntegerProperty kundenid = new SimpleIntegerProperty();
    public SimpleStringProperty kundenName = new SimpleStringProperty();
    public SimpleIntegerProperty telefon = new SimpleIntegerProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    public SimpleStringProperty adresse = new SimpleStringProperty();


    public int getKundenid() {
        return kundenid.get();
    }

    public SimpleIntegerProperty kundenidProperty() {
        return kundenid;
    }

    public void setKundenid(int kundenid) {
        this.kundenid.set(kundenid);
    }

    public String getKundenName() {
        return kundenName.get();
    }

    public SimpleStringProperty kundenNameProperty() {
        return kundenName;
    }

    public void setKundenName(String kundenName) {
        this.kundenName.set(kundenName);
    }

    public int getTelefon() {
        return telefon.get();
    }

    public SimpleIntegerProperty telefonProperty() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon.set(telefon);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String toString() {
        return kundenid.getValue() +""+ kundenName.getValue() + telefon.getValue() + email.getValue() + adresse.getValue();
    }


}
