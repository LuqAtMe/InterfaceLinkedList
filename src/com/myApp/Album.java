package com.myApp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String albumName, String artist) {

        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String songName) {
        for (Song checkSong : songs) {
            if (checkSong.getName().equals(songName)) {
                return checkSong;
            }
        }
        return null;
    }

    public boolean addSong(String songName, double dongDuration) {
        Song toCheck = findSong(songName);
        if (toCheck == null) {
            this.songs.add(new Song(songName, dongDuration));
            return true;
        }
        return false;

    }

    public boolean addToPlayList(int trackNumber, List<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song checkSong = findSong(title);
        if (checkSong != null) {
            playList.add(checkSong);
            return true;
        }
        System.out.println("The song " + title + " is not this album");
        return false;
    }
}
