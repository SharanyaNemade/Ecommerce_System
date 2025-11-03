function ProductCard({ product }) {
    return (
        <div className="card p-2 mb-3 shadow-sm" style={{ width: "18rem" }}>
            <img
                src={product.imageUrl || "https://via.placeholder.com/200"}
                alt={product.name}
                className="card-img-top"
            />
            <div className="card-body text-center">
                <h5 className="card-title">{product.name}</h5>
                <p className="card-text">₹{product.price}</p>
                <button className="btn btn-primary w-100">Add to Cart</button>
            </div>
        </div>
    );
}

export default ProductCard;
