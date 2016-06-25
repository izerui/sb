package ${rootPackageNew}.service;

import ${rootPackageNew}.po.${modelName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${rootPackageNew}.dao.${modelName}Dao;
import ${rootPackage}.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class ${modelName}Service extends BaseService<${modelName}, ${modelPrimaryKey}> {

	@Autowired
	private ${modelName}Dao ${ModelName}Dao;

}