import { useEffect, useState } from "react";
import api from "../api/axios";
import ProductCard from "./ProductCard";

function ProductsList() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        api.get("/products")
            .then((res) => setProducts(res.data))
            .catch((err) => console.error("Error fetching products:", err));
    }, []);

    if (products.length === 0) {
        return <p className="text-center mt-4">No products found</p>;
    }

    return (
        <div className="container mt-4">
            <h3 className="text-center mb-4">Available Products</h3>
            <div className="d-flex flex-wrap justify-content-center gap-3">
                {products.map((product) => (
                    <ProductCard key={product.id} product={product} />
                ))}
            </div>
        </div>
    );
}

export default ProductsList;
