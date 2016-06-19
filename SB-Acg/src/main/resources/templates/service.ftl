package ${rootPackage}.service;

import ${rootPackage}.po.${modelName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${rootPackage}.dao.${modelName}Dao;
import ${rootPackage}.service.base.GenericServiceImpl;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class ${modelName}Service extends GenericServiceImpl<${modelName}, ${modelPrimaryKey}> {

	@Autowired
	private OpenapiBanjieDao openapiBanjieDao;

}