package com.sb.hyh.vo;

import lombok.Data;
import lombok.experimental.Builder;

@Builder
@Data
public class DemoResponseBody {
	private String name;
	private String descriptions;
}
