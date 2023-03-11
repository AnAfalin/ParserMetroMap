package models;

public class Connections {
    Connection[] connections = new Connection[2];

    public Connections(String line1, String station1, String line2, String station2) {
        connections[0] = new Connection(line1, station1);
        connections[1] = new Connection(line2, station2);
    }

    static class Connection {
        String line;
        String station;

        public Connection(String line, String station) {
            this.line = line;
            this.station = station;
        }

        public String getLine() {
            return line;
        }

        public String getStation() {
            return station;
        }
    }

    public Connection[] getConnections() {
        return connections;
    }
}