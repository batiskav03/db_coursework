// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes} from 'react-router-dom';
import TeamsPlayersPage from './pages/TeamPlayersPage';
import GamesTournamentsPage from './pages/GamesTournaments';
import OtherPage from './pages/OtherPage';
import "./App.css";

const App = () => {
  return (
    <Router>
      <div className='m'>
        <nav>
          <table>
            <tr>
              <td>
              <Link to={"/teams-players"}>Teams and Players</Link>
              </td>
              <td>
              <Link to={"/games-tournaments"}>Games and Tournaments</Link>
              </td>
              <td> 
                <Link to={"/other"}>Other</Link>
              </td>
            </tr>
          </table>
        </nav>

        <Routes>
          <Route path="/teams-players" element={<TeamsPlayersPage/>}/>
          <Route path="/games-tournaments" element={<GamesTournamentsPage/>}/>
          <Route path="/other" element={<OtherPage/>}/>
        </Routes>
      </div>
    </Router>
  );
};

export default App;
