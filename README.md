# Kutuphane Takip Sistemi:books:
Spring Boot ve Katmanlı Mimari ile Kütüphane Takip Sistemi oluşturuldu.

### Teknolojiler
- Java
- Spring Framework
- PostgreSql
- Spring JPA with Hibernate
- Spring Security
---------------------------------------------------

Sisteme, üye ve kütüphane admini olmak üzere iki tür kullanıcı giriş yapabilir. 
#### Req 1 : Üyeler ve Kütüphane adminleri sisteme kayıt olmalı.
 Kabul Kriterleri:

Üye ve Kütüphane admini; ad, soyad, e-Posta, telefon, adres, şifre bilgilerini girerek sisteme kayıt olur.
Bu alanların girilmesi zorunludur. 
Girilen e-Posta'ya ait kullanıcı mevcut ise başka bir e-posta istenir.
Sisteme kaydolan üyeler ve adminler, e-posta ve şifre ile sisteme giriş yapabilir.

#### Req 2 : Sisteme, kütüphane adminleri tarafından kitap ekleme, silme, güncelleme işlemleri yapılabilmeli.
#### Req 3 : Üyeler; kitap detaylarını görüntüleme, kategorilere ve yazarlara göre kitap listelerini görüntüleme  ve kitap kiralama işlemlerini yapabilmeli.
Kabul Kriterleri:

Üyenin kiralama yapabilmesi için seçilen kitabın başka kullanıcılar tarafından kirada olmaması gerekir.    
#### ER Diyagramı
![Veritabanına ait ER Diyagramı](https://github.com/java-heroes/Kutuphane_Sistemi/blob/main/ER.PNG)
---------------------------------------------------

### Takım Lideri
Muhammed Veysi Güler
### Takım Üyeleri
Hatice Öztürk <br>
Furkan Bakal <br>
Usman Khalid <br>
