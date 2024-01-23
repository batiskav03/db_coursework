import React, { useState, useEffect } from 'react';

const ViewPlayersComponent = () => {
  const [players, setPlayers] = useState([]);

  const callSetPlayers = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/viewPlayers', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        const data = await response.json();
        setPlayers(data);
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
      <h1>Games View Component</h1>
      <button onClick={callSetPlayers}>Get!</button>
      <div>
        <h2> Organizations</h2>
        <ul>
          {players.map((team, index) => (
            <div key={index}>{team}</div>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ViewPlayersComponent;
