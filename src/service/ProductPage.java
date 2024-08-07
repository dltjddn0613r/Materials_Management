package service;

import java.util.List;

import model.Product;

public class ProductPage {

	private int total; // 전체 게시글 수
	private int currentPage; // 현재 페이지 번호
	private List<Product> content; // 현재 페이지의 게시글 목록
	private int totalPages; // 전체 페이지 수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	
	
	public ProductPage(int total, int currentPage, int size, List<Product> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;

		if (total == 0) {// 전체 게시글 수가 0일 경우
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;// 전체 페이지 수 계산
			if (total % size > 0) {// 게시글 개수를 이용해서 전체 페이지 개수를 구한다
				totalPages++;// 개시글 개수를 size로 나눈 값을 페이지 개수로 한다
			}
			int modVal = currentPage % 5;// 화면 하단에 보여줄 시작 페이지와 끝 페이지 계산
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0)
				startPage -= 5;

			endPage = startPage + 4;// 시작페이지 번호에서 4를 추가한 값이 끝 페이지 번호이다.
			if (endPage > totalPages)
				endPage = totalPages;
		}
	}
	public int getTotal() {
		return total;
	}
	public boolean hasNoArticles() {
		return total == 0;
	}
	public boolean hasArticles() {
		return total > 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Product> getContent() {
		return content;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}	
}
