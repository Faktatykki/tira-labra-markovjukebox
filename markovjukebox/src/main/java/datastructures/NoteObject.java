package datastructures;

public class NoteObject {

    private int pitch;
    private int rhythm;
    private int duration;
    private int dynamic;

    public NoteObject(int pitch, int rhythm, int duration, int dynamic) {
        this.pitch = pitch;
        this.rhythm = rhythm;
        this.duration = duration;
        this.dynamic = dynamic;
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

    public int getDynamic() {
        return this.dynamic;
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
        return "Pitch: " + this.pitch + ", Rhythm: " + this.rhythm + ", Duration: " + this.duration + "Dynamic: " + this.dynamic + "\n";
    }
}
