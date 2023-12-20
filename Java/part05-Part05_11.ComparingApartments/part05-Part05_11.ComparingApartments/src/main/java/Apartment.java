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
        return Math.abs(this.squareMeters * this.pricePerSquare - compared.squareMeters * compared.pricePerSquare);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        return (this.squareMeters * this.pricePerSquare) > (compared.squareMeters * compared.pricePerSquare);
    }
}
