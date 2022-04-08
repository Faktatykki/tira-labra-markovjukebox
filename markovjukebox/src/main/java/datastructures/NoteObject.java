package datastructures;

public class NoteObject {

    private int pitch;
    private double rhythm;
    private double duration;

    public NoteObject(int pitch, double rhythm, double duration) {
        this.pitch = pitch;
        this.rhythm = rhythm;
        this.duration = duration;
    }

    public int getPitch() {
        return this.pitch;
    }

    public double getRhythm() {
        return this.rhythm;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public void setRhythm(double rhythm) {
        this.rhythm = rhythm;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
