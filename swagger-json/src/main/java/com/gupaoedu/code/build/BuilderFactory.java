package com.gupaoedu.code.build;

import freemarker.template.Template;

import java.io.File;
import java.util.Map;

public class BuilderFactory {

    /***
     * 构建Controller
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap,//数据模型
                                String templatePath, //模板路径
                                String templateFile, //模板文件
                                String storePath,    //存储路径
                                String suffix){      //生成文件后缀名字
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(BuilderFactory.class.getResource(templatePath).getPath(), templateFile);

            //创建文件夹
            String path = TemplateBuilder.PROJECT_PATH+storePath.replace(".","/");
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }

            //创建文件
            TemplateUtil.writer(template,modelMap,path+"/"+modelMap.get("filename"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
