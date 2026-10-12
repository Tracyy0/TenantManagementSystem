package com.example.tenantmanagementsystem

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) {
    fun summary(): String {
        return "Name: $name\nPhone: $phone\nMonthly Rent: $rent"
    }
}
