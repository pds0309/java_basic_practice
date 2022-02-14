<%@ page import="java.io.BufferedReader" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="com.service.ProductServiceImpl" %>
<%@ page import="org.json.JSONException" %>
<%@ page import="com.service.ProductService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    BufferedReader reader = request.getReader();
    String result = "";
    String read = reader.readLine();
    if (read != null) {
        result = read;
    }
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    out.clear();
    try {
        ProductService productService = new ProductServiceImpl();
        JSONObject jsonObject = new JSONObject(result);
        int status = productService.updateQuantityById(jsonObject.getString("prodid"), jsonObject.getInt("quantity"));
        JSONObject resultJSON = new JSONObject().put("updatestatus", status);
        if (status == 0) {
            jsonObject.put("quantity", productService.selectQuantityById(jsonObject.getString("prodid")));
        }
        resultJSON.put("data",jsonObject);
        out.println(resultJSON);
    } catch (JSONException e) {
        e.printStackTrace();
        out.println(new JSONObject().put("updatestatus", -1).put("errormsg", "올바르지 않은 요청 식별됨"));
    }
%>