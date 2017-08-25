package br.com.infoglobo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Description {
	private String type;
	private Object content;
}
