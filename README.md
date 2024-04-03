# Sơ đồ lớp

![englishLearningApp (1)](https://github.com/VietAnhNguyenNam/English-Learning-App/assets/120655630/5951ff25-8026-4282-8ae5-ce5561548bb0)

# Cài đặt cơ sở dữ liệu từ điển

**B1:** Dùng Xampp, mở phpmyadmin, tạo cơ sở dữ liệu mới đặt tên là `dictionary`.

**B2:** Bấm vào CSDL `dictionary`, chọn import, chọn import file `edict.sql`, chọn ok.

**B3:** Mở IntelliJ, bấm tổ hợp Ctrl+Shift+Alt+S, chọn modules ở project settings, chọn dependencies, bấm vào dấu '+', chọn JAR or directories, chọn file `mysql-connector-j-8.3.0.jar` nằm trong repo, chọn ok.

⚠️ Mặc định port của MySQL trong Xampp là `3306`, tài khoản là `root` và không đặt mật khẩu. Nếu khác cần chỉnh lại trong file `Database.java`.

# Sử dụng CSDL và Translate API

## CSDL

Có 2 static method: `findFirst10` - tìm ra 10 đầu tiên trong từ điển khớp với chuỗi đưa vào, `meaningOf` - lấy nghĩa của một từ.

```
List<String> stringList = Database.findFirst10("app");

String meaning = Database.meaningOf("dictionary");
```

## Translate API

Có 2 static method: `en2Vi` - dịch từ tiếng Anh sang tiếng Việt, `vi2En` - dịch từ tiếng Việt sang tiếng Anh.

```
String translatedText = Translate.en2Vi("english");

String translatedText = Translate.vi2En("tiếng Việt");
```
