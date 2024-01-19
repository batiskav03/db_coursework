import React, { useState, useEffect } from 'react';

const TeamComponent = () => {
  const [param1, setParam1] = useState('');
  const [param2, setParam2] = useState('');
  const [teamPlayers, setTeamPlayers] = useState([]);

  const callGetTeamPlayers = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/getTeamPlayers', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ param1, param2 }),
      });

      if (response.ok) {
        const data = await response.json();
        console.log(data);
        setTeamPlayers(data); 
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
      <h1>Team Component</h1>
      <div>
        <label>Param1: </label>
        <input type="text" value={param1} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Param2: </label>
        <input type="text" value={param2} onChange={(e) => setParam2(e.target.value)} />
      </div>
      <button onClick={callGetTeamPlayers}>Call getTeamPlayers</button>

      
      <div>
        <h2>Team Players:</h2>
        <ul>
          {teamPlayers.flat().map((player) => (
            <li key={player}>{player}</li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default TeamComponent;
