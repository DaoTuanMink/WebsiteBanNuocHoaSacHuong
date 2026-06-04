package com.perfume.api.repository;

import com.perfume.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Chỉ cần kế thừa JpaRepository là có sẵn các hàm lấy dữ liệu, thêm, sửa, xóa
}