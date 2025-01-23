import React, { useState } from 'react';
import axios from 'axios';
import ForumResponse from './ForumResponse';
import ForumReaction from './ForumReaction';

const Forum = () => {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [forumId, setForumId] = useState(null); // ID форума для ответов

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = localStorage.getItem('jwt');
            const response = await axios.post('/api/forum', { title, content }, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            setForumId(response.data.forumId); // Предполагается, что сервер возвращает ID форума
            alert('Forum submitted successfully');
        } catch (error) {
            console.error('Error submitting forum:', error);
        }
    };

    return (
        <div>
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
            {forumId && (
                <>
                    <ForumResponse forumId={forumId} />
                    <ForumReaction forumId={forumId} />
                </>
            )}
        </div>
    );
};

export default Forum; 