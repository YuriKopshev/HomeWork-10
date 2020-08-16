package netology.repository;

import netology.domain.Movie;

public class AfishaRepository {
    private Movie[] items = new Movie[0];

    public Movie[] findAll() {
        return items;
    }


    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie findById(int filmId) {
        for (Movie item : items) {
            if (item.getFilmId() == filmId)
                return item;
        }
        return null;
    }

    public void removeById(int filmId) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getFilmId() != filmId) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Movie[] removeAll() {
        Movie[] tmp = new Movie[items.length];
        items = tmp;
        return items;
    }
}
