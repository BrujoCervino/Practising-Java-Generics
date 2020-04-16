import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<TTeamType extends Team> {

    String name;
    ArrayList<TTeamType> teams = new ArrayList<>();

    LeagueTable(final String inName) {
        name = inName;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(TTeamType inTeam) {
        if(null == inTeam || teams.contains(inTeam)) {
            System.out.printf("Failed to add team to League: %s.%n", getName());
            return false;
        }
        teams.add(inTeam);
        System.out.printf("Added team: %s to League: %s.%n", inTeam.getName(), getName());
        return true;
    }

    public void printLeague() {
        Collections.sort(teams);
        for(TTeamType team : teams) {
            if(null != team){
                System.out.printf("%s is ranked at:  %d %n", team.getName(), team.ranking());
            }
        }
    }
}
