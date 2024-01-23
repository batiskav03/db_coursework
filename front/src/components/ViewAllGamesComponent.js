import React, { useState, useEffect } from 'react';

const ViewGamesComponent = () => {
  const [Games, setGames] = useState([]);

  const callGetGames = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/viewGames', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        const data = await response.json();
        setGames(data);
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
      <button onClick={callGetGames}>Get!</button>
      <div>
        <h2> Organizations</h2>
        <ul>
          {Games.map((team, index) => (
            <div key={index}>{team}</div>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ViewGamesComponent;
