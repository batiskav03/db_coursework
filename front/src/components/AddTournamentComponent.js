import React, { useState, useEffect } from 'react';

const AddTeamComponent = () => {
  const [name, setParam1] = useState('');
  const [prizepool, setParam2] = useState('');
  const [game, setParam3] = useState('');
  const [country, setParam4] = useState('');
  const [winner_name, setParam5] = useState('');

  const callAddTournament = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addTournament', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, prizepool, game, country, winner_name }),
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
        <input type="text" value={name} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Prize pool: </label>
        <input type="text" value={prizepool} onChange={(e) => setParam2(e.target.value)} />
      </div>
      <div>
        <label>Game:    </label>
        <input type="text" value={game} onChange={(e) => setParam3(e.target.value)} />
      </div>
      <div>
        <label>Tournament country: </label>
        <input type="text" value={country} onChange={(e) => setParam4(e.target.value)} />
      </div>
      <div>
        <label>Winner: </label>
        <input type="text" value={winner_name} onChange={(e) => setParam5(e.target.value)} />
      </div>
      <button onClick={callAddTournament}>Call addTournament</button>
    </div>
  );
};

export default AddTeamComponent;
