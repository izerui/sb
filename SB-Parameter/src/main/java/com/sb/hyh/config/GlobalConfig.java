package com.sb.hyh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GlobalConfig {
	@Value("${config.host}")
	private String host;
}