package models;

import java.util.ArrayList;

public class Line {
    String title;
    String number;
    ArrayList<Station> stations = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public String toString() {
        return "Line{" +
                "title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", stations=" + stations +
                '}';
    }
}