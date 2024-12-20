package com.example.enums;

import lombok.ToString;

public enum AccountStatus {
    CHECKING(0), CHECKED(1); // Cung cấp giá trị cho mỗi hằng số

    private int value; // Trường lưu giá trị

    // Constructor để khởi tạo giá trị cho mỗi enum
    AccountStatus(int value) {
        this.value = value;
    }

    // Phương thức getter để lấy giá trị
    public int getValue() {
        return value;
    }

    // Override phương thức toString() để trả về giá trị dưới dạng chuỗi
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
