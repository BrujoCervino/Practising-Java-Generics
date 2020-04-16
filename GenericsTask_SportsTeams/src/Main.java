// Assignment: Practising Generics: (Solves Tim Buchalka's Java Programming Masterclass for Software Developers: Generics Challenge)
// ArrayList<Team> teams;
// Collections.sort(teams);
// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only a teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class Main {

    public static void main(String[] args) {
        // Football team: Manchester United

        FootballPlayer paulPogba = new FootballPlayer("Paul Pogba");
        FootballPlayer andreasPereira = new FootballPlayer("Andreas Pereira");
        FootballPlayer angelGomes = new FootballPlayer("Angel Gomes");

        Team<FootballPlayer> manchesterUnited = new Team<>("Manchester United");
        manchesterUnited.addPlayer(paulPogba);
        manchesterUnited.addPlayer(andreasPereira);
        manchesterUnited.addPlayer(angelGomes);

        // Football team: Chelsea

        FootballPlayer jorginho = new FootballPlayer("Jorginho");
        FootballPlayer nGoloKante = new FootballPlayer("N'Golo Kanté");
        FootballPlayer rossBarkley = new FootballPlayer("Ross Barkley");

        Team<FootballPlayer> chelsea = new Team<>("Chelsea");
        chelsea.addPlayer(jorginho);
        chelsea.addPlayer(nGoloKante);
        chelsea.addPlayer(rossBarkley);

        // Football team: Crystal Palace

        FootballPlayer lukaMilivojevic = new FootballPlayer("Luka Milivojević");
        FootballPlayer maxMeyer = new FootballPlayer("Max Meyer");
        FootballPlayer cheikhouKouyate = new FootballPlayer("Cheikhou Kouyaté");

        Team<FootballPlayer> crystalPalace = new Team<>("Crystal Palace");
        crystalPalace.addPlayer(lukaMilivojevic);
        crystalPalace.addPlayer(maxMeyer);
        crystalPalace.addPlayer(cheikhouKouyate);

        // British Football League Table
        LeagueTable<Team<FootballPlayer>> britishFootballLeagueTable =
                new LeagueTable<>("British Football League Table");

        britishFootballLeagueTable.addTeam(manchesterUnited);
        britishFootballLeagueTable.addTeam(chelsea);
        britishFootballLeagueTable.addTeam(crystalPalace);

        chelsea.matchResult(crystalPalace, 2, 4);
        manchesterUnited.matchResult(crystalPalace, 1, 3);
        crystalPalace.matchResult(chelsea, 4, 1);

        britishFootballLeagueTable.printLeague();
    }
}
