###Documentation
#addPrizeForTeam Procedure
#Description
This procedure is designed to add a specified dollar prize to the total winnings of a given team.

#Parameters
teamID (int): The ID of the team to which the prize will be added.
dollarPrize (int): The amount of the prize in dollars.
#Usage
```
    sql
CALL addPrizeForTeam(teamID, dollarPrize);```
#startDateByNickname Function
#Description
This function retrieves the start date of a player based on their nickname.

#Parameters
nn (text): The nickname of the player.
#Returns
date: The start date of the player.
#Usage
```
    sql
SELECT startDateByNickname('player_nickname');```
#addPrizeForTeamNew Trigger Function
#Description
This trigger function is designed to automatically update the total winnings of a team when a new prize is added.

#Usage
This trigger function is invoked automatically when a new record is inserted into a table that it is associated with.

#getTeamNames Function
#Description
This function retrieves the names of teams associated with a specified game.

#Parameters
gameName (text): The name of the game.
#Returns
TABLE (_name TEXT): A table containing the names of teams.
#Usage
```
    sql
SELECT * FROM getTeamNames('game_name');```
#getTeamPlayers Function
#Description
This function retrieves the players' information for a specified team and game.

#Parameters
TEAM_NAME (TEXT): The name of the team.
GAME (TEXT): The name of the game.
#Returns
TEXT[][]: An array containing arrays of player information.
#Usage
```
    sql
SELECT * FROM getTeamPlayers('team_name', 'game_name');```
#getTeamAproxWin Function
#Description
This function retrieves the total approximate winnings of a specified team.

#Parameters
TEAM_NAME (TEXT): The name of the team.
#Returns
INTEGER: The total approximate winnings of the team.
#Usage
```
    sql
SELECT getTeamAproxWin('team_name');```
getPlayerAge Function
#Description
This function retrieves the age of a player based on their first name.

#Parameters
PLAYER_FIRST_NAME (TEXT): The first name of the player.
#Returns
interval: The age of the player.
#Usage
```
    sql
SELECT getPlayerAge('player_first_name');```
#getPlayerCountry Function
#Description
This function retrieves the country of a player based on various identifiers.

#Parameters
player_identifier (TEXT): The player's nickname, first name, or second name.
#Returns
TEXT: The country of the player.
#Usage
```
    sql
SELECT getPlayerCountry('player_identifier');```
#getPlayerTeam Function
#Description
This function retrieves the names of teams associated with a player based on their nickname, first name, or second name.

#Parameters
player_identifier (TEXT): The player's nickname, first name, or second name.
#Returns
SETOF TEXT: A set of team names.
#Usage
```
    sql
SELECT * FROM getPlayerTeam('player_identifier');```
#getTeamStuff Function
#Description
This function retrieves information about the staff associated with a specified team.

#Parameters
team_name (TEXT): The name of the team.
#Returns
TEXT[]: An array containing arrays of staff information.
#Usage
```
    sql
SELECT * FROM getTeamStuff('team_name');```
#getJobSalary Function
#Description
This function retrieves the salary associated with a specified job.

#Parameters
job_desc (TEXT): The description of the job.
#Returns
TEXT: The salary of the job.
#Usage
```
    sql
SELECT getJobSalary('job_description');```
#getTournamentsByGames Function
#Description
This function retrieves the names of tournaments associated with a specified game.

#Parameters
game (TEXT): The name of the game.
#Returns
TEXT[]: An array containing tournament names.
#Usage
sql
```
SELECT * FROM getTournamentsByGames('game_name');```
#getTeamsOnTournament Function
#Description
This function retrieves the names of teams participating in a specified tournament.

#Parameters
tournament_name (TEXT): The name of the tournament.
#Returns
TEXT[]: An array containing team names.
#Usage
```
    sql
SELECT * FROM getTeamsOnTournament('tournament_name');```
#deletePlayer Procedure
#Description
This procedure is designed to delete a player based on their nickname.

#Parameters
player_nick (TEXT): The nickname of the player.
#Usage
```
    sql
CALL deletePlayer('player_nickname');```
#addPlayer Procedure
#Description
This procedure is designed to add a new player with the specified details.

#Parameters
nick_name (TEXT): The nickname of the player.
first_name_pl (TEXT): The first name of the player.
second_name_pl (TEXT): The second name of the player.
birthday_date_pl (TEXT): The birthday of the player.
total_win (INTEGER): The total winnings of the player.
team_name (TEXT): The name of the team to which the player belongs.
player_country (TEXT): The country of the player.
#Usage
```
    sql
CALL addPlayer('nick_name', 'first_name', 'second_name', 'birthday_date', total_win, 'team_name', 'player_country');```
#getTournamentsOfATeam Function
#Description
This function retrieves the names of tournaments associated with a specified team.

#Parameters
team_name (TEXT): The name of the team.
#Returns
TEXT[]: An array containing tournament names.
#Usage
```
    sql
SELECT * FROM getTournamentsOfATeam('team_name');```
#addTournamentToATeam Procedure
#Description
This procedure is designed to associate a team with a specified tournament.

#Parameters
tm_name (TEXT): The name of the tournament.
team_name (TEXT): The name of the team.
#Usage
```
    sql
CALL addTournamentToATeam('tournament_name', 'team_name');```
#addTournament Procedure
#Description
This procedure is designed to add a new tournament with the specified details.

#Parameters
tour_name (TEXT): The name of the tournament.
tour_prize_pool (INT): The prize pool of the tournament.
game_name (TEXT): The name of the game associated with the tournament.
country_name (TEXT): The country where the tournament takes place.
winner_team_name (TEXT): The name of the winning team.
#Usage
```
    sql
CALL addTournament('tournament_name', tour_prize_pool, 'game_name', 'country_name', 'winner_team_name');```
#addOrg Procedure
#Description
This procedure is designed to add a new organization with the specified details.

#Parameters
org_name (TEXT): The name of the organization.
org_desc (TEXT): The description of the organization.
#Usage
```
    sql
CALL addOrg('organization_name', 'organization_description');```
#addGame Procedure
#Description
This procedure is designed to add a new game with the specified details.

#Parameters
game_name (TEXT): The name of the game.
org_desc (TEXT): The description of the game.
#Usage
```
    sql
CALL addGame('game_name', 'game_description');```
#addTeam Procedure
#Description
This procedure is designed to add a new team with the specified details.

#Parameters
org_name (TEXT): The name of the organization to which the team belongs.
game_name (TEXT): The name of the game associated with the team.
_total_win (INTEGER): The total winnings of the team.
region_name (TEXT): The name of the region associated with the team.
#Usage
```
    sql
CALL addTeam('organization_name', 'game_name', _total_win, 'region_name');```
#remOrg Procedure
#Description
This procedure is designed to remove an organization based on its name.

#Parameters
org_name (TEXT): The name of the organization to be removed.
#Usage
```
    sql
CALL remOrg('organization_name');```
#setTourWinner Procedure
#Description
This procedure is designed to set the winner of a specified tournament.

#Parameters
tour_name (TEXT): The name of the tournament.
winner_name (TEXT): The name of the winning organization.
#Usage
```
    sql
CALL setTourWinner('tournament_name', 'winner_organization_name');```
#getTourInfo Function
#Description
This function retrieves information about a specified tournament.

#Parameters
_tour_name (TEXT): The name of the tournament.
#Returns
TABLE (tour_name TEXT, prize_pool INTEGER, game_name TEXT, country_name TEXT, winner_name TEXT): Information about the tournament.
#Usage
```
    sql
SELECT * FROM getTourInfo('tournament_name');```
#getAllPlayers Function
#Description
This function retrieves information about all players.

#Returns
TEXT[]: An array containing information about all players.
#Usage
```
    sql
SELECT * FROM getAllPlayers();```




