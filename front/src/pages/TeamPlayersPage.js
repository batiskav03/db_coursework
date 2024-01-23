// TeamsPlayersPage.js
import React from 'react';
import AddOrgComponent from '../components/AddOrgComponent';
import AddTeamComponent from '../components/AddTeamComponent';
import TeamsByGameComponent from '../components/TeamsByGameComponent';

import "../styles/TeamPlayerPage.css";
import PlayerDeleteComponent from '../components/PlayerDeleteComponent';
const TeamsPlayersPage = () => {
  return (
    <div className='main'>
      <h2 className='header-page'>Teams Operations</h2>
      <table>
        <tr>
            <td>
                <div className='AddOrg'>
                <AddOrgComponent/>
                </div>
            </td>
        </tr>
            <td>
                <div className='AddTeam'>
                    <AddTeamComponent/>
                </div>
            </td>
            <td>
                <div className='getTbC'>
                    <TeamsByGameComponent/>
                </div>
            </td>
            <td>
                <div className='getTbC'>
                    <PlayerDeleteComponent/>
                </div>
            </td>
        <tr>
            <td>
                <div className='addPl'>
                    <AddTeamComponent/>
                </div>
            </td>
        </tr>  
        
        </table>
        </div>
  );
};

export default TeamsPlayersPage;
