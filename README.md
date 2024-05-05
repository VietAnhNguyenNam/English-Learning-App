# Giới thiệu

English Learning App là ứng dụng học tiếng Anh được phát triển bằng ngôn ngữ Java và thư viện JavaFX. Mã nguồn gồm 3 thành phần chính: các lớp dùng để thao tác các chức năng logic (giao tiếp với cơ sở dữ liệu, giao tiếp với web server,...), các file FXML (đây là các file thể hiện bố cục, màu sắc, kích thước của các vật thể trong giao diện đồ họa) và các lớp controller dùng để điều khiển phản hồi các sự kiện xảy ra khi người dùng thao tác với giao diện đồ họa.

Để build ứng dụng, cần tạo một cơ sở dữ liệu gồm các bảng sau:

```
TABLE `accounts` (`id` int(11) NOT NULL, `username` varchar(255) NOT NULL, `password` varchar(255) NOT NULL)
TABLE `conversation` (`id` int(11) NOT NULL, `user_id` int(11) NOT NULL, `role` varchar(255) NOT NULL, `message` text NOT NULL)
TABLE `saved_words` (`id` int(11) NOT NULL, `user_id` int(11) NOT NULL, `word` varchar(255) NOT NULL)
TABLE `tbl_edict` (`idx` int(255) NOT NULL,`word` varchar(255) DEFAULT NULL,`detail` longtext DEFAULT NULL,`phonetic` varchar(255) DEFAULT NULL)
```

# Cây kế thừa

![Class_Diagram_ELA](https://github.com/VietAnhNguyenNam/English-Learning-App/assets/120655630/18ada0f6-9163-493b-befa-88cc1dca6089)

# Tính năng

## Tra cứu từ điển, phát âm

Người dùng chọn thanh tìm kiếm ở trên cùng và nhập từ cần tra, ứng dụng sẽ hiển thị từ đang nhập và các từ liên quan. Người dùng bấm Enter hoặc nút tìm kiếm để xác nhận. Nếu từ đã nhập có tồn tại, ứng dụng sẽ hiển thị ngữ âm và nghĩa chi tiết của từ đó. 

Để phát âm một từ, người dùng bấm vào biểu tượng phát âm.

Ngoài ra, người dùng có thể lưu một từ bằng cách bấm vào hình ngôi sao. Nếu ngôi sao màu xanh tức là từ đã được lưu, nếu ngôi sao chỉ có viền đen tức là người dùng chưa lưu từ đó.

## Dịch văn bản

Tính năng này dịch văn bản giữa hai ngôn ngữ: tiếng Việt và tiếng Anh. Người dùng nhập văn bản cần dịch vào ô bên trái, văn bản sau khi dịch sẽ được hiển thị ở ô bên phải. Sau khi nhập văn bản, để thực hiện dich, người dùng bấm tổ hợp Ctrl + Enter hoặc nút Translate. 

Để thay đổi ngôn ngữ, người dùng bấm nút mũi tên ở giữa hai ô trên.

## Game học từ vựng

Ứng dụng có hai game:

1. Game đầu tiên là game điền từ vào chỗ trống ở dạng trắc nghiệm 4 đáp án, có tất cả 41 câu hỏi với độ khó được phân bố ngẫu nhiên. Khi hoàn thành trả lời tất cả câu hỏi, người dùng sẽ nhận được thông báo về kết quả của phần chơi.
2. Game thứ hai là game Hangman, người chơi sẽ đoán các từ dựa trên gợi ý, số lần đoán bị giới hạn.

## Lưu từ vựng

Danh sách các từ vựng mà người dùng đã lưu sẽ được hiển thị ở mục này. Khi người dùng bấm vào một từ trong danh sách này, ứng dụng sẽ chuyển sang mục tra cứu và hiển thị thông tin về từ đó. Ngôi sao bên cạnh từ vựng đó sẽ có màu xanh để thể hiện từ này đang được lưu. 

Để hủy lưu từ vựng, người dùng cần bấm vào ngôi sao xanh này, nếu ngôi sao chuyển sang viền đen tức đã xóa thành công.

## Chatbot hỗ trợ học tiếng Anh

Người dùng có thể tương tác với chatbot để được giải đáp các câu hỏi. Để thực hiện hỏi đáp, người dùng nhập thông điệp vào ô dưới cùng. Sau khi nhập xong, người dùng bấm tổ hợp Ctrl + Enter hoặc bấm nút Send để gửi thông điệp. Cuộc trò chuyện giữa người dùng và chatbot được hiển thị ở phần bên trên.

Để tạo cuộc trò chuyện mới, người dùng bấm nút New chat ở trên cùng. Một cửa sổ sẽ hiện ra đê xác nhận, bởi khi tạo cuộc trò chuyện mới thì nội dung của cuộc trò chuyện cũ sẽ bị xóa. Để xác nhận, người dùng chọn Yes.
