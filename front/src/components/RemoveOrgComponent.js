import React, { useState, useEffect } from 'react';

const OrgDeleteComponent = () => {
  const [name, setNickname] = useState('');
var resp = '';

  const callOrgDelete = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/remOrg', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name }),
      });

      if (response.ok) {
        resp = "Done!";
      } else {
        resp = "Failed!";
      }
    } catch (error) {
      console.error('Произошла ошибка:', error);
    }
  };

  useEffect(() => {
  }, []); 
  return (
    <div>
      <h1>Organization Delete Component</h1>
      <div>
        <label>Nickname: </label>
        <input type="text" value={name} onChange={(e) => setNickname(e.target.value)} />
      </div>
      <button onClick={callOrgDelete}>Call playerDelete</button>

      {/* Отображение данных из базы */}
      <div>
        <h2>Result</h2>
        <div>{resp}</div>
      </div>
    </div>
  );
};

export default OrgDeleteComponent;
