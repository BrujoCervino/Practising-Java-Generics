import java.util.ArrayList;

public class Team<TPlayerType extends Player> implements Comparable<Team<TPlayerType>> {
    private String name;

    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<Player> members = new ArrayList<>();

    public Team(final String inName) {
        name = inName;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(Player player) {
        if(members.contains(player)) {
            System.out.printf("%s is already on team: %s.%n",player.getName(), getName());
            return false;
        } else {
            members.add(player);
            System.out.printf("%s picked for team.%n", player.getName());
            return true;
        }
    }

    public int numPlayers() {
        return members.size();
    }

    public void matchResult(Team opponent, int ourScore, int theirScore) {
        String message;
        if(ourScore > theirScore) {
            ++won;
            message = " beat ";
        } else if(ourScore == theirScore) {
            ++tied;
            message = " drew with ";
        } else {
            ++lost;
            message = " lost to ";
        }
        ++played;
        if(null != opponent) {
            System.out.printf("%s%s%s!%n", getName(), message, opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<TPlayerType> team) {
        return
            ( ranking() > team.ranking() ) ? -1
            : ( ranking() == team.ranking() ) ? 0
            : 1;
    }
}
