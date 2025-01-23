import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Form from './Form';
import Forum from './Forum';

const AdminPanel = () => {
    const [message, setMessage] = useState('');
    const [items, setItems] = useState([]);

    useEffect(() => {
        const fetchAdminData = async () => {
            try {
                const token = localStorage.getItem('jwt');
                const response = await axios.get('/api/admin', {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                });
                setMessage(response.data);
            } catch (error) {
                setMessage('Access denied. You do not have permission to view this page.');
            }
        };

        fetchAdminData();
    }, []);

    const handleDelete = async (id) => {
        try {
            const token = localStorage.getItem('jwt');
            await axios.delete(`/api/items/${id}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            setItems(items.filter(item => item.id !== id));
        } catch (error) {
            console.error('Error deleting item:', error);
        }
    };

    return (
        <div>
            <h2>Admin Panel</h2>
            <p>{message}</p>
            <h3>Items</h3>
            <ul>
                {items.map(item => (
                    <li key={item.id}>
                        {item.name}
                        <button onClick={() => handleDelete(item.id)}>Delete</button>
                    </li>
                ))}
            </ul>
            <h3>Submit Forum</h3>
            <Forum />
        </div>
    );
};

export default AdminPanel; 