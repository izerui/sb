package cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cms.mapper.CatalogMapper;
import cms.po.Catalog;

@Component
public class CatalogService {
	@Autowired
	private CatalogMapper catalogMapper;

	public List<Catalog> getAll() {
		return catalogMapper.getAll();
	}
}
