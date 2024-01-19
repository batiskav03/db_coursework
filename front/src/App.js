import React from 'react';
import TeamComponent from './components/TeamComponent';
import TeamsByGameComponent from './components/TeamsByGameComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>My Team App</h1>
      </header>
      <main>
        <TeamComponent />
        <TeamsByGameComponent />
      </main>
    </div>
  );
}

export default App;