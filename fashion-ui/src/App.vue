<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

// Tạo một biến reactive để chứa danh sách nước hoa
const products = ref([])

// Hàm gọi API sang Spring Boot
const fetchProducts = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/products')
    products.value = response.data // Hứng dữ liệu JSON trả về
  } catch (error) {
    console.error('Lỗi khi lấy dữ liệu nước hoa:', error)
  }
}

// Chạy hàm fetchProducts ngay khi trang web vừa được tải xong
onMounted(() => {
  fetchProducts()
})
</script>

<template>
  <div class="container">
    <h1>✨ Thế Giới Nước Hoa Cao Cấp ✨</h1>

    <div v-if="products.length === 0" class="no-product">
      Hiện chưa có chai nước hoa nào trong cửa hàng.
    </div>

    <div v-else class="product-grid">
      <div v-for="product in products" :key="product.id" class="product-card">
        <h3>{{ product.name }}</h3>
        <p class="brand">Thương hiệu: {{ product.brand }}</p>
        <p class="price">Giá: {{ product.price.toLocaleString() }} đ</p>
        <p class="desc">{{ product.description }}</p>
        <button class="btn-add">Thêm vào giỏ hàng</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: sans-serif;
  text-align: center;
}
.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
  margin-top: 30px;
}
.product-card {
  border: 1px solid #ddd;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  text-align: left;
}
.brand {
  color: #666;
  font-style: italic;
}
.price {
  color: #e74c3c;
  font-weight: bold;
  font-size: 1.2em;
}
.desc {
  font-size: 0.9em;
  color: #555;
}
.btn-add {
  background-color: #34495e;
  color: white;
  border: none;
  padding: 10px 15px;
  width: 100%;
  border-radius: 4px;
  cursor: pointer;
}
.btn-add:hover {
  background-color: #2c3e50;
}
</style>
