package cms.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cms.po.Catalog;
import cms.service.CatalogService;

@RestController
public class CatalogController {
	@Autowired
	private CatalogService catalogService;

	@RequestMapping("/test")
	public List<Catalog> list() {
		return catalogService.getAll();
	}
}
