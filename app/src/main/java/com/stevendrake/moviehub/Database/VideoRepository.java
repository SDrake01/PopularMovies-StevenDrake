package com.stevendrake.moviehub.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.stevendrake.moviehub.MovieData;

import java.util.List;

/**
 * Created by calebsdrake on 8/6/2018.
 */

public class VideoRepository {

    private LiveData<List<Video>> repoSelectedVideos;

    public VideoRepository(Application application){
        String requestId = MovieData.videoFilmId;
        FilmDatabase videosRepoDb = FilmDatabase.getDatabase(application);
        VideoDao repoVideoDao = videosRepoDb.videoDao();
        repoSelectedVideos = repoVideoDao.getSelectedVideos(requestId);
    }

    public LiveData<List<Video>> getRepoSelectedVideos(){
        return repoSelectedVideos;
    }
}
