// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import TeamsPlayersPage from './pages/TeamPlayersPage';
import GamesTournamentsPage from './pages/GamesTournaments';
import OtherPage from './pages/OtherPage';
import LoginPage from './pages/LoginPage';
import LogoutButton from './components/LogoutButton';
import Logo from './components/Logo';
import Captcha from './components/Captcha';
import AdminPanel from './components/AdminPanel';
import "./App.css";

const App = () => {
  return (
    <Router>
      <div className='m'>
        <Logo />
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
              <td>
                <Link to={"/login"}>Login</Link>
              </td>
              <td>
                <LogoutButton />
              </td>
              <td>
                <Link to={"/admin"}>Admin Panel</Link>
              </td>
            </tr>
          </table>
        </nav>

        <Routes>
          <Route path="/teams-players" element={<TeamsPlayersPage />} />
          <Route path="/games-tournaments" element={<GamesTournamentsPage />} />
          <Route path="/other" element={<OtherPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/captcha" element={<Captcha />} />
          <Route path="/admin" element={<AdminPanel />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
