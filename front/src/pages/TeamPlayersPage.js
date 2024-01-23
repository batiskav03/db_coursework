// TeamsPlayersPage.js
import React from 'react';
import AddOrgComponent from '../components/AddOrgComponent';
import AddTeamComponent from '../components/AddTeamComponent';
import TeamsByGameComponent from '../components/TeamsByGameComponent';

import "../styles/TeamPlayerPage.css";
import PlayerDeleteComponent from '../components/PlayerDeleteComponent';
import RemoveOrgComponent from '../components/RemoveOrgComponent';
import ViewOrgsComponent from '../components/ViewOrgsComponent';
import TeamComponent from '../components/TeamComponent';
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
            <td>
                <div className='AddOrg'>
                <RemoveOrgComponent/>
                </div>
            </td>
            <td>
                <div className='ViewOrg'>
                <ViewOrgsComponent/>
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
            <div className='getT'>
                    <TeamComponent/>
                </div>
            </td>
        <tr>
            <td>
            <div className='getRmPl'>
                    <PlayerDeleteComponent/>
                </div>
            </td>
        </tr>  
        
        </table>
        </div>
  );
};

export default TeamsPlayersPage;
