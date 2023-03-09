package com.koushik.blog.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

	// this is given as pagination response to frontend, where it is used to judge
	// total pages and is last page or not etc.

	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;

	private boolean lastPage;
}
