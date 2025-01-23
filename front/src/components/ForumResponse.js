import React, { useState } from 'react';
import axios from 'axios';

const ForumResponse = ({ forumId }) => {
    const [responseContent, setResponseContent] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = localStorage.getItem('jwt');
            await axios.post('/api/forum/response', { forumId, responseContent }, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            alert('Response submitted successfully');
        } catch (error) {
            console.error('Error submitting response:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Response:</label>
                <textarea value={responseContent} onChange={(e) => setResponseContent(e.target.value)} required />
            </div>
            <button type="submit">Submit Response</button>
        </form>
    );
};

export default ForumResponse; 