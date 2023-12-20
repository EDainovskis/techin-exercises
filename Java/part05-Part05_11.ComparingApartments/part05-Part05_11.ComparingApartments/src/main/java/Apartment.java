public class Apartment {
    private int rooms;
    private int squareMeters;
    private int pricePerSquare;

    public Apartment(int rooms, int squareMeters, int pricePerSquare) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        return this.squareMeters > compared.squareMeters;
    }

    public int priceDifference(Apartment compared) {
        int thisPrice = this.squareMeters * this.pricePerSquare;
        int comparedPrice = compared.squareMeters * compared.pricePerSquare;
        return Math.abs(thisPrice - comparedPrice);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        int thisPrice = this.squareMeters * this.pricePerSquare;
        int comparedPrice = compared.squareMeters * compared.pricePerSquare;
        return thisPrice > comparedPrice;
    }
}