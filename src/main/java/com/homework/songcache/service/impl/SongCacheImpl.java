package com.homework.songcache.service.impl;

import com.homework.songcache.service.SongCache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SongCacheImpl implements SongCache {
    private Map<String, Integer> songCache = new ConcurrentHashMap<>();

    @Override
    public void recordSongPlays(String songId, int numPlays) {
        songCache.put(songId, songCache.getOrDefault(songId, 0) + numPlays);
    }

    @Override
    public int getPlaysForSong(String songId) {
        int res = songCache.get(songId) == null ? (-1) : songCache.get(songId);
        return res;
    }

    @Override
    public List<String> getTopNSongsPlayed(int n) {
        List<String> res = songCache.entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue(), Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet().stream().toList();
        return res;
    }
}
