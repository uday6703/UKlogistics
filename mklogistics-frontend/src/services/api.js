import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Customer API calls
export const cargoAPI = {
  saveCargo: (cargoData) => api.post('/cargo', cargoData),
};

export const orderAPI = {
  saveOrder: (orderData) => api.post('/order', orderData),
};

// Admin API calls
export const carrierAPI = {
  saveCarrier: (carrierData) => api.post('/carrier', carrierData),
};

export const truckAPI = {
  saveTruck: (truckData, carrierName) => 
    api.post(`/truck?carrierName=${encodeURIComponent(carrierName)}`, truckData),
};

export const driverAPI = {
  saveDriver: (driverData) => api.post('/driver', driverData),
  findDriver: (contact) => api.get(`/driver?contact=${contact}`),
  updateDriver: (contact, driverData) => 
    api.put(`/driver?contact=${contact}`, driverData),
};

export const addressAPI = {
  saveAddress: (addressData) => api.post('/address', addressData),
};

export const orderManagementAPI = {
  updateOrder: (orderId, unloadingDays) => 
    api.put(`/order?orderId=${orderId}&unloadingDays=${unloadingDays}`),
};

export default api;
