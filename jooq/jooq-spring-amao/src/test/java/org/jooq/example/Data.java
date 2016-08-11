package org.jooq.example;


@lombok.Data
public class Data implements Comparable<Data> {
    String title;
    int smonth;
    int sdate;

    @Override
    public int compareTo(Data data) {
        if (this.getUniqueCode() == data.getUniqueCode()) {
            return 0;
        }
        if (this.getUniqueCode() > data.getUniqueCode()) {
            return 1;
        }
        return -1;
    }

    public int getUniqueCode() {
        return this.getSmonth() * 100 + this.getSdate();
    }
}
