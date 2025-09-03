import React from 'react';
import { Link } from 'react-router-dom';

const Dashboard = () => {
  return (
    <div className="card">
      <h1>🚛 Welcome to MK Logistics</h1>
      <p>Streamline your logistics operations with our comprehensive management platform</p>
      
      <div className="dashboard-grid">
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>📦</div>
          <h3>Customer Portal</h3>
          <p>Create orders, manage cargo, and track your shipments with ease</p>
          <Link to="/customer" className="btn">Go to Customer Portal</Link>
        </div>
        
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>⚙️</div>
          <h3>Admin Portal</h3>
          <p>Manage carriers, trucks, drivers, and oversee system operations</p>
          <Link to="/admin" className="btn">Go to Admin Portal</Link>
        </div>
      </div>

      <div style={{ marginTop: '3rem', textAlign: 'center', color: '#7f8c8d' }}>
        <p>✨ Modern • Efficient • Reliable ✨</p>
      </div>
    </div>
  );
};

export default Dashboard;
