import { useEffect, useState } from "react";
import api from "../api/axios";

function OrdersList() {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        api.get("/orders")
            .then((res) => setOrders(res.data))
            .catch((err) => console.error("Error fetching orders:", err));
    }, []);

    if (orders.length === 0) {
        return <p className="text-center mt-4">No orders found</p>;
    }

    return (
        <div className="container mt-4">
            <h3 className="text-center mb-4">Orders</h3>
            <ul className="list-group">
                {orders.map((order) => (
                    <li key={order.id} className="list-group-item">
                        <strong>Order ID:</strong> {order.id} <br />
                        <strong>Total:</strong> ₹{order.totalAmount}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default OrdersList;
