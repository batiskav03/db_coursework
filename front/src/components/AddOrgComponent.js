import React, { useState, useEffect } from 'react';

import "../styles/AddOrg.css"
const AddOrgComponent = () => {
  const [name, setName] = useState('');
  const [disc, setDesc] = useState('');

  const callAddOrg = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/addOrg', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, disc }),
        
      });
      console.log(name, disc);
      if (response.ok) {
        const data = await response.json();
        console.log(data); 
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
    <div className='orgMain'>
      <h1>Org Component</h1>
      <div className='input-text'>
        <label>Org Name: </label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <div className='input-text'>
        <label>Org Desc: </label>
        <input type="text" value={disc} onChange={(e) => setDesc(e.target.value)} />
      </div>
      <button onClick={callAddOrg}>Call addOrg</button>
    </div>
  );
};

export default AddOrgComponent;
