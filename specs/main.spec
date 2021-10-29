Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs

Ozdilek Uygulama Testi
----------------------
* Uygulamanın açıldığını kontrol et.
* "com.ozdilek.ozdilekteyim:id/tv_startShoppingStore" ID'li elemente tıkla
* Alışveriş sayfasının açıldığını kontrol et.
* "//android.widget.FrameLayout[@content-desc=\"Kategoriler\"]" xPath'li elemente tıkla
* Kategori sayfasının açıldığını kontrol et.
* "//android.widget.RelativeLayout[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'][2]" xPath'li elemente tıkla
* "//android.widget.RelativeLayout[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'][4]" xPath'li elemente tıkla
* "2" kere sayfayı aşağı kayır.
* Ürün listesinden rastgele bir ürün seç.
* Ürün detay sayfasının açıldığını kontrol et.
* "2" kere sayfayı aşağı kayır.
* "1" saniye bekle
* "com.ozdilek.ozdilekteyim:id/imgAddFav" ID'li elemente tıkla
* Giriş sayfasının açıldığını kontrol et.
* Eposta alanına "test@testinium.com" ve şifre alanına "123456" değerlerini gir.
* "2" saniye bekle
* Uygulamada "2" kez geri butonuna bas.
* "1" saniye bekle
* Ürün listesinden rastgele bir ürün seç.
* Beden listesinden rastgele bir beden seç.
* "1" saniye bekle
* "com.ozdilek.ozdilekteyim:id/relLayAddCartBtn" ID'li elemente tıkla
* "1" saniye bekle