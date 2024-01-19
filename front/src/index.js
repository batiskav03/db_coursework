import React from 'react';
import ReactDOM from 'react-dom';
import TeamComponent from './components/TeamComponent';
import TeamsByGameComponent from './components/TeamsByGameComponent';

ReactDOM.render(
  <React.StrictMode>
    <TeamComponent />
    <TeamsByGameComponent/>
  </React.StrictMode>,
  document.getElementById('root')
);