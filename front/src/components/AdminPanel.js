import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminPanel = () => {
    const [message, setMessage] = useState('');

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

    return (
        <div>
            <h2>Admin Panel</h2>
            <p>{message}</p>
        </div>
    );
};

export default AdminPanel; 