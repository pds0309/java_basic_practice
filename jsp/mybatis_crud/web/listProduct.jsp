<%@ page import="com.dto.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.service.ProductServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-11
  Time: 오후 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>전체 상품 목록 관리</title>
</head>
<script>
    window.onload = () => {
        // 다중삭제 체크박스들에 이벤트 발생 시
        // 상태를 deleteall form 제출을 위한 hidden input 에 전달함
        document.querySelectorAll("input[name='reqidlist']")
            .forEach(input => input.addEventListener("change", () => {
                document.querySelector("input[name='reqidlistresult']").value =
                    changeStateForDeleteAll().filter(value => value !== undefined);
            }));
        pSum();

        function changeStateForDeleteAll() {
            return Array.from(document.querySelectorAll("input[name='reqidlist']"))
                .map(input => {
                    if (input.checked) {
                        return input.parentNode.parentElement.querySelector('input[name="reqid"]').value;
                    }
                });
        }

        let updateStatus = -1;
        document.querySelectorAll(".c-btn-update").forEach(btn => {
            btn.addEventListener("click", (event) => {
                const eventTarget = event.target;
                const productId = eventTarget.previousElementSibling.value;
                const eventParentTRTag = eventTarget.parentNode.parentElement;
                let requestedQuantity = eventParentTRTag.querySelector(".c-quantity");
                // 자연수 유효성 체크
                if (!isNaturalNum(requestedQuantity.value)) {
                    return;
                }
                let httpRequest;

                requestUpdateProduct({
                    prodid: productId,
                    quantity: parseInt(requestedQuantity.value)
                }, httpRequest, requestedQuantity);

                if (updateStatus === 1) {
                    eventParentTRTag.querySelector(".c-sum").innerText = requestedQuantity.value * eventParentTRTag.querySelector(".c-price").innerText;
                    pSum();
                }
            });
        });
        // true: 요청 가능한 적절한 자연수
        // false : 올바르지 않은 숫자 형식으로 요청 불가능
        function isNaturalNum(val) {
            // 0 미만 또는 숫자가 아닌 경우
            if (val < 0 || !/^[0-9]+$/.test(val)) {
                alert("올바른 상품 개수를 입력하세요!");
                return false;
            }
            return true;
        }

        function requestUpdateProduct(obj, req, quant) {
            req = new XMLHttpRequest();
            req.onreadystatechange = () => {
                if (req.readyState === 4 && req.status === 200) {
                    let result = JSON.parse(req.responseText);
                    updateStatus = result.updatestatus;
                    if (updateStatus === 0) {
                        quant.value = result.data.quantity;
                        alert("정상적으로 업데이트 되지 않았습니다!");
                        return;
                    }
                    if (updateStatus === -1) {
                        alert("비정상적인 요청으로 업데이트 실패.");
                        return;
                    }
                    alert("갯수 수정 성공!");
                }
            }
            req.open("POST", 'updateProduct.jsp', false);
            req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            req.send(JSON.stringify(obj));
        }

        function pSum() {
            document.getElementById("id-span-psum").innerText =
                Array.from(document.querySelectorAll(".c-sum"))
                    .map(val => parseInt(val.innerText))
                    .reduce((prev, curr) => prev + curr);
        }

    }
</script>
<body>
<%
    List<ProductDTO> productDTOList = new ProductServiceImpl().selectAllAsc();
%>
<table id="id-table" border="1">
    <tr>
        <th>다중선택</th>
        <th>상품아이디</th>
        <th>상품명</th>
        <th>가격</th>
        <th>갯수</th>
        <th>합계</th>
        <th>삭제</th>
        <th>수정</th>
    </tr>
    <%
        for (ProductDTO product : productDTOList) {
    %>
    <tr>
        <td>
            <input type="checkbox" name="reqidlist">
        </td>
        <td class="c-id">
            <%=product.getProdid()%>
        </td>
        <td>
            <%=product.getProdname()%>
        </td>
        <td class="c-price">
            <%=product.getPrice()%>
        </td>
        <td>
            <!-- ajax 수정 요청에 대한 응답의 성공 시 해당 값은 로드 없이 변경되어야 한다. -->
            <input class="c-quantity" type="text" value=<%=product.getQuantity()%>>
        </td>
        <td>
            <p class="c-sum">
                <%=product.getQuantity() * product.getPrice()%>
            </p>
        </td>
        <td>
            <!-- form 방식 삭제 요청 시 삭제에 대한 응답 결과 화면으로 전환된다 -->
            <form action="deleteProduct.jsp" method="post">
                <input type="hidden" value=<%=product.getProdid()%> name="reqid">
                <button type="submit" name="deleteone">삭제</button>
            </form>
        </td>
        <td>
            <!-- ajax 방식 요청 -->
            <input type="hidden" value=<%=product.getProdid()%> name="reqid">
            <button class="c-btn-update" type="submit" name="updateone">수정</button>
        </td>
    </tr>
    <%
        }
    %>
</table>
<form action="deleteAllProduct.jsp" method="post">
    <input type="hidden" name="reqidlistresult" value="">
    <button id="id-btn-deleteall" type="submit" name="다중삭제요청">선택항목 모두 삭제</button>
</form>
<span> 총합:</span><span id="id-span-psum"></span>
</body>
</html>
