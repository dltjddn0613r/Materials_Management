package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import service.ProductSearchService;
import service.ProductPage;

public class ProductSearchHandler implements CommandHandler {
    private ProductSearchService productSearchService = new ProductSearchService(); // ProductSearchService 인스턴스 생성

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 검색어와 페이지 번호 파라미터를 가져옵니다.
        String searchQuery = req.getParameter("searchQuery");
        String pageNoVal = req.getParameter("pageNo");
        int pageNo = 1;

        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal); // 페이지 번호를 정수로 변환
        }

        // 검색어와 페이지 번호를 이용해 검색 결과를 가져옵니다.
        ProductPage productPage = productSearchService.searchProducts(searchQuery, pageNo);

        // 검색 결과와 검색어를 request 속성에 저장합니다.
        req.setAttribute("productPage", productPage);
        req.setAttribute("searchQuery", searchQuery);

        // 결과를 보여줄 JSP 페이지로 이동합니다.
        return "/WEB-INF/view/productSearch.jsp";
    }
}
