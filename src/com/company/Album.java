package com.company;


import java.security.AlgorithmConstraints;
import java.util.List;

public class Album  implements Comparable<Album>{
    int year;
    String name;
    String band;
    genre genre;

    public Album(String band, String name, int year, genre genre){
        this.band = band;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public String printAlbum(){
        return (band + " - " + name + "(" +year+ ")" + " || Genre: " + genre);
    }

    public String printToFile() {
        int returnGenre;
        if (genre == genre.METAL)
            returnGenre = 0;
        else if (genre == genre.ROCK)
            returnGenre = 1;
        else
            returnGenre = 9;



        return band +"\n"+ name+"\n"+year+"\n"+returnGenre+"\n";
    }

    public genre returnGenre(){
        return genre;
    }

    @Override
    public int compareTo(Album o) {
        int compareName = this.band.compareTo(o.band);

        if(compareName == 0)
            return this.name.compareTo(o.name);
        else
            return compareName;
        }
    }

enum genre{
    ROCK(0), METAL(1), UNKNOW(9);
    genre(int n) {
       int  number = n;
}
}


