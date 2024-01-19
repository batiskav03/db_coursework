import React from 'react';
import ReactDOM from 'react-dom';
import TeamComponent from './components/TeamComponent';
import TeamsByGameComponent from './components/TeamsByGameComponent';
import PlayerDeleteComponent from './components/PlayerDeleteComponent';

ReactDOM.render(
  <React.StrictMode>
    <TeamComponent />
    <TeamsByGameComponent />
    <PlayerDeleteComponent />
  </React.StrictMode>,
  document.getElementById('root')
);