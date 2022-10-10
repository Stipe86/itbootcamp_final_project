package helper;

public enum Cities {
    BARANQUILLA("Barranquilla"),
    BUCARAMANGA("Bucaramanga"),
    BOGOTA("Bogotá"),
    CALI("Cali"),
    CHICAGO("Chicago"),
    MEDELIN("Medellín"),
    NEW_YORK("New York"),
    OAKLAND("Oakland"),
    SAN_FRANCISCO("San Francisco"),
    SAN_LEANDRO("San Leandro")
    ;

    private String name;
    Cities(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
