//Lack package

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by javier on 19/09/13.
 */
public class Information implements Parcelable{
    private int numberOfPlayers;
    private int actualPlayer;
    private int actualHole;
    private int numberOfHoles;

    public Information(int numberOfPlayers, int actualPlayer, int actualHole, int numberOfHoles) {
        this.numberOfPlayers = numberOfPlayers;
        this.actualPlayer = actualPlayer;
        this.actualHole = actualHole;
        this.numberOfHoles = numberOfHoles;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(int actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public int getActualHole() {
        return actualHole;
    }

    public void setActualHole(int actualHole) {
        this.actualHole = actualHole;
    }

    public int getNumberOfHoles() {
        return numberOfHoles;
    }

    public void setNumberOfHoles(int numberOfHoles) {
        this.numberOfHoles = numberOfHoles;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberOfPlayers);
        dest.writeInt(actualPlayer);
        dest.writeInt(actualHole);
        dest.writeInt(numberOfHoles);
    }

    public Information(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel){
            numberOfPlayers = parcel.readInt();
            actualPlayer = parcel.readInt();
            actualHole = parcel.readInt();
            numberOfHoles = parcel.readInt();
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
                public Information createFromParcel(Parcel in) {
                    return new Information(in);
                }

                public Information[] newArray(int size) {
                    return new Information[size];
                }
            };
}
