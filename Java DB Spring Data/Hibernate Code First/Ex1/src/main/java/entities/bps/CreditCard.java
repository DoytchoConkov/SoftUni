package entities.bps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="credit_cards")
public class CreditCard extends Bill{
    private String cardType;
    private int expirationMount;
    private int expirationYear;

    public CreditCard() {
    }
    @Column(name="card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    @Column(name="expiration_mount")
    public int getExpirationMount() {
        return expirationMount;
    }

    public void setExpirationMount(int expirationMount) {
        this.expirationMount = expirationMount;
    }
    @Column(name="expiration_year")
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
