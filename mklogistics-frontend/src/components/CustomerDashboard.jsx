import React from 'react';
import { Link } from 'react-router-dom';

const CustomerDashboard = () => {
  return (
    <div className="card">
      <h2>📦 Customer Dashboard</h2>
      <p>Manage your shipments and cargo operations efficiently</p>
      
      <div className="dashboard-grid">
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>📋</div>
          <h3>Create Cargo</h3>
          <p>Add new cargo details and specifications for your shipment</p>
          <Link to="/cargo" className="btn">Create Cargo</Link>
        </div>
        
        <div className="dashboard-card">
          <div style={{ fontSize: '3rem', marginBottom: '1rem' }}>🚚</div>
          <h3>Place Order</h3>
          <p>Create new shipping orders with pickup and delivery details</p>
          <Link to="/order" className="btn">Place Order</Link>
        </div>
      </div>

      <div style={{ marginTop: '2rem', padding: '1.5rem', background: 'rgba(52, 152, 219, 0.1)', borderRadius: '15px', textAlign: 'center' }}>
        <h4 style={{ color: '#2c3e50', marginBottom: '0.5rem' }}>Quick Tips</h4>
        <p style={{ color: '#7f8c8d', margin: 0 }}>💡 Create your cargo first, then place an order to begin shipping</p>
      </div>
    </div>
  );
};

export default CustomerDashboard;
