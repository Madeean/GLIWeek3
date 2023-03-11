package com.madeean.weeklyproject3no1.database

import com.madeean.weeklyproject3no1.model.ProductModel

object ElektronikDatabase {
    val elektronikDatabase1 = ProductModel(
        "Handphone",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/331/gambar-gambar-handphone-8.jpg",
            "https://cdn.kibrispdr.org/data/331/gambar-gambar-handphone-20.jpg"
        ),
        1000000,
        1200000,
        "Handphone, atau sering disingkat HP, adalah perangkat elektronik yang digunakan untuk melakukan komunikasi telepon nirkabel atau mobile. Handphone biasanya memiliki layar sentuh (touchscreen) atau tombol-tombol fisik untuk memudahkan pengguna melakukan panggilan, mengirim pesan teks, mengakses internet, memutar musik, dan berbagai aplikasi lainnya.",
        "Gudang",
        1
    )
    val elektronikDatabase2 = ProductModel(
        "Laptop",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/729/laptop-back-png-16.png",
            "https://cdn.kibrispdr.org/data/424/gambar-laptop-asus-gaming-terbaru-1.jpg"
        ),
        1000000,
        1200000,
        "Laptop adalah sebuah komputer pribadi yang portabel, yang dirancang untuk digunakan di mana saja dan kapan saja. Laptop memiliki semua fungsi yang dimiliki oleh sebuah komputer meja (desktop), namun dengan ukuran yang lebih kecil dan portabilitas yang lebih baik.",
        "Private Marketplace",
        1
    )
    val elektronikDatabase3 = ProductModel(
        "Printer",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/815/printer-foto-copy-f4-1.jpg",
            "https://cdn.kibrispdr.org/data/815/printer-foto-copy-f4-5.jpg"
        ),
        1200000,
        1200000,
        "Printer adalah perangkat keras (hardware) yang digunakan untuk mencetak dokumen atau gambar dari sebuah komputer atau perangkat lainnya. Printer menerima perintah cetak dari komputer dan mencetak teks atau gambar pada kertas atau media cetak lainnya.",
        "Toko",
        1
    )
    val elektronikDatabase4 = ProductModel(
        "Televisi",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/36/contoh-gambar-televisi-0.jpg",
            "https://cdn.kibrispdr.org/data/36/contoh-gambar-televisi-7.jpg"
        ),
        1200000,
        1200000,
        "Televisi, juga dikenal sebagai TV, adalah sebuah perangkat elektronik yang digunakan untuk menampilkan gambar bergerak dan suara secara real-time. Televisi umumnya terdiri dari layar, speaker, dan penerima sinyal TV.",
        "Toko",
        1
    )
}