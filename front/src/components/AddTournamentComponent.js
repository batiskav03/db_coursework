import React, { useState, useEffect } from 'react';

const AddTeamComponent = () => {
  const [tour_name, setParam1] = useState('');
  const [tour_prize_pool, setParam2] = useState('');
  const [game_name, setParam3] = useState('');
  const [country_name, setParam4] = useState('');
  const [winner_team_name, setParam5] = useState('');

  const callAddTournament = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addTournament', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ tour_name, tour_prize_pool, game_name, country_name, winner_team_name }),
      });

      if (response.ok) {
        console.log('Done!')
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
      <h1>Add Tournament</h1>
      <div>
        <label>Tournament name: </label>
        <input type="text" value={tour_name} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Prize pool: </label>
        <input type="text" value={tour_prize_pool} onChange={(e) => setParam2(e.target.value)} />
      </div>
      <div>
        <label>Team total:    </label>
        <input type="text" value={game_name} onChange={(e) => setParam3(e.target.value)} />
      </div>
      <div>
        <label>Team region: </label>
        <input type="text" value={country_name} onChange={(e) => setParam4(e.target.value)} />
      </div>
      <div>
        <label>Team region: </label>
        <input type="text" value={winner_team_name} onChange={(e) => setParam5(e.target.value)} />
      </div>
      <button onClick={callAddTournament}>Call addTournament</button>
    </div>
  );
};

export default AddTeamComponent;
