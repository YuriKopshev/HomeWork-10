package netology.manager;

import netology.domain.Movie;
import netology.repository.AfishaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository afishaRepository;
    @InjectMocks
    private AfishaManager afishaManager;
    private Movie movie1 = new Movie(2, "Terminator 2", "Action");
    private Movie movie2 = new Movie(3, "Batman", "Action");
    private Movie movie3 = new Movie(4, "Number One", "Comedy");


    @Test
    void add() {
        Movie movie5 = new Movie(6, "Green Mile", "Drama");
        Movie[] returned = new Movie[]{movie5};
        doReturn(returned).when(afishaRepository).findAll();
        afishaManager.add(movie5);
        Movie[] actual = afishaManager.getAll();
        Movie[] expected = new Movie[]{movie5};
        assertArrayEquals(actual, expected);

    }

    @Test
    void getAll() {
        Movie[] returned = new Movie[]{movie1, movie2, movie3};
        doReturn(returned).when(afishaRepository).findAll();
        Movie[] actual = afishaManager.getAll();
        Movie[] expected = new Movie[]{movie3, movie2, movie1};
        assertArrayEquals(actual, expected);

    }

    @Test
    void removeById() {
        Movie[] returned = new Movie[]{movie2, movie3};
        doReturn(returned).when(afishaRepository).findAll();
        doNothing().when(afishaRepository).removeById(2);
        afishaManager.removeById(2);
        Movie[] actual = afishaManager.getAll();
        Movie[] expected = new Movie[]{movie3, movie2};
        assertArrayEquals(actual, expected);


    }

    @Test
    void findById() {
        Movie[] returned = new Movie[]{movie2};
        doReturn(returned).when(afishaRepository).findAll();
        afishaManager.findById(4);
        Movie[] actual = afishaManager.getAll();
        Movie[] expected = new Movie[]{movie2};
        assertArrayEquals(actual, expected);

    }

    @Test
    void removeAll() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(afishaRepository).findAll();
        afishaManager.removeAll();
        Movie[] actual = afishaManager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(actual, expected);
    }
}