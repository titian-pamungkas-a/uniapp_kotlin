# Uni Ampera APP

## Source Code Java [DI SINI](https://github.com/titian-pamungkas-a/ppb)


![image](https://user-images.githubusercontent.com/77373958/215312032-ab668c72-95fd-4ee3-9b3d-12c45154c800.png)
![image](https://user-images.githubusercontent.com/77373958/215312030-9df540f9-1659-4178-9bff-43608a1eb925.png)



Uni Ampera APP adalah aplikasi pemesanan makanan berbasis android yang ditujukan untuk pengguna yang ingin memesan makanan padang di daerah Gebang dan Keputih, Surabaya. Uni Ampera App memiliki fitur utama yaitu pengguna dapat memesan makanan padang yang tersedia pada aplikasi, kemudian dikirim oleh restoran rumah padang terdekat dari tempat pengguna. Adapun fitur lainnya yaitu pengguna dapat melihat menu apa saja yang tersedia, melihat FAQ, dan memberikan review yang nantinya dapat dilihat melalui database. 

***Uni Ampera App merupakan mini proyek pribadi yang seluruhnya dibuat oleh penulis, Aplikasi ini tidak terhubung dengan restoran makanan manapun, melainkan hanya sebagai contoh pemesanan makanan oleh pengguna.***

## Technology

Uni Ampera APP dibuat menggunakan IDE Android Studio dan ditulis menggunakan bahasa pemrograman Java dan Kotlin, serta menggunakan Firebase firestore sebagai database dan menggunakan Firebase Authentication sebagai data authentication.

## Fitur

### Login dan Register


![image](https://user-images.githubusercontent.com/77373958/215312045-d860a4d4-da60-485a-a612-06bb97b80d36.png)
![image](https://user-images.githubusercontent.com/77373958/215312051-3d8a7c0b-4162-45f5-ab8e-9e7561aaef16.png)



Ketika pertama kali membuka aplikasi, pengguna akan diminta untuk login terlebih dahulu. Jika pengguna tidak memiliki akun, maka pengguna dapat mendaftar terlebih dahulu melalui register. Setelah melakukan login/register, pengguna akan melihat activity menu dan dapat memilih hal apa yang ingin dilakukan.

### Menu


![image](https://user-images.githubusercontent.com/77373958/215312060-724eb485-b2e4-4d13-8399-63756d268efb.png)



Menu activity merupakan halaman dimana pengguna dapat memilih aksi yang bisa mereka lakukan. Beberapa aksi yang bisa dilakukan adalah melihat daftar menu, memesan makanan, melihat FAQ, dan memberi review kepada restoran. Pengguna juga bisa melakukan log out pada laman ini.

### Order


![image](https://user-images.githubusercontent.com/77373958/215312068-88af15e1-1b89-4301-8eb0-1834ebd39954.png)



Pengguna dapat memesan makanan melalui halaman order/pesan. Setiap makanan terdapat harga yang harus dibayarkan. Pengguna akan memilih makanan yang diinginkan dengan menambah jumlah setiap makanan (default 0). Total harga akan otomatis ditampilkan berdasarkan harga total makanan. Jika pengguna sudah yakin, mereka bisa membeli.

### Map


![image](https://user-images.githubusercontent.com/77373958/215312074-d76a15f8-deba-4480-99ff-b81c98677c12.png)


Setelah membeli, pengguna akan melihat tampilan maps, yang berlokasi di sekitar tempat pembeli. Sistem akan memilihkan tempat restoran terdekat dari tempat pembeli secara otomatis. Dalam real case, akan ada logo driver yang menunjukkan posisi dimana driver berada. Namun, dalam project ini hanya ditampilkan lokasi pembeli dan lokasi restoran, serta ditampilkan restoran mana yang terdekat dan jaraknya.

### List Makanan


![image](https://user-images.githubusercontent.com/77373958/215312083-f70ade26-b1f0-4925-b263-effeda4aa656.png)
![image](https://user-images.githubusercontent.com/77373958/215312084-470e1e00-b19d-4a45-aebf-7906e5c1b9fb.png)



Pengguna dapat melihat detail dari setiap menu yang disediakan di halaman List Makanan. Pengguna dapat klik dari setiap jenis makanan untuk melihat detailnya.

### FAQ


![image](https://user-images.githubusercontent.com/77373958/215312087-e365d988-8458-4ddf-bfea-cc5579974664.png)



Jika user memiliki pertanyaan seputar resto atau aplikasi, bisa dilihat melalui halaman FAQ

### Review


![image](https://user-images.githubusercontent.com/77373958/215312090-43838f55-c674-48b2-89ea-20b42e6f8fca.png)



Pengguna dapat memberikan review mengenai penggunaan aplikasi terhadap restoran dengan cara memberika ulasan tertulis. Ulasan yang diberikan oleh pengguna akan disimpen di dalam database
