package net.jcom.rap.wichteln;

public record Participant(String name, String mailAddress) {
    @Override
    public String toString() {
        return name + ";" + mailAddress;
    }
}
