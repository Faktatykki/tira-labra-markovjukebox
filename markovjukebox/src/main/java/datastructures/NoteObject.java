package datastructures;

public class NoteObject {

    private int pitch;
    private double rhythm;

    public NoteObject(int pitch, double rhythm) {
        this.pitch = pitch;
        this.rhythm = rhythm;
    }

    public int getPitch() {
        return this.pitch;
    }

    public double getRhythm() {
        return this.rhythm;
    }
}
