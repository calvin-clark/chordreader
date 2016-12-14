import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
    public static int[] findIntervals(int[] chord){
        int[] intervals = new int[chord.length-1];
        for(int i=0; i<chord.length-1; i++){
            intervals[i] = chord[i=1]-chord[i];
        }
        return intervals;
    }
    public static int newNote(){
        System.out.print("Next note: ");
        Scanner scan = new Scanner(System.in);
        String note = scan.next();
        if(note.equals("C") || note.equals("B#"))
            return 0;
        if(note.equals("C#") || note.equals("Db"))
            return 1;
        if(note.equals("D"))
            return 2;
        if(note.equals("D#") || note.equals("Eb"))
            return 3;
        if(note.equals("E") || note.equals("Fb"))
            return 4;
        if(note.equals("F") || note.equals("E#"))
            return 5;
        if(note.equals("F#") || note.equals("Gb"))
            return 6;
        if(note.equals("G"))
            return 7;
        if(note.equals("G#") || note.equals("Ab"))
            return 8;
        if(note.equals("A"))
            return 9;
        if(note.equals("A#") || note.equals("Bb"))
            return 10;
        if(note.equals("B") || note.equals("Cb"))
            return 11;
        System.out.println("Invalid Note");
        return newNote();

    }
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
    public static String numToNote(int num){
        if(num == 0)
            return("C/B#");
        if(num == 1)
            return("C#/Db");
        if(num == 2)
            return("D");
        if(num == 3)
            return("D#/Eb");
        if(num == 4)
            return("E/Fb");
        if(num == 5)
            return("F/E#");
        if(num == 6)
            return("F#/Gb");
        if(num == 7)
            return("G");
        if(num == 8)
            return("G#/Ab");
        if(num == 9)
            return("A");
        if(num == 10)
            return("A#/Bb");
        if(num == 11)
            return("B/Cb");
        else
            return "Invalid Note";
    }
    public static void main(String[] args){
        makeChord();
    }

}
