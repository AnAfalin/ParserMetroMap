package models;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Station {
    String name;
    String line;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String depth;
    boolean hasConnector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public boolean isHasConnector() {
        return hasConnector;
    }

    public void setHasConnector(boolean hasConnector) {
        this.hasConnector = hasConnector;
    }

    @Override
    public String toString() {
        return "Station{" +
                "title='" + name + '\'' +
                ", line='" + line + '\'' +
                ", date='" + date + '\'' +
                ", depth=" + depth +
                ", hasConnector=" + hasConnector +
                '}';
    }
}
