import React, { useState } from 'react';
import { driverAPI } from '../services/api';

const DriverManagement = () => {
  const [activeTab, setActiveTab] = useState('add');
  const [driverData, setDriverData] = useState({
    name: '',
    contact: '',
    licenseNumber: '',
    experience: '',
    address: ''
  });
  const [searchContact, setSearchContact] = useState('');
  const [foundDriver, setFoundDriver] = useState(null);
  const [updateContact, setUpdateContact] = useState('');
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState('');

  const handleChange = (e) => {
    setDriverData({
      ...driverData,
      [e.target.name]: e.target.value
    });
  };

  const handleAddDriver = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      await driverAPI.saveDriver(driverData);
      setMessage('Driver added successfully!');
      setMessageType('success');
      setDriverData({
        name: '',
        contact: '',
        licenseNumber: '',
        experience: '',
        address: ''
      });
    } catch (error) {
      setMessage('Error adding driver. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleSearchDriver = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      const response = await driverAPI.findDriver(searchContact);
      setFoundDriver(response.data.data);
      setMessage('Driver found!');
      setMessageType('success');
    } catch (error) {
      setFoundDriver(null);
      setMessage('Driver not found.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleUpdateDriver = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      await driverAPI.updateDriver(updateContact, driverData);
      setMessage('Driver updated successfully!');
      setMessageType('success');
      setDriverData({
        name: '',
        contact: '',
        licenseNumber: '',
        experience: '',
        address: ''
      });
      setUpdateContact('');
    } catch (error) {
      setMessage('Error updating driver. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2>👨‍💼 Driver Management</h2>
      
      <div className="tab-navigation">
        <button 
          className={`tab-button ${activeTab === 'add' ? 'active' : ''}`}
          onClick={() => setActiveTab('add')}
        >
          Add Driver
        </button>
        <button 
          className={`tab-button ${activeTab === 'search' ? 'active' : ''}`}
          onClick={() => setActiveTab('search')}
        >
          Search Driver
        </button>
        <button 
          className={`tab-button ${activeTab === 'update' ? 'active' : ''}`}
          onClick={() => setActiveTab('update')}
        >
          Update Driver
        </button>
      </div>

      {message && (
        <div className={`alert ${messageType === 'success' ? 'alert-success' : 'alert-error'}`}>
          {message}
        </div>
      )}

      {activeTab === 'add' && (
        <div className="form-section">
          <form onSubmit={handleAddDriver}>
            <h3>➕ Add New Driver</h3>
            
            <div className="form-row">
              <div className="form-group">
                <label htmlFor="name">Driver Name:</label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={driverData.name}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="contact">Contact Number:</label>
                <input
                  type="tel"
                  id="contact"
                  name="contact"
                  value={driverData.contact}
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="licenseNumber">License Number:</label>
                <input
                  type="text"
                  id="licenseNumber"
                  name="licenseNumber"
                  value={driverData.licenseNumber}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="experience">Experience (years):</label>
                <input
                  type="number"
                  id="experience"
                  name="experience"
                  value={driverData.experience}
                  onChange={handleChange}
                  min="0"
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label htmlFor="address">Address:</label>
              <textarea
                id="address"
                name="address"
                value={driverData.address}
                onChange={handleChange}
                rows="3"
                required
              />
            </div>

            <button type="submit" className="btn" disabled={loading}>
              {loading ? <><span className="loading-spinner"></span>Adding...</> : 'Add Driver'}
            </button>
          </form>
        </div>
      )}

      {activeTab === 'search' && (
        <div className="form-section">
          <h3>🔍 Search Driver</h3>
          <form onSubmit={handleSearchDriver}>
            <div className="form-group">
              <label htmlFor="searchContact">Contact Number:</label>
              <input
                type="tel"
                id="searchContact"
                value={searchContact}
                onChange={(e) => setSearchContact(e.target.value)}
                placeholder="Enter driver's contact number"
                required
              />
            </div>
            <button type="submit" className="btn" disabled={loading}>
              {loading ? <><span className="loading-spinner"></span>Searching...</> : 'Search Driver'}
            </button>
          </form>

          {foundDriver && (
            <div className="driver-details">
              <h4>Driver Details:</h4>
              <p><strong>Name:</strong> {foundDriver.name}</p>
              <p><strong>Contact:</strong> {foundDriver.contact}</p>
              <p><strong>License Number:</strong> {foundDriver.licenseNumber}</p>
              <p><strong>Experience:</strong> {foundDriver.experience} years</p>
              <p><strong>Address:</strong> {foundDriver.address}</p>
            </div>
          )}
        </div>
      )}

      {activeTab === 'update' && (
        <div className="form-section">
          <form onSubmit={handleUpdateDriver}>
            <h3>✏️ Update Driver</h3>
            
            <div className="form-group">
              <label htmlFor="updateContact">Driver Contact (to identify):</label>
              <input
                type="tel"
                id="updateContact"
                value={updateContact}
                onChange={(e) => setUpdateContact(e.target.value)}
                placeholder="Enter contact number of driver to update"
                required
              />
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="name">Driver Name:</label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={driverData.name}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="contact">Contact Number:</label>
                <input
                  type="tel"
                  id="contact"
                  name="contact"
                  value={driverData.contact}
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="licenseNumber">License Number:</label>
                <input
                  type="text"
                  id="licenseNumber"
                  name="licenseNumber"
                  value={driverData.licenseNumber}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="experience">Experience (years):</label>
                <input
                  type="number"
                  id="experience"
                  name="experience"
                  value={driverData.experience}
                  onChange={handleChange}
                  min="0"
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label htmlFor="address">Address:</label>
              <textarea
                id="address"
                name="address"
                value={driverData.address}
                onChange={handleChange}
                rows="3"
                required
              />
            </div>

            <button type="submit" className="btn" disabled={loading}>
              {loading ? <><span className="loading-spinner"></span>Updating...</> : 'Update Driver'}
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default DriverManagement;
