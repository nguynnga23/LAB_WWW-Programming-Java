package com.example.week03_web_sale.enums;

public enum ProductStatus {
    TERMINATED(-1),
    ACTIVE(0),
    IN_ACTIVE(1);

    private int value;

    // Constructor với tham số int
    private ProductStatus(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);  // Trả về chuỗi đại diện cho giá trị int
    }

    public int getValue() {
        return value;  // Phương thức getter để lấy giá trị int
    }
}
