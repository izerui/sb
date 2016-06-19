package ${rootPackage}.controller;

import ${rootPackage}.po.${modelName};
import org.springframework.beans.factory.annotation.Autowired;
import ${rootPackage}.service.${modelName}Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("${ModelName}")
public class ${modelName}Controller {

    @Autowired
    private ${modelName}Service ${ModelName}Service;

}