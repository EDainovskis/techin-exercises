public class Film {
    private String name;
    private int filmAgeRating;

    public Film(String name, int filmAgeRating) {
        this.name = name;
        this.filmAgeRating = filmAgeRating;
    }

    public String name() {
        return this.name;
    }

    public int filmAgeRating() {
        return this.filmAgeRating;
    }

    public int ageRating() {
        return this.filmAgeRating;
    }
}