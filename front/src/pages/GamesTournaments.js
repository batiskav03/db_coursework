// GamesTournamentsPage.js
import React from 'react';
import AddTournamentComponent from '../components/AddTournamentComponent';
import SetWinnerComponent from '../components/SetTournamentsWinner';
import ViewTournamentComponent from '../components/ViewTournamentComponent';
import ViewGamesComponent from '../components/ViewGamesComponent';

const GamesTournamentsPage = () => {
  return (
    <div>
      <table>
        <tr>
            <td>
                <div className='AddTournament'>
                    <AddTournamentComponent/>
                </div>
            </td>
            <td>
                <div className='SettournamentsWinner'>
                    <SetWinnerComponent/>
                </div>
            </td>
            <td>
                <div className='ViewTournaments'>
                    <ViewTournamentComponent/>
                </div>
            </td>
        </tr>
            <td>
                <div className='ViewGames'>
                    <ViewGamesComponent/>
                </div>
            </td>
            <td>
                <div className='getTbC'>
                    
                </div>
            </td>
            <td>
                <div className='getTbC'>
                    
                </div>
            </td>
        <tr>
            <td>
                <div className='addPl'>
                    
                </div>
            </td>
        </tr>  
        
        </table>
    </div>
  );
};

export default GamesTournamentsPage;
