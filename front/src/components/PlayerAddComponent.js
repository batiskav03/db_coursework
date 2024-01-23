import React, { useState, useEffect } from 'react';



const PlayerAddComponent = () => {
  const [nickname, setParam1] = useState('');
  const [firstName, setParam2] = useState('');
  const [surname, setParam3] = useState('');
  const [birthDay, setParam4] = useState('');
  const [ttlWin, setParam5] = useState('');
  const [teamName, setParam6] = useState('');
  const [playerCountry, setParam7] = useState('');

  const callPlayerAdd = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addPlayer', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nickname, firstName, surname, birthDay, ttlWin, teamName, playerCountry}),
      });

      if (response.ok) {
        console.log({ nickname, firstName, surname, birthDay, ttlWin, teamName, playerCountry});
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
      <h1>Add Player Component</h1>
      <div>
        <label>Player nickname: </label>
        <input type="text" value={nickname} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Player Name: </label>
        <input type="text" value={firstName} onChange={(e) => setParam2(e.target.value)} />
      </div>
      <div>
        <label>Player Surname:    </label>
        <input type="text" value={surname} onChange={(e) => setParam3(e.target.value)} />
      </div>
      <div>
        <label>Player BirthDay: </label>
        <input type="text" value={birthDay} onChange={(e) => setParam4(e.target.value)} />
      </div>
      <div>
        <label>Player Total win: </label>
        <input type="text" value={ttlWin} onChange={(e) => setParam5(e.target.value)} />
      </div>
      <div>
        <label>Player Team: </label>
        <input type="text" value={teamName} onChange={(e) => setParam6(e.target.value)} />
      </div>
      <div>
        <label>Player country: </label>
        <input type="text" value={playerCountry} onChange={(e) => setParam7(e.target.value)} />
      </div>
      <button onClick={callPlayerAdd}>Call PlayerAdd</button>
    
    </div>
  );
};

export default PlayerAddComponent;
