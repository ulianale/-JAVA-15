import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;

public class GameTest {
    Game s = new Game();
    Player player1 = new Player(1, "a", 10);
    Player player2 = new Player(2, "b", 100);
    Player player3 = new Player(3, "c", 10);

    @BeforeEach
    public void setup() {
        s.register(player1);
        s.register(player2);
        s.register(player3);
    }

    @Test
    public void test1() {
        int expected = 2;
        int actual = s.round("a", "b");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int expected = 0;
        int actual = s.round("a", "c");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int expected = 1;
        int actual = s.round("b", "c");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            s.round("v", "b");
        });
    }

    @Test
    public void test5() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            s.round("a", "v");
        });
    }

    @Test
    public void test6() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            s.round("v", "v");
        });
    }



}
