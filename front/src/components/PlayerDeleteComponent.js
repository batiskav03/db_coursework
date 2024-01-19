import React, { useState, useEffect } from 'react';

const PlayerDeleteComponent = () => {
  const [nickname, setNickname] = useState('');
var resp = '';

  const callPlayerDelete = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/deletePlayer', {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nickname }),
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
    // Вызовите функцию, если необходимо при загрузке компонента
    // callGetTeamPlayers();
  }, []); // Пустой массив зависимостей означает, что эффект вызывается только при монтировании компонента

  return (
    <div>
      <h1>Player Delete Component</h1>
      <div>
        <label>Nickname: </label>
        <input type="text" value={nickname} onChange={(e) => setNickname(e.target.value)} />
      </div>
      <button onClick={callPlayerDelete}>Call playerDelete</button>

      {/* Отображение данных из базы */}
      <div>
        <h2>Result</h2>
        <div>{resp}</div>
      </div>
    </div>
  );
};

export default PlayerDeleteComponent;
