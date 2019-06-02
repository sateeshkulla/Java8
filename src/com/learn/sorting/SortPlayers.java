package com.learn.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPlayers {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player player = new Player("Yahoo", 18);
        players.add(player);
        player = new Player("Akshara", 11);
        players.add(player);
        player = new Player("Akshara", 02);
        players.add(player);
        player = new Player("Quick", 1802);
        players.add(player);
        player = new Player("Friday", 42);
        players.add(player);
        player = new Player("Friday", 11);
        players.add(player);
        for(Player palyer : players){
            System.out.println(palyer);
        }
        System.out.println("___________________");
        //Collections.sort(players, (s1, s2) -> s1.getName().length() - s2.getName().length());
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                if (player1.getScore() == player2.getScore()) {
                    return player1.getName().compareTo(player2.getName());
                }
                return player1.getScore() - player2.getScore();
            }
        });
        
        for(Player palyer : players){
            System.out.println(palyer);
        }

    }

}
