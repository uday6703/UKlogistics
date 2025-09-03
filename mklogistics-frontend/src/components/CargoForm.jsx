import React, { useState } from 'react';
import { cargoAPI } from '../services/api';

const CargoForm = () => {
  const [formData, setFormData] = useState({
    cargoType: '',
    weight: '',
    dimensions: '',
    description: ''
  });
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState('');

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      const response = await cargoAPI.saveCargo(formData);
      setMessage('Cargo created successfully!');
      setMessageType('success');
      setFormData({
        cargoType: '',
        weight: '',
        dimensions: '',
        description: ''
      });
    } catch (error) {
      setMessage('Error creating cargo. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2>📋 Create New Cargo</h2>
      
      {message && (
        <div className={`alert ${messageType === 'success' ? 'alert-success' : 'alert-error'}`}>
          {message}
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <div className="form-section">
          <div className="form-row">
            <div className="form-group">
              <label htmlFor="cargoType">Cargo Type:</label>
              <input
                type="text"
                id="cargoType"
                name="cargoType"
                value={formData.cargoType}
                onChange={handleChange}
                placeholder="e.g., Electronics, Furniture, Food"
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="weight">Weight (kg):</label>
              <input
                type="number"
                id="weight"
                name="weight"
                value={formData.weight}
                onChange={handleChange}
                step="0.01"
                placeholder="Enter weight in kg"
                required
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="dimensions">Dimensions:</label>
            <input
              type="text"
              id="dimensions"
              name="dimensions"
              value={formData.dimensions}
              onChange={handleChange}
              placeholder="e.g., 10x20x30 cm"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="description">Description:</label>
            <textarea
              id="description"
              name="description"
              value={formData.description}
              onChange={handleChange}
              rows="4"
              placeholder="Describe the cargo and any special handling requirements..."
            />
          </div>

          <button type="submit" className="btn" disabled={loading}>
            {loading ? <><span className="loading-spinner"></span>Creating...</> : 'Create Cargo'}
          </button>
        </div>
      </form>
    </div>
  );
};

export default CargoForm;
