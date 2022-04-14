package datastructures;

public class NoteObject {

    private int pitch;
    private int rhythm;
    private int duration;

    public NoteObject(int pitch, int rhythm, int duration) {
        this.pitch = pitch;
        this.rhythm = rhythm;
        this.duration = duration;
    }

    public int getPitch() {
        return this.pitch;
    }

    public int getRhythm() {
        return this.rhythm;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Pitch: " + this.pitch + ", Rhythm: " + this.rhythm + ", Duration: " + this.duration + "\n";
    }
}
