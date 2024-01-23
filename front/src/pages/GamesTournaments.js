// GamesTournamentsPage.js
import React from 'react';
import AddTournamentComponent from '../components/AddTournamentComponent';

const GamesTournamentsPage = () => {
  return (
    <div>
      <h2>Games and Tournaments Page</h2>
      <table>
        <tr>
            <td>
                <div className='AddTournament'>
                    <AddTournamentComponent/>
                </div>
            </td>
        </tr>
            <td>
                <div className='AddTeam'>
                    
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
