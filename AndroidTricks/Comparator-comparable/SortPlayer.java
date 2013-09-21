package com.javmonisu.futgolf.javaClass;


/**
 * Created by javier on 21/09/13.
 */
public class SortPlayer extends Player implements Comparable<SortPlayer> {
    public SortPlayer(int id) {
        super(id);
    }
    @Override
    public int compareTo(SortPlayer another) {
        return this.getScore() - another.getScore();
    }
}
