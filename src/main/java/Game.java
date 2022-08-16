import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playersList = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int s1 = 0; // счетчик для первого игрока
        int s2 = 0; // счетчик для второго игрока
        int a1 = 0;
        int a2 = 0;

        for (Player player : playersList) {
            if (player.getName().equals(playerName1)) {
                a1 = player.getStrength();
                s1++;
                break;
            }
        }
        for (Player player : playersList) {
            if (player.getName().equals(playerName2)) {
                a2 = player.getStrength();
                s2++;
                break;
            }
        }
        if (s1 == 1 && s2 == 1) {
            if (a1 > a2) {
                    return 1;
                } else if(a1 < a2) {
                    return 2;
                } else {
                    return 0;
                }
        } else if(s1 > s2) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
        } else if(s1 < s2) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован!"
            );
        } else {
            throw new NotRegisteredException(
                    "Игроки не зарегистрированы!"
            );
        }
    }

}
