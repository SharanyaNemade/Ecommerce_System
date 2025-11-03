import { BrowserRouter as Router, Routes, Route, Link, Navigate } from "react-router-dom";
import ProductsList from "./components/ProductsList";
import OrdersList from "./components/OrdersList";

function App() {
  return (
    <Router>
      <div>
        {/* Navigation */}
        <nav
          style={{
            display: "flex",
            gap: "20px",
            padding: "10px",
            background: "#007bff",
          }}
        >
          <Link to="/products" style={{ color: "white", textDecoration: "none" }}>
            Products
          </Link>
          <Link to="/orders" style={{ color: "white", textDecoration: "none" }}>
            Orders
          </Link>
        </nav>

        {/* Routes */}
        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<Navigate to="/products" />} />
            <Route path="/products" element={<ProductsList />} />
            <Route path="/orders" element={<OrdersList />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
