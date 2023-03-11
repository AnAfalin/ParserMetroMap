package models;

import java.util.*;

public class MetroMap {
    HashMap<String, Line> lineHashMap = new HashMap<>();
    ArrayList<Connections> connections = new ArrayList<>();

    public void setLineHashMap(HashMap<String, Line> lineHashMap) {
        this.lineHashMap = lineHashMap;
    }

    public void addConnections(Connections connections) {
        this.connections.add(connections);
    }

    public List<Station> getListStations() {
        List<Station> stations = new ArrayList<>();
        Collection<Line> lines = lineHashMap.values();
        for (Line line : lines) {
            stations.addAll(line.stations);
        }
        return stations;
    }

    public HashMap<String, Object> getMetroObject() {
        HashMap<String, Object> metroMap = new LinkedHashMap<>();

        TreeMap<String, List<String>> stations = new TreeMap<>();
        Set<Line> lines = new HashSet<>();
        for (Map.Entry<String, Line> entry : lineHashMap.entrySet()) {
            lines.add(entry.getValue());
            String number = entry.getKey();
            List<String> stringStations = new ArrayList<>();
            ArrayList<Station> stationList = entry.getValue().stations;
            for (Station station : stationList) {
                stringStations.add(station.name);
            }
            stations.put(number, stringStations);
        }

        metroMap.put("stations", stations);
        metroMap.put("lines", lines);
        metroMap.put("connections", connections);

        return metroMap;
    }
}

