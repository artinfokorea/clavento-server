package artinfokorea.clavento.common.type;

import java.util.List;

public class Pagination<T> {
	private final List<T> contents;
	private final int totalPages;
	private final long totalElements;

	public Pagination(List<T> contents, int totalPages, long totalElements) {
		this.contents = contents;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public List<T> getContents() {
		return contents;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}
}
