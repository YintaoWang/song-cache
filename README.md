# song-cache

1. for method recordSongPlays: use ConcurrentHashMap to store song plays.
2. for method getPlaysForSong: return the corresponding value of the key, if no such key exists, return -1.
3. for method getTopNSongsPlayed: use streamAPI to sort the map and get the result.
