package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to my music world!");
        int choose = 1;
        List<Album> albumList = new LinkedList<>();
        genre[] GenresList = genre.values();
        File myFile = new File("data.txt");

        Scanner input = new Scanner(myFile);
        String readLineString = input.nextLine();
        int readLine = Integer.parseInt(readLineString);


        for (int i = 0; i < readLine; i++){
            String band, album, yearLine, type;
            int typeInt, year;
            genre type2;
            band = input.nextLine();
            album = input.nextLine();
            yearLine = input.nextLine();
            year = Integer.parseInt(yearLine);
            type = input.nextLine();
            typeInt = Integer.parseInt(type);
            if(typeInt == 0)
                type2 = genre.METAL;
            else if (typeInt == 1)
                type2 = genre.ROCK;
            else
                type2 = genre.UNKNOW;

            Album newAlbum = new Album(band, album, year, type2);
            albumList.add(newAlbum);
        }


        while (choose != 0) {
            System.out.println("Choose 1 to see all discography");
            System.out.println("Choose 2 to add a new album");
            System.out.println("Choose 3 to delete album");
            System.out.println("Choose 4 to delete all albums");
            System.out.println("Choose 0 to exit");
            Scanner chooseRead = new Scanner(System.in);
            choose = chooseRead.nextInt();

            if (choose == 1) {

                for (Album element : albumList) {
                    System.out.println(element.printAlbum());
                }
            } else if (choose == 2) {
                Scanner read = new Scanner(System.in);
                String band, album;
                int year, type;
                genre type2;
                System.out.println("Write band name: ");
                band = read.nextLine();
                System.out.println("Write album title: ");
                album = read.nextLine();
                System.out.println("Write year of realese: ");
                year = read.nextInt();
                System.out.println("Choose type of music: 0 if metal, 1 if rock: ");
                type = read.nextInt();

                if (type == 0)
                    type2 = genre.METAL;
                else if (type == 1)
                    type2 = genre.ROCK;
                else
                    type2 = genre.UNKNOW;

                Album newAlbum = new Album(band, album, year, type2);
                albumList.add(newAlbum);
                Collections.sort(albumList);
                System.out.println("Album has been added!");


            }
            else if (choose == 3){
                System.out.println("Which one album you want to delete? or 0 to exit");
                int i = 1;
                    for (Album element : albumList) {
                        System.out.println(i+"."+element.printAlbum());
                        i++;
                    }
                Scanner del = new Scanner(System.in);
                i = del.nextInt();
                if (i != 0)
                albumList.remove(i-1);
                }

            else if (choose == 4){
                System.out.println("Which one album you want to delete? or 0 to exit");
                for (int i = readLine; i > 0; i--) {
                    albumList.remove(i-1);
                }
            }

            else {
                PrintWriter save = new PrintWriter("data.txt");
                save.println(albumList.size());
                for (Album element : albumList) {
                    save.print(element.printToFile());
                }
                save.close();
            }
        }
    }
}



