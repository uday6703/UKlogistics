import React, { useState } from 'react';
import { orderAPI } from '../services/api';

const OrderForm = () => {
  const [formData, setFormData] = useState({
    pickupLocation: '',
    deliveryLocation: '',
    pickupDate: '',
    deliveryDate: '',
    priority: 'NORMAL',
    specialInstructions: ''
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
      const response = await orderAPI.saveOrder(formData);
      setMessage('Order created successfully!');
      setMessageType('success');
      setFormData({
        pickupLocation: '',
        deliveryLocation: '',
        pickupDate: '',
        deliveryDate: '',
        priority: 'NORMAL',
        specialInstructions: ''
      });
    } catch (error) {
      setMessage('Error creating order. Please try again.');
      setMessageType('error');
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2>🚚 Create New Order</h2>
      
      {message && (
        <div className={`alert ${messageType === 'success' ? 'alert-success' : 'alert-error'}`}>
          {message}
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <div className="form-section">
          <div className="form-row">
            <div className="form-group">
              <label htmlFor="pickupLocation">Pickup Location:</label>
              <input
                type="text"
                id="pickupLocation"
                name="pickupLocation"
                value={formData.pickupLocation}
                onChange={handleChange}
                placeholder="Enter pickup address"
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="deliveryLocation">Delivery Location:</label>
              <input
                type="text"
                id="deliveryLocation"
                name="deliveryLocation"
                value={formData.deliveryLocation}
                onChange={handleChange}
                placeholder="Enter delivery address"
                required
              />
            </div>
          </div>

          <div className="form-row">
            <div className="form-group">
              <label htmlFor="pickupDate">Pickup Date:</label>
              <input
                type="datetime-local"
                id="pickupDate"
                name="pickupDate"
                value={formData.pickupDate}
                onChange={handleChange}
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="deliveryDate">Delivery Date:</label>
              <input
                type="datetime-local"
                id="deliveryDate"
                name="deliveryDate"
                value={formData.deliveryDate}
                onChange={handleChange}
                required
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="priority">Priority:</label>
            <select
              id="priority"
              name="priority"
              value={formData.priority}
              onChange={handleChange}
            >
              <option value="LOW">🟢 Low Priority</option>
              <option value="NORMAL">🟡 Normal Priority</option>
              <option value="HIGH">🟠 High Priority</option>
              <option value="URGENT">🔴 Urgent Priority</option>
            </select>
          </div>

          <div className="form-group">
            <label htmlFor="specialInstructions">Special Instructions:</label>
            <textarea
              id="specialInstructions"
              name="specialInstructions"
              value={formData.specialInstructions}
              onChange={handleChange}
              rows="4"
              placeholder="Any special handling instructions, delivery notes, or requirements..."
            />
          </div>

          <button type="submit" className="btn" disabled={loading}>
            {loading ? <><span className="loading-spinner"></span>Creating...</> : 'Create Order'}
          </button>
        </div>
      </form>
    </div>
  );
};

export default OrderForm;
