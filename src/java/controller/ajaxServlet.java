/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import config.Config;
import model.BookingDetails;

/**
 *
 * @author CTT VNPAY
 */
public class ajaxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vnp_Version = "2.1.0";// phiên bản api mà merchant kết nối
        String vnp_Command = "pay"; // mã API sử dụng.
        // String orderType = req.getParameter("ordertype");
        String orderType = "other";
        long amount = Integer.parseInt(req.getParameter("TotalPrice")) * 100;
        String bankCode = req.getParameter("bankCode");

        String vnp_TxnRef = Config.getRandomNumber(8); // Mã tham chiếu của giao dịch tại hệ thống của merchant. Phân
                                                       // biệt các đơn hàng của merchant. Unique
        String vnp_IpAddr = Config.getIpAddress(req);
        String vnp_TmnCode = Config.vnp_TmnCode; // mã website của merchant trong hệ thống vnpay
        String roomInfo = req.getParameter("NameRoomType");
        String adult = req.getParameter("Adult");
        String child = req.getParameter("Child");
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", roomInfo + "- Adult: " + adult + "- Child: " + child);
        vnp_Params.put("vnp_OrderType", orderType);
        // String locate = req.getParameter("language");
        // if (locate != null && !locate.isEmpty()) {
        // vnp_Params.put("vnp_Locale", locate);
        // } else {
        // }
        vnp_Params.put("vnp_Locale", "vn"); // ngôn ngữ giao diện hiển thị
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl); // url của merchant để thông báo kết quả giao dịch sau
                                                               // khi thanh toán.
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                // Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                // Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString()); // hashsecret: mã kiểm
                                                                                               // tra đảm bảo dữ liệu
                                                                                               // không bị thay đổi
                                                                                               // trong quá trình chuyển
                                                                                               // từ merchant sang vnpay
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        // com.google.gson.JsonObject job = new JsonObject(); // tạo object json
        // job.addProperty("code", "00");
        // job.addProperty("message", "success");
        // job.addProperty("data", paymentUrl);
        // Gson gson = new Gson();
        // resp.getWriter().write(gson.toJson(job)); //gửi về cho hàm callback
        resp.sendRedirect(paymentUrl);
    }
}
