import React, { useState, useEffect } from 'react';

import "../styles/AddOrg.css"

var resp;
const SetWinnerComponent = () => {
  const [name, setName] = useState('');
  const [winner, setDesc] = useState('');

  const callSetWinner = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/setWinner', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, winner }),
        
      });
      console.log(name, winner);
      if (response.ok) {
        const data = await response.json();
        console.log(response); 
        resp = 'Done!';
      } else {
        resp = 'Done!';
        console.error('Ошибка при вызове API');
      }
    } catch (error) {
      console.error('Произошла ошибка:', error);
    }
  };

  useEffect(() => {
  }, []);
  return (
    <div className='orgMain'>
      <h1>Set Winner Component</h1>
      <div className='input-text'>
        <label>Tournament Name: </label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <div className='input-text'>
        <label>Winner: </label>
        <input type="text" value={winner} onChange={(e) => setDesc(e.target.value)} />
      </div>
      <button onClick={callSetWinner}>Call addOrg</button>
      <div>
        <h2>Result</h2>
        <div>{resp === 'Done!' && <p>Done!  </p>}</div>
      </div>
    </div>
  );
};

export default SetWinnerComponent;
