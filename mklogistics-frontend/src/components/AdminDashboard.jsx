import React from 'react';
import { Link } from 'react-router-dom';

const AdminDashboard = () => {
  return (
    <div className="card">
      <h2>⚙️ Admin Dashboard</h2>
      <p>Manage system operations and oversee all logistics resources</p>
      
      <div className="dashboard-grid">
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>🚛</div>
          <h3>Truck Management</h3>
          <p>Manage your fleet of trucks, add carriers, and track vehicle information</p>
          <Link to="/trucks" className="btn">Manage Trucks</Link>
        </div>
        
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>👨‍💼</div>
          <h3>Driver Management</h3>
          <p>Add, search, and update driver profiles and their credentials</p>
          <Link to="/drivers" className="btn">Manage Drivers</Link>
        </div>
      </div>

      <div style={{ marginTop: '2rem', padding: '1.5rem', background: 'rgba(155, 89, 182, 0.1)', borderRadius: '15px', textAlign: 'center' }}>
        <h4 style={{ color: '#2c3e50', marginBottom: '0.5rem' }}>Admin Features</h4>
        <p style={{ color: '#7f8c8d', margin: 0 }}>🔧 Full control over carriers, trucks, drivers, and order management</p>
      </div>
    </div>
  );
};

export default AdminDashboard;
