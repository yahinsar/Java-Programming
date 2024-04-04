package main.java.ru.sgu.FirstTask;

class Stock implements Comparable<Stock> {
    String lastName;
    String firstName;
    String middleName;
    String companyName;
    int rating;

    public Stock(String lastName, String firstName, String middleName, String companyName, int rating) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.companyName = companyName;
        this.rating = rating;
    }

    @Override
    public int compareTo(Stock other) {
        int ratingComparison = Integer.compare(other.rating, this.rating);
        if (ratingComparison != 0) {
            return ratingComparison;
        }
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        int firstNameComparison = other.firstName.compareTo(this.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        return this.middleName.compareTo(other.middleName);
    }
}