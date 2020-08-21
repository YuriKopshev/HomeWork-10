package netology.manager;


import netology.domain.Movie;


public class PosterManager {
    int moviesCount = 10;


    public PosterManager() {
    }

    public PosterManager(int moviesCount) {
        this.moviesCount = moviesCount;
    }

    private Movie[] movies = new Movie[0];


    public void add(Movie movie) {
        Movie[] poster = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, poster, 0, movies.length);
        int lastIndex = poster.length - 1;
        poster[lastIndex] = movie;
        movies = poster;

    }

    public Movie[] getMovies() {
        int count = moviesCount;
        if (moviesCount > movies.length) {
            count = movies.length;
        }
        Movie[] result = new Movie[count];
        for (int i = 0; i < count; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }


}
