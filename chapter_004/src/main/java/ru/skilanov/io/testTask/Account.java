package ru.skilanov.io.testTask;

/**
 * This is model class.
 */
public class Account {
    /**
     * @param value double
     */
    private double value;
    /**
     * @param requisites int
     */
    private int requisites;

    /**
     * This is default constructor.
     *
     * @param value      double
     * @param requisites int
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * This is toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites=" + requisites +
                '}';
    }

    /**
     * This is equals method.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites == account.requisites;

    }

    /**
     * This is hashCode method.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }

    /**
     * Getter.
     *
     * @return double
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter.
     *
     * @param value double
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter.
     *
     * @return int
     */
    public int getRequisites() {
        return requisites;
    }

    /**
     * Setter.
     *
     * @param requisites int
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }
}
