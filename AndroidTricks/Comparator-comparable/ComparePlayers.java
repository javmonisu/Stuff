package com.javmonisu.futgolf.javaClass;

import java.util.Comparator;

/**
 * Created by javier on 21/09/13.
 */
public class ComparePlayers implements Comparator {

    @Override
    public int compare(Object lhs, Object rhs) {
        if(lhs instanceof SortPlayer && rhs instanceof SortPlayer){
            return ((SortPlayer) lhs).getScore() - ((SortPlayer) rhs).getScore();
        }
        return 0;
    }
}
