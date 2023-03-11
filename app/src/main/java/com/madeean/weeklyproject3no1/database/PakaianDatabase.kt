package com.madeean.weeklyproject3no1.database

import com.madeean.weeklyproject3no1.model.ProductModel

object PakaianDatabase {
    val pakaianDatabase1 = ProductModel(
        "Kemeja Hitam",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/703/kemeja-hitam-polos-depan-belakang-2.jpg",
            "https://cdn.kibrispdr.org/data/703/kemeja-hitam-polos-depan-belakang-3.jpg"
        ),
        50000,
        100000,
        "Kemeja adalah pakaian atasan yang biasanya terbuat dari kain ringan seperti katun, linen, atau wol yang menutupi bagian atas tubuh dan lengan. Kemeja biasanya memiliki kerah, kancing di bagian depan, dan lengan panjang, tetapi ada juga yang memiliki lengan pendek atau tanpa lengan",
        "Toko",
        5
    )
    val pakaianDatabase2 = ProductModel(
        "Hoodie",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/860/rubik-s-cube-hoodie-1.jpg",
            "https://cdn.kibrispdr.org/data/860/rubik-s-cube-hoodie-0.jpg"
        ),
        120000,
        150000,
        "Hoodie adalah pakaian luar berupa jaket atau sweatshirt dengan kerah dan tutup kepala (hood) yang biasanya memiliki tali untuk mengencangkan tutup kepala. Hoodie terbuat dari bahan yang lebih tebal dan nyaman seperti fleece atau katun dan memiliki lapisan di dalamnya yang membuatnya hangat.",
        "Toko",
        5
    )
    val pakaianDatabase3 = ProductModel(
        "Crewneck",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/50/crewneck-polos-png-4.png",
            "https://cdn.kibrispdr.org/data/50/crewneck-polos-png-12.jpg"
        ),
        75000,
        75000,
        "Crewneck adalah jenis pakaian atasan yang seringkali berbentuk seperti kaos dengan kerah bundar tanpa kancing atau ritsleting. Crewneck biasanya terbuat dari bahan yang ringan dan nyaman seperti katun atau polyester, dan memiliki lengan pendek atau panjang.",
        "Toko",
        5
    )
    val pakaianDatabase4 = ProductModel(
        "Blazer",
        arrayListOf(
            "https://cdn.kibrispdr.org/data/22/blazer-png-1.jpg",
            "https://cdn.kibrispdr.org/data/22/blazer-png-7.png"
        ),
        75000,
        75000,
        "Blazer adalah pakaian luar yang biasanya terbuat dari kain ringan seperti katun, linen, atau wol, dan memiliki model yang lebih formal daripada jaket atau hoodie. Blazer biasanya memiliki potongan yang rapi dan detail yang lebih halus, dengan kerah yang lebih formal seperti kerah shawl atau kerah notch.",
        "Toko",
        5
    )
}