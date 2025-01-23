import React, { useState } from 'react';
import axios from 'axios';

const ForumReaction = ({ forumId }) => {
    const [reactionType, setReactionType] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = localStorage.getItem('jwt');
            await axios.post('/api/forum/reaction', { forumId, reactionType }, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            alert('Reaction submitted successfully');
        } catch (error) {
            console.error('Error submitting reaction:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Reaction Type:</label>
                <select value={reactionType} onChange={(e) => setReactionType(e.target.value)} required>
                    <option value="">Select Reaction</option>
                    <option value="like">Like</option>
                    <option value="dislike">Dislike</option>
                </select>
            </div>
            <button type="submit">Submit Reaction</button>
        </form>
    );
};

export default ForumReaction; 