package tddbc;

import java.util.Objects;

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

    public boolean in(int value) {
        return value >= lowerEndpoint && value <= upperEndpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClosedRange that = (ClosedRange) o;
        return lowerEndpoint == that.lowerEndpoint &&
                upperEndpoint == that.upperEndpoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerEndpoint, upperEndpoint);
    }
}
