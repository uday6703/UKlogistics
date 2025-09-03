import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import './components/styles.css';

// Components
import Dashboard from './components/Dashboard';
import CustomerDashboard from './components/CustomerDashboard';
import AdminDashboard from './components/AdminDashboard';
import CargoForm from './components/CargoForm';
import OrderForm from './components/OrderForm';
import TruckManagement from './components/TruckManagement';
import DriverManagement from './components/DriverManagement';

function App() {
  return (
    <Router>
      <div className="App">
        <nav className="navbar">
          <div className="nav-brand">
            <Link to="/">MK Logistics</Link>
          </div>
          <div className="nav-links">
            <Link to="/">Home</Link>
            <Link to="/customer">Customer</Link>
            <Link to="/admin">Admin</Link>
          </div>
        </nav>

        <main className="main-content">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/customer" element={<CustomerDashboard />} />
            <Route path="/admin" element={<AdminDashboard />} />
            <Route path="/cargo" element={<CargoForm />} />
            <Route path="/order" element={<OrderForm />} />
            <Route path="/trucks" element={<TruckManagement />} />
            <Route path="/drivers" element={<DriverManagement />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App
