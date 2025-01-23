import React, { useState } from 'react';
import axios from 'axios';

const Forum = () => {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = localStorage.getItem('jwt');
            await axios.post('/api/forum', { title, content }, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            alert('Forum submitted successfully');
        } catch (error) {
            console.error('Error submitting forum:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} required />
            </div>
            <div>
                <label>Content:</label>
                <textarea value={content} onChange={(e) => setContent(e.target.value)} required />
            </div>
            <button type="submit">Submit</button>
        </form>
    );
};

export default Forum; 