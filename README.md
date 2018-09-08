<h1>Bot Kontrol Ekranı</h1>
<h3> Her ne kadar bir web uygulaması olmasa da program ilk çalıştığında
        bizi <q>bot kontrol</q> ekranı karşılıyor.
        Algoritmasının tamamen bana ait olduğu bu ekran da kullanıcının karşısına rastgele adet dikdörtgenler ve rastgele adet daireler geliyor.
        Kullanıcıdan rastgele olarak dikdörtgen ya da daire şekillerini seçmesi isteniyor.
Kullanıcı doğru seçimleri yaptıktan sonra bizi kullanıcı girişi karşılıyor.


<img src="https://uzaqja.am.files.1drv.com/y4mm2SwA23RSQRRUBEZBK_grHgUcAhKiTfdIuvXqK_4DaaYTQh7j0DE6Byjtoc4GRt1yFHMfvrlgKLmmFt4GUhgQPAlEJvlWUYFK3tOZBJurBIVVb1ZzaU0Tl0R6eLG9k6RVK_sWNLSLav0JaboSnFDHYQ6_pVIC9tF6h1_tQue5Pxm3pNVTh5TzyFkr8YRv9fnFRa0iwqZyffGM-ifjzrAAg?width=674&height=511&cropmode=none"></img>

<h1>Kullanıcı Girişi Ekranı <h1/>
<h3> Kullanıcı girişini seçtikten sonra burda kullanıcıyı <q>abone No</q> ve <q>şifre</q> bilgilerinin istendiği bir ekran karşılıyor.Kullanıcın bilgileri projeye entegre veritabanımızda tutulmaktadır.Kullanıcı parolası ise MD5 hash algoritması ile şifrelenmiş şekilde veritabanında tutulmaktadır.Kullanıcı <q>abone no </q> bilgisini girerken eş zamanlı olarak veri tabanında olup olmadığı sorgulanmak da eğer var ise yeşil yok ise kırmızı renkte kullanıcıya gözükmektedir. </h3>

[Kullanıcı Ekranı Girişi Önizleme](https://drive.google.com/open?id=0B_ZmQESdFkPySE5ETVcxSHhQZzA)


<h1>Ana Ekran</h1>
<h2>Bilgilerim Paneli<h2>
<h3>Kullanıcı ana ekrana geçiş yaptığı zaman ön tanımlı olarak onu ilk bilgilerim paneli karşılamaktadır.Bilgilerim panelinde kullanıcının <q>kişisel bilgileri</q>,<q>abonelik bilgileri</q> ve <q>konut bilgileri</q> gözükmekte ayrıca <q>son giriş tarihi</q>,<q>okunmayan mesaj adeti</q> ve <q>ödenmeyen fatura adeti</q> gibi güncel bilgiler de kullanıcıya gösterilmektedir.Bu bölümde kullanıcının <q>Ad</q>,<q>Soyad</q>,<q>Telefon numarası</q> bilgilerinin şimdilik herhangi bir yetkili onayı gerekmeksizin değiştirmesine izin verilmektedir.</h3>

[Bilgilerim Paneli Önizleme](https://drive.google.com/open?id=0B_ZmQESdFkPyS2tJR0NueExCNEE)

<h2>Faturalarım Paneli</h2>
<h3>Bu panelde kullanıcıya tüm faturalarının detayı indirgenmiş bilgileri listelenmektedir.Kullanıcı burda faturaları <q>Fatura Tutarı</q>,<q>Son Ödeme Tarihi</q> ,<q>Ödenme Durumu</q> ve <q>Fatura Numarası</q> gibi bilgilere göre sıralayabilmektedir.Aynı şekilde bu panelde kullanıcı seçtiği bir faturaya dair detaylı bilgileri görebilmekte bu detaylı bilgileri yazdırabilmekte , resmini <q>pdf</q> formatında alabilmekte ve bu <q>pdf</q> dosyasını istediği bir e-mail adresine gönderebilmektedir.Son olarak bu panelde seçili 2 faturanın detaylı bilgileri kısyaslanabilmektedir.</h3>

[Faturalarım Paneli Önizleme](https://drive.google.com/open?id=0B_ZmQESdFkPyQ3d4UDkyMTlOOU0),

<h2>Fatura Grafiklerim Paneli</h2>
<h3>Bu panelde kullanıcıya doğalgaz şirketinin önceden belirlediği kriterlere göre aylık grafikler gösterilmektedir.</h3>

[Fatura Grafiklerim Paneli Önizleme](https://drive.google.com/open?id=0B_ZmQESdFkPyYW5fdW40RWE4WVU)

<h2>Mesajlarım Paneli</h2>
<h3>Bu panelde kullanıcı kendisine yöneticilerden gönderilen mesajları görebilmektedir.</h3>

[Mesajlarım Paneli Önizleme](https://drive.google.com/open?id=0B_ZmQESdFkPyNVIxdmFvZWFOSHM)

<h2>Para Matik Paneli ile Fatura Ödeme</h2>
<h3>Kullanıcı eğer bir faturayı ödemek isterse bakiyesinde yeterli sanal para varsa ödeme yapılır yoksa otomatik olarak Para Matik paneline aktarılır.Bu panelde kredi kartından para yükleme işlemi e-mail doğrulaması ile simüle edilmiştir ve para yükleme işleminin özetini e-mail ile kendine gönderebilmektedir.Ayrıca kullanıcı bu panelde tüm yükleme ve ödeme işlemlerinin dökümünü görebilmektedir.Bu panelde düzenli ifadeler uygulanmakta ve kullanıcının hatalı bilgiler girmesi engellenmektedir. ( Örneğin Kredi kart numarası girilirken her 4 sayıdan sonra otomatik "-" işareti eklemektedir.) Ayrıca Kredi Kartı Numarası için geçerli bir numara olup olmadığını kontrol eden Lhun algoritmasını uygulamaktadır. </h3>

[Para Matik Paneli Önizleme-1](https://drive.google.com/open?id=0B_ZmQESdFkPyMVcyV0VtRkd1ZG8)

[Para Matik Paneli Önizleme-2](https://drive.google.com/open?id=0B_ZmQESdFkPyYks5d1p4NG9DMUk)
        
        
       

