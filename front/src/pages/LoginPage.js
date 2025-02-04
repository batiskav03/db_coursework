import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { GoogleLogin } from 'react-google-login';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [currentTime, setCurrentTime] = useState(new Date().toLocaleTimeString());

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/login', { username, password });
            const token = response.data; 
            localStorage.setItem('jwt', token); 
            console.log('Login successful:', token);
        } catch (err) {
            setError('Неверное имя пользователя или пароль');
            console.error('Login error:', err);
        }
    };

    const responseGoogle = (response) => {
        console.log(response);
        // Здесь вы можете обработать ответ от Google и сохранить токен
        const token = response.tokenId; // Получите токен
        localStorage.setItem('jwt', token); // Сохраните токен в localStorage
    };

    const updateTime = () => {
        setCurrentTime(new Date().toLocaleTimeString());
    };

    useEffect(() => {
        const interval = setInterval(updateTime, 1000);
        return () => clearInterval(interval);
    }, []);

    return (
        <div>
            <h2>Login</h2>
            <p>Текущее время: {currentTime}</p>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Username:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Login</button>
            </form>
            <GoogleLogin
                clientId="YOUR_GOOGLE_CLIENT_ID" // Замените на ваш Client ID
                buttonText="Войти с Google"
                onSuccess={responseGoogle}
                onFailure={(response) => console.error('Login failed:', response)}
                cookiePolicy={'single_host_origin'}
            />
        </div>
    );
};

export default LoginPage; 