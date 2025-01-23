import React, { useState } from 'react';

const Captcha = () => {
    const [captchaValue, setCaptchaValue] = useState('');
    const [captchaCorrect, setCaptchaCorrect] = useState(false);

    const handleChange = (e) => {
        setCaptchaValue(e.target.value);
    };

    const validateCaptcha = () => {
        // Пример простой проверки капчи
        if (captchaValue === '1234') {
            setCaptchaCorrect(true);
        } else {
            alert('Неверная капча');
        }
    };

    return (
        <div>
            <label>Введите капчу (1234):</label>
            <input type="text" value={captchaValue} onChange={handleChange} />
            <button onClick={validateCaptcha}>Проверить</button>
            {captchaCorrect && <p>Капча пройдена!</p>}
        </div>
    );
};

export default Captcha; 