# MkLogistics Frontend

A modern React-based frontend for the MkLogistics management system.

## 🚀 Quick Start

```bash
# Install dependencies
npm install

# Run development server
npm run dev

# Build for production
npm run build
```

## 🛠️ Tech Stack

- **React 18** - Modern UI library
- **Vite** - Next Generation Frontend Tooling
- **React Router** - Client-side routing
- **Axios** - HTTP client for API calls
- **CSS3** - Modern styling with glass morphism

## 📋 Features

- **Customer Dashboard**
  - Cargo management
  - Order tracking
  - Shipment status

- **Admin Dashboard**
  - Carrier management
  - Driver assignments
  - Truck fleet management
  - Address management

- **Modern UI/UX**
  - Responsive design
  - Glass morphism effects
  - Intuitive navigation

## 🔌 API Integration

The frontend connects to the Spring Boot backend running at `http://localhost:8080` and includes:

- Cargo API
- Carrier API
- Driver API
- Truck API
- Order API
- Address API

## 📁 Project Structure

```
mklogistics-frontend/
├── src/
│   ├── components/       # Reusable components
│   ├── pages/           # Page components
│   ├── services/        # API services
│   ├── styles/          # CSS styles
│   └── App.jsx          # Main application
├── public/              # Static files
└── index.html          # Entry point
```

## 💻 Development

```bash
# Start development server
npm run dev

# Server will start at
http://localhost:5174
```

## 🔧 Configuration

- Backend API URL can be configured in `services/api.js`
- CORS is enabled for `localhost:8080`

## 📦 Building for Production

```bash
# Create production build
npm run build

# Preview production build
npm run preview
```

## 🔍 API Testing

All API endpoints can be tested using the integrated test page:
- Cargo API: POST /cargo
- Carrier API: POST /carrier
- Driver API: POST, GET, PUT /driver
- Truck API: POST /truck
- Address API: POST /address
- Order API: POST, PUT /order

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📝 License

This project is licensed under the MIT License.
