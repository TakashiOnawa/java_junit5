package tddbc;

public class ClosedRange {

    private final int lowerEndpoint;
    private final int upperEndpoint;

    public ClosedRange(int lowerEndpoint, int upperEndpoint) {
        if (lowerEndpoint > upperEndpoint) {
            throw new IllegalArgumentException();
        }

        this.lowerEndpoint = lowerEndpoint;
        this.upperEndpoint = upperEndpoint;
    }
}