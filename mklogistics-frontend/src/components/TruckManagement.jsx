import React, { useState } from 'react';
import { truckAPI, carrierAPI } from '../services/api';

const TruckManagement = () => {
  const [activeTab, setActiveTab] = useState('carrier');
  const [carrierData, setCarrierData] = useState({
    name: '',
    contactNumber: '',
    email: '',
    address: ''
  });
  const [truckData, setTruckData] = useState({
    licensePlate: '',
    model: '',
    capacity: '',
    fuelType: ''
  });
  const [carrierName, setCarrierName] = useState('');
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState('');

  const handleCarrierChange = (e) => {
    setCarrierData({
      ...carrierData,
      [e.target.name]: e.target.value
    });
  };

  const handleTruckChange = (e) => {
    setTruckData({
      ...truckData,
      [e.target.name]: e.target.value
    });
  };

  const handleCarrierSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      await carrierAPI.saveCarrier(carrierData);
      setMessage('Carrier created successfully!');
      setMessageType('success');
      setCarrierData({
        name: '',
        contactNumber: '',
        email: '',
        address: ''
      });
    } catch (error) {
      setMessage('Error creating carrier. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleTruckSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      await truckAPI.saveTruck(truckData, carrierName);
      setMessage('Truck created successfully!');
      setMessageType('success');
      setTruckData({
        licensePlate: '',
        model: '',
        capacity: '',
        fuelType: ''
      });
      setCarrierName('');
    } catch (error) {
      setMessage('Error creating truck. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2>🚛 Truck Management</h2>
      
      <div className="tab-navigation">
        <button 
          className={`tab-button ${activeTab === 'carrier' ? 'active' : ''}`}
          onClick={() => setActiveTab('carrier')}
        >
          Add Carrier
        </button>
        <button 
          className={`tab-button ${activeTab === 'truck' ? 'active' : ''}`}
          onClick={() => setActiveTab('truck')}
        >
          Add Truck
        </button>
      </div>

      {message && (
        <div className={`alert ${messageType === 'success' ? 'alert-success' : 'alert-error'}`}>
          {message}
        </div>
      )}

      {activeTab === 'carrier' && (
        <div className="form-section">
          <form onSubmit={handleCarrierSubmit}>
            <h3>🏢 Add New Carrier</h3>
            
            <div className="form-row">
              <div className="form-group">
                <label htmlFor="name">Carrier Name:</label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={carrierData.name}
                  onChange={handleCarrierChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="contactNumber">Contact Number:</label>
                <input
                  type="tel"
                  id="contactNumber"
                  name="contactNumber"
                  value={carrierData.contactNumber}
                  onChange={handleCarrierChange}
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label htmlFor="email">Email:</label>
              <input
                type="email"
                id="email"
                name="email"
                value={carrierData.email}
                onChange={handleCarrierChange}
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="address">Address:</label>
              <textarea
                id="address"
                name="address"
                value={carrierData.address}
                onChange={handleCarrierChange}
                rows="3"
                required
              />
            </div>

            <button type="submit" className="btn" disabled={loading}>
              {loading ? <><span className="loading-spinner"></span>Creating...</> : 'Create Carrier'}
            </button>
          </form>
        </div>
      )}

      {activeTab === 'truck' && (
        <div className="form-section">
          <form onSubmit={handleTruckSubmit}>
            <h3>🚛 Add New Truck</h3>
            
            <div className="form-group">
              <label htmlFor="carrierName">Carrier Name:</label>
              <input
                type="text"
                id="carrierName"
                value={carrierName}
                onChange={(e) => setCarrierName(e.target.value)}
                placeholder="Enter existing carrier name"
                required
              />
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="licensePlate">License Plate:</label>
                <input
                  type="text"
                  id="licensePlate"
                  name="licensePlate"
                  value={truckData.licensePlate}
                  onChange={handleTruckChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="model">Model:</label>
                <input
                  type="text"
                  id="model"
                  name="model"
                  value={truckData.model}
                  onChange={handleTruckChange}
                  required
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="capacity">Capacity (tons):</label>
                <input
                  type="number"
                  id="capacity"
                  name="capacity"
                  value={truckData.capacity}
                  onChange={handleTruckChange}
                  step="0.1"
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="fuelType">Fuel Type:</label>
                <select
                  id="fuelType"
                  name="fuelType"
                  value={truckData.fuelType}
                  onChange={handleTruckChange}
                  required
                >
                  <option value="">Select fuel type</option>
                  <option value="DIESEL">Diesel</option>
                  <option value="PETROL">Petrol</option>
                  <option value="ELECTRIC">Electric</option>
                  <option value="HYBRID">Hybrid</option>
                </select>
              </div>
            </div>

            <button type="submit" className="btn" disabled={loading}>
              {loading ? <><span className="loading-spinner"></span>Creating...</> : 'Create Truck'}
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default TruckManagement;
