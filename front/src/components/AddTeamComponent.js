import React, { useState, useEffect } from 'react';


var resp;
const AddTeamComponent = () => {
  const [name, setParam1] = useState('');
  const [game, setParam2] = useState('');
  const [ttl_win, setParam3] = useState('');
  const [region, setParam4] = useState('');

  const callGetTeamPlayers = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addTeam', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, game, ttl_win, region}),
      });

      if (response.ok) {
        resp = 'Done!';
        console.log('Done!');
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
      <h1>Add Team Component</h1>
      <div>
        <label>Team name: </label>
        <input type="text" value={name} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Team game: </label>
        <input type="text" value={game} onChange={(e) => setParam2(e.target.value)} />
      </div>
      <div>
        <label>Team total:    </label>
        <input type="text" value={ttl_win} onChange={(e) => setParam3(e.target.value)} />
      </div>
      <div>
        <label>Team region: </label>
        <input type="text" value={region} onChange={(e) => setParam4(e.target.value)} />
      </div>
      <button onClick={callGetTeamPlayers}>Call addTeamPlayers</button>
      <div>
        <h2>Result</h2>
        <div>{resp}</div>
      </div>
    </div>
  );
};

export default AddTeamComponent;
