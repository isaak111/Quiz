package se.superdevs;

import java.util.List;

public class Month {

    private String month;
    private List<Double> tempList;

    public Month(String month, List<Double> tempList) {
        this.month = month;
        this.tempList = tempList;
    }

    public String getMonth() {
        return month;
    }

    public List<Double> getTempList() {
        return tempList;
    }

    @Override
    public String toString() {
        return "Month{" +
                "month='" + month + '\'' +
                ", tempList=" + tempList +
                '}';
    }
}
