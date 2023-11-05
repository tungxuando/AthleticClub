public enum TrackType {
    GRASS(300), GRAVEL(400);

    private final int distance;

    TrackType(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }
}
