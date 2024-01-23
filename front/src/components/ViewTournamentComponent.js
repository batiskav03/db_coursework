import React, { useState, useEffect } from 'react';

import "../styles/AddOrg.css"

var resp;
const ViewTournamentComponent = () => {
  const [name, setName] = useState('');
  const [tourInfo, setTourInfo] = useState([]);

  const callSetWinner = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/viewTour', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name}),
        
      });
      if (response.ok) {
        const data = await response.json();
        
        setTourInfo(data); 
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
      <h1>View Tournament Component</h1>
      <div className='input-text'>
        <label>Tournament name: </label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <button onClick={callSetWinner}>Call addOrg</button>
      <div>
        <h2>Info about {name}</h2>
        <ul>
          {tourInfo.map((tour, index) => (
            <div key={index}>{tour}</div>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ViewTournamentComponent;
