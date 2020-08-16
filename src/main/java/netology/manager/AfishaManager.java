package netology.manager;

import netology.domain.Movie;
import netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository afishaRepository;

    public AfishaManager(AfishaRepository afishaRepository) {
        this.afishaRepository = afishaRepository;
    }

    public void add(Movie item) {
        afishaRepository.save(item);
    }

    public Movie[] getAll() {
        Movie[] items = afishaRepository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int filmId) {
        afishaRepository.removeById(filmId);
    }

    public void findById(int filmId) {
        afishaRepository.findById(filmId);
    }

    public void removeAll() {
        afishaRepository.removeAll();
    }
}
