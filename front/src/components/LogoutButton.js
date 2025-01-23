import React from 'react';
import { useNavigate } from 'react-router-dom';

const LogoutButton = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        // Здесь вы можете добавить логику для выхода (например, очистка токена)
        console.log('User logged out');
        navigate('/login'); // Перенаправляем на страницу логина
    };

    return (
        <button onClick={handleLogout}>
            Logout
        </button>
    );
};

export default LogoutButton; 