public class Athlete {
    private String name;
    private int totalTime;
    private int totalLap;

    public Athlete(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalLap() {
        return this.totalLap;
    }

    public void setTotalLap(int totalLap) {
        this.totalLap = totalLap;
    }
}
