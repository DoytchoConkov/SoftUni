package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public int count() {
        return this.roster.size();
    }

    public boolean removePlayer(String player) {
        boolean isExist = false;
        Player removePlayer = null;
        for (Player currentPlayer : this.roster) {
            if (currentPlayer.getName().equals(player)) {
                isExist = true;
                removePlayer = currentPlayer;
                break;
            }
        }
        if (isExist) {
            this.roster.remove(removePlayer);
        }
        return isExist;

    }

    public void promotePlayer(String player) {
        for (Player currentPlayer : this.roster) {
            if (currentPlayer.getName().equals(player)) {
                currentPlayer.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String player) {
        for (Player currentPlayer : this.roster) {
            if (currentPlayer.getName().equals(player)) {
                currentPlayer.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] result = this.roster.stream().filter(e -> e.getClazz().equals(clazz)).toArray(Player[]::new);
        for (Player player : result) {
            this.roster.remove(player);
        }
        return result;
    }

    public String report() {
        String result = String.format("%nPlayers in the guild: %s:%n", this.name);
        for (Player currentPlayer : this.roster) {
            result += currentPlayer.toString() + "\n";
        }
        return result;
    }
}
