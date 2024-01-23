import React, { useState, useEffect } from 'react';



const AddGameComponent = () => {
  const [name, setParam1] = useState('');
  const [desc, setParam2] = useState('');



  const callAddGame = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addGame', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, desc }),
      });

      if (response.ok) {
        console.log({ name });
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
      <h1>Add Game Component</h1>
      <div>
        <label>Game name: </label>
        <input type="text" value={name} onChange={(e) => setParam1(e.target.value)} />
      </div>
      <div>
        <label>Game description: </label>
        <input type="text" value={desc} onChange={(e) => setParam2(e.target.value)} />
      </div>
      
      <button onClick={callAddGame}>Call PlayerAdd</button>
    
    </div>
  );
};

export default AddGameComponent;
