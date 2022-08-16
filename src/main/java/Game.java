import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {

        if (players.containsKey(playerName1) && players.containsKey(playerName2)) {
            if (players.get(playerName1) > players.get(playerName2)) {
                return 1;
            }
            else if (players.get(playerName1) < players.get(playerName2)) {
                return 2;
            } else {
                return 0;
            }
        } else {
            throw new NotRegisteredException(
                    "Игрок(и) не зарегистрирован(ы)"
            );
        }
    }

}
