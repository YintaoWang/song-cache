package com.homework.songcache.test;

import com.homework.songcache.service.SongCache;
import com.homework.songcache.service.impl.SongCacheImpl;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;

public class SongCacheTest {
    @Test
    public void cacheIsWorking() {
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);
        assertThat(cache.getPlaysForSong("ID-1"), is(4));
        assertThat(cache.getPlaysForSong("ID-9"), is(-1));
        assertThat(cache.getTopNSongsPlayed(2), contains("ID-3", "ID-1"));
//        assertThat(cache.getTopNSongsPlayed(2).toString(), allOf(containsString("ID-3"), containsString("ID-1")));
        assertThat(cache.getTopNSongsPlayed(0), is(empty()));
//        assertThat(cache.getTopNSongsPlayed(0).isEmpty(), is(true));
    }
}
