package ua.epam.spring.hometask.domain;

/**
 * Original intention of this class was to distinguish birthday discount from every 10 ticket discount
 */
public class Discount {

    private boolean isWholePriceDiscount;
    private int discountAmount;

    public Discount(boolean isWholePriceDiscount, int discountAmount) {
        this.isWholePriceDiscount = isWholePriceDiscount;
        this.discountAmount = discountAmount;
    }

    public boolean isWholePriceDiscount() {
        return isWholePriceDiscount;
    }

    public void setWholePriceDiscount(boolean wholePriceDiscount) {
        isWholePriceDiscount = wholePriceDiscount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
