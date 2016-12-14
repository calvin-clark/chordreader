import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple program that takes letters representing note values and outputs
 * the chord those notes create.
 * Author: Calvin Clark
 */
public class Main {
    private static String[] notes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    /**
     * Prints the prompts to the command line and initializes the scanner to read in
     * the notes.
     */
    public static void makeChord() {
        System.out.println("Notes should be represented as a letter, with # or b for sharp/flat");
        System.out.print("Number of notes: ");
        Scanner sc = new Scanner(System.in);
        int[] notes = new int[12];
        int numNotes = sc.nextInt();
        for (int i = 0; i < numNotes; i++) {
            notes[newNote()]++;
        }
        System.out.print(chord(notes));
    }

    /**
     * Converts a chord into an array of intervals within that chord.
     * @param chord the int[] representing the current chord
     * @return an array of intervals within the chord
     */
    public static int[] findIntervals(int[] chord){
        int[] intervals = new int[chord.length-1];
        for(int i=0; i<chord.length-1; i++){
            intervals[i] = chord[i=1]-chord[i];
        }
        return intervals;
    }

    /**
     * Asks the user for the next note and converts it to an int
     * @return the int representing the next note
     */
    public static int newNote(){
        System.out.print("Next note: ");
        Scanner scan = new Scanner(System.in);
        String note = scan.next();
        for(int i = 0; i < notes.length; i++){
            if(note.equals(notes[i])){
                return i;
            }
        }
        System.out.println("Invalid Note");
        return(newNote());
    }

    /**
     * Converts the chord's int[] to a chord name
     * @param notes the notes within the chord
     * @return a string of the chord name
     */
    public static String chord(int[] notes){
        int size = 0;
        for(int i=0; i<notes.length; i++){
            if(notes[i]>0){
                size++;
            }
        }
        int count = 0;
        int[] chord = new int[size];
        for(int i=0; i<notes.length; i++){
            if(notes[i]>0){
                chord[count] = i;
                count++;
            }
        }
        //int[] intervals = findIntervals(chord);
        //if((chord.length == 2) && () ){
        //    return(numToNote(chord[0])+"5");
        //}
        if(
                (chord.length == 1) ||
                ((chord.length == 2) && (chord[1]-chord[0] == 4))||
                ((chord.length == 3) && (chord[1]-chord[0] == 4) && (chord[2]-chord[1]==3))
                )
            return(numToNote(chord[0]));
        if(
                (chord.length == 2 && (chord[1]-chord[0]== 8))||
                (chord.length == 3 && (chord[1]-chord[0]==5)&&(chord[2]-chord[1]==4))
                )
            return(numToNote(chord[1]));
        if(
                ((chord.length == 3) && (((chord[1]-chord[0] == 3) && (chord[2]-chord[1]==5))))
                )
            return(numToNote(chord[2]));

        if(
                ((chord.length == 2) && (chord[1]-chord[0] == 3))||
                ((chord.length == 3) && (((chord[1]-chord[0] == 3) && (chord[2]-chord[1]==4))))
                )
            return(numToNote(chord[0])+"min");
        if(
                (chord.length == 2 && (chord[1]-chord[0]== 9))||
                (chord.length == 3 && (chord[1]-chord[0]==4)&&(chord[2]-chord[1]==4))
                )
            return(numToNote(chord[1])+"min");
        if(
                ((chord.length == 3) &&(chord[1]-chord[0]==4)&&(chord[2]-chord[1]==5))
                )
            return(numToNote(chord[2])+"min");

        if (
                (chord.length == 2 && (chord[1]-chord[0]== 10)) ||
                (chord.length == 3 && (chord[1]-chord[0]==4)&&(chord[2]-chord[0]==10))||
                (chord.length == 4 && (chord[1]-chord[0]==4)&&(chord[3]-chord[0]==10)&&(chord[2]-chord[1]==3))
                )
            return(numToNote(chord[0])+"7");
        if (
                (chord.length == 2 && (chord[1]-chord[0]== 2))
                )
            return(numToNote(chord[1])+"7");
        return("Unknown Chord");


    }

    /**
     * Converts a number back to a note
     * @param num the number to be converted
     * @return a string of the note name
     */
    public static String numToNote(int num){
        return (notes[num]);
    }
    public static void main(String[] args){
        makeChord();
    }

}
