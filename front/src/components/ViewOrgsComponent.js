import React, { useState, useEffect } from 'react';

const ViewOrgsComponent = () => {
  const [Orgs, setOrgs] = useState([]);

  const callGetTeamsByGame = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/viewOrgs', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        const data = await response.json();
        setOrgs(data);
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
      <h1>Orgs View Component</h1>
      <button onClick={callGetTeamsByGame}>Get!</button>
      <div>
        <h2> Organizations</h2>
        <ul>
          {Orgs.map((team, index) => (
            <div key={index}>{team}</div>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ViewOrgsComponent;
