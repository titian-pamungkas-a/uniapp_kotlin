# Uni Ampera APP

## Source Code Kotlin [DI SINI](https://github.com/titian-pamungkas-a/uniapp_kotlin)

Uni Ampera APP adalah aplikasi pemesanan makanan berbasis android yang ditujukan untuk pengguna yang ingin memesan makanan padang di daerah Gebang dan Keputih, Surabaya. Uni Ampera App memiliki fitur utama yaitu pengguna dapat memesan makanan padang yang tersedia pada aplikasi, kemudian dikirim oleh restoran rumah padang terdekat dari tempat pengguna. Adapun fitur lainnya yaitu pengguna dapat melihat menu apa saja yang tersedia, melihat FAQ, dan memberikan review yang nantinya dapat dilihat melalui database. **Uni Ampera App merupakan mini proyek pribadi yang seluruhnya dibuat oleh penulis, Aplikasi ini tidak terhubung dengan restoran makanan manapun, melainkan hanya sebagai contoh pemesanan makanan oleh pengguna.**

## Technology

Uni Ampera APP dibuat menggunakan IDE Android Studio dan ditulis menggunakan bahasa pemrograman Java dan Kotlin, serta menggunakan Firebase firestore sebagai database dan menggunakan Firebase Authentication sebagai data authentication.

## Fitur

### Login dan Register

Ketika pertama kali membuka aplikasi, pengguna akan diminta untuk login terlebih dahulu. Jika pengguna tidak memiliki akun, maka pengguna dapat mendaftar terlebih dahulu melalui register. Setelah melakukan login/register, pengguna akan melihat activity menu dan dapat memilih hal apa yang ingin dilakukan.

### Menu

Menu activity merupakan halaman dimana pengguna dapat memilih aksi yang bisa mereka lakukan. Beberapa aksi yang bisa dilakukan adalah melihat daftar menu, memesan makanan, melihat FAQ, dan memberi review kepada restoran. Pengguna juga bisa melakukan log out pada laman ini.

### Order

Pengguna dapat memesan makanan melalui halaman order/pesan. Setiap makanan terdapat harga yang harus dibayarkan. Pengguna akan memilih makanan yang diinginkan dengan menambah jumlah setiap makanan (default 0). Total harga akan otomatis ditampilkan berdasarkan harga total makanan. Jika pengguna sudah yakin, mereka bisa membeli.

### Map

Setelah membeli, pengguna akan melihat tampilan maps, yang berlokasi di sekitar tempat pembeli. Sistem akan memilihkan tempat restoran terdekat dari tempat pembeli secara otomatis. Dalam real case, akan ada logo driver yang menunjukkan posisi dimana driver berada. Namun, dalam project ini hanya ditampilkan lokasi pembeli dan lokasi restoran, serta ditampilkan restoran mana yang terdekat dan jaraknya.

### List Makanan

Pengguna dapat melihat detail dari setiap menu yang disediakan di halaman List Makanan. Pengguna dapat klik dari setiap jenis makanan untuk melihat detailnya.

### FAQ

Jika user memiliki pertanyaan seputar resto atau aplikasi, bisa dilihat melalui halaman FAQ

### Review

Pengguna dapat memberikan review mengenai penggunaan aplikasi terhadap restoran dengan cara memberika ulasan tertulis. Ulasan yang diberikan oleh pengguna akan disimpen di dalam database
