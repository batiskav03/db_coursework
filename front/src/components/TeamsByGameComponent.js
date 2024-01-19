import React, { useState, useEffect } from 'react';

const TeamsByGameComponent = () => {
  const [gameName, setGameName] = useState('');
  const [teamsByGames, setTeamsByGame] = useState([]);

  const callGetTeamsByGame = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/getTeamsByGame', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ gameName }),
      });

      if (response.ok) {
        const data = await response.json();
        setTeamsByGame(data);
      } else {
        console.error('Ошибка при вызове API');
      }
    } catch (error) {
      console.error('Произошла ошибка:', error);
    }
  };

  useEffect(() => {
  }, []);

  return (
    <div>
      <h1>TeamsByGames Component</h1>
      <div>
        <label>Game: </label>
        <input type="text" value={gameName} onChange={(e) => setGameName(e.target.value)} />
      </div>

      <button onClick={callGetTeamsByGame}>Get!</button>
      <div>
        <h2>Teams by game {gameName}</h2>
        <ul>
          {teamsByGames.map((team, index) => (
            <li key={index}>{team}</li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default TeamsByGameComponent;
