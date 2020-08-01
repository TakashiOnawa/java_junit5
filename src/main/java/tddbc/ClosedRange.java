package tddbc;

public class ClosedRange {
    public ClosedRange(int lowerEndpoint, int upperEndpoint) {
        if(lowerEndpoint > upperEndpoint) {
            throw new IllegalArgumentException();
        }
    }
}
