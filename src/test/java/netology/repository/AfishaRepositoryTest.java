package netology.repository;

import netology.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();
    private Movie movie1 = new Movie(2, "Terminator 2", "Action");
    private Movie movie2 = new Movie(3, "Batman", "Action");
    private Movie movie3 = new Movie(4, "Number One", "Comedy");


    @BeforeEach
    public void setUp() {
        afishaRepository.save(movie1);
        afishaRepository.save(movie2);
        afishaRepository.save(movie3);
    }


    @Test
    void findAll() {
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = new Movie[]{movie1, movie2, movie3};
        assertArrayEquals(actual, expected);
    }


    @Test
    void ShouldSaveAndFindById() {
        Movie actual = afishaRepository.findById(3);
        Movie expected = movie2;
        assertEquals(actual, expected);
        Movie actual2 = afishaRepository.findById(6);
        Movie expected2 = null;
        assertEquals(actual2, expected2);

    }

    @Test
    void removeById() {
        afishaRepository.removeById(2);
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = new Movie[]{movie2, movie3};
        assertArrayEquals(actual, expected);

    }

    @Test
    void removeAll() {
        Movie[] actual = afishaRepository.removeAll();
        Movie[] expected = new Movie[actual.length];
        assertArrayEquals(actual, expected);
    }
}