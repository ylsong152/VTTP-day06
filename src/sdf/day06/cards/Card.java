package sdf.day06.cards;

public record Card (String suit, String name, Integer value) {
    
    public String display() {
        return "Suit: %s, Name: %s, Value: %d"
            .formatted (suit(), name(), value())
    }
}