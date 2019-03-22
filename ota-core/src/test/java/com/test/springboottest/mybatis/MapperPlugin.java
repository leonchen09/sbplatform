package com.test.springboottest.mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MapperPlugin extends PluginAdapter {

	private static final String DEFAULT_DAO_SUPER_CLASS = "com.battery.common.mapper.BaseMapper";
	private static final String DEFAULT_EXPAND_DAO_SUPER_CLASS = "com.battery.common.mapper.BaseMapper";
	private String daoTargetDir;
	private String daoTargetPackage;

	private String daoSuperClass;

	// 扩展
	private String expandDaoTargetPackage = "yes";
	private String expandDaoSuperClass;

	private ShellCallback shellCallback = null;

	public MapperPlugin() {
		shellCallback = new DefaultShellCallback(false);
	}

	/**
	 * 验证参数是否有效
	 * 
	 * @param warnings
	 * @return
	 */
	public boolean validate(List<String> warnings) {
		daoTargetDir = properties.getProperty("targetProject");
		boolean valid = stringHasValue(daoTargetDir);

		daoTargetPackage = properties.getProperty("targetPackage");
		boolean valid2 = stringHasValue(daoTargetPackage);

		daoSuperClass = properties.getProperty("daoSuperClass");
		if (!stringHasValue(daoSuperClass)) {
			daoSuperClass = DEFAULT_DAO_SUPER_CLASS;
		}

		expandDaoTargetPackage = properties.getProperty("expandTargetPackage");
		expandDaoSuperClass = properties.getProperty("expandDaoSuperClass");
		if (!stringHasValue(expandDaoSuperClass)) {
			expandDaoSuperClass = DEFAULT_EXPAND_DAO_SUPER_CLASS;
		}
		return valid && valid2;
	}

	/**
	 * 生成dao
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
				"BaseMapper<" + introspectedTable.getBaseRecordType() + ",Integer" + ">");
		FullyQualifiedJavaType imp = new FullyQualifiedJavaType(daoSuperClass);
		interfaze.addSuperInterface(fqjt);// 添加 extends BaseMapper<User>
		interfaze.addImportedType(imp);// 添加import com.battery.common.mapper.BaseMapper;
		interfaze.getMethods().clear();
		interfaze.addJavaDocLine("/**");
		interfaze.addJavaDocLine(" * 由MyBatis Generator工具自动生成，请不要手动修改");
		interfaze.addJavaDocLine(" */");
		return true;
	}

	/* 
	 * 创建xml配置文件 
	 * 新增deleteSelective
	 * 	   deleteByPKs
	 * 	   selectListSelective
	 *     selectListSelectivePaging
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement where = createWhereAllColumns(introspectedTable);
		String baseRecordType = introspectedTable.getBaseRecordType();
		String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		
		// deleteSelective sql
		XmlElement deleteSelective = new XmlElement("delete");
		deleteSelective.addAttribute(new Attribute("id", "deleteSelective"));
		deleteSelective.addAttribute(new Attribute("parameterType", baseRecordType));
		deleteSelective.addElement(
				new TextElement("delete * from " + tableName));
		deleteSelective.addElement(where);

		// deleteByPKs sql
		XmlElement deleteByPKs = new XmlElement("delete");
		deleteByPKs.addAttribute(new Attribute("id", "deleteByPKs"));
		deleteByPKs.addAttribute(new Attribute("parameterType", "java.lang.Integer"));
		deleteByPKs.addElement(
				new TextElement("delete from " + tableName));
		deleteByPKs.addElement(new TextElement(" where "));

		XmlElement deleteByPKsForeach = new XmlElement("foreach");
		deleteByPKsForeach.addAttribute(new Attribute("collection", "array"));
		deleteByPKsForeach.addAttribute(new Attribute("index", "index"));
		deleteByPKsForeach.addAttribute(new Attribute("separator", "or"));
		deleteByPKsForeach.addAttribute(new Attribute("item", "item"));
		deleteByPKsForeach.addElement(new TextElement(" id = #{item,jdbcType=INTEGER} "));
		deleteByPKs.addElement(deleteByPKsForeach);
		
		// selectListSelective sql
		XmlElement selectListSelective = new XmlElement("select");
		selectListSelective.addAttribute(new Attribute("id", "selectListSelective"));
		selectListSelective.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		selectListSelective.addAttribute(new Attribute("parameterType", baseRecordType));
		selectListSelective.addElement(new TextElement("select"));
		XmlElement selectListSelectiveInclude = new XmlElement("include");
		selectListSelectiveInclude.addAttribute(new Attribute("refid", "Base_Column_List"));
		selectListSelective.addElement(selectListSelectiveInclude);
		selectListSelective.addElement(new TextElement("from "+ tableName ));
		selectListSelective.addElement(where);
		
		// selectListSelectivePaging sql
		XmlElement selectListSelectivePaging = new XmlElement("select");
		selectListSelectivePaging.addAttribute(new Attribute("id", "selectListSelectivePaging"));
		selectListSelectivePaging.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		selectListSelectivePaging.addAttribute(new Attribute("parameterType", baseRecordType));
		selectListSelectivePaging.addElement(new TextElement("select"));
		XmlElement selectListSelectivePagingInclude = new XmlElement("include");
		selectListSelectivePagingInclude.addAttribute(new Attribute("refid", "Base_Column_List"));
		selectListSelectivePaging.addElement(selectListSelectivePagingInclude);
		selectListSelectivePaging.addElement(new TextElement("from "+ tableName ));
		selectListSelectivePaging.addElement(where);
		
		XmlElement parentElement = document.getRootElement();
		parentElement.addElement(deleteSelective);
		parentElement.addElement(deleteByPKs);
		parentElement.addElement(selectListSelective);
		parentElement.addElement(selectListSelectivePaging);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	//创建带有所有表字段的where xml element
	private XmlElement createWhereAllColumns(IntrospectedTable introspectedTable) {
		XmlElement where = new XmlElement("where");
		StringBuilder sb = new StringBuilder();
		for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
			XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
			sb.setLength(0);
			sb.append(introspectedColumn.getJavaProperty());
			sb.append(" != null"); //$NON-NLS-1$
			isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
			where.addElement(isNotNullElement);

			sb.setLength(0);
			sb.append(" and ");
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
			isNotNullElement.addElement(new TextElement(sb.toString()));
		}
		return where;
	}

	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
		JavaFormatter javaFormatter = context.getJavaFormatter();
		List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<GeneratedJavaFile>();
		for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {
			CompilationUnit unit = javaFile.getCompilationUnit();
			FullyQualifiedJavaType baseModelJavaType = unit.getType();

			String shortName = baseModelJavaType.getShortName();

			GeneratedJavaFile mapperJavafile = null;

			if (shortName.endsWith("Mapper")) { // 扩展Mapper
				if (stringHasValue(expandDaoTargetPackage)) {
					Interface mapperInterface = new Interface(
							expandDaoTargetPackage + "." + shortName.replace("Mapper", "ExpandMapper"));
					mapperInterface.setVisibility(JavaVisibility.PUBLIC);
					mapperInterface.addJavaDocLine("/**");
					mapperInterface.addJavaDocLine(" * " + shortName + "扩展");
					mapperInterface.addJavaDocLine(" */");

					FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(expandDaoSuperClass);
					mapperInterface.addImportedType(daoSuperType);
					mapperInterface.addSuperInterface(daoSuperType);

					mapperJavafile = new GeneratedJavaFile(mapperInterface, daoTargetDir, javaFormatter);
					try {
						File mapperDir = shellCallback.getDirectory(daoTargetDir, daoTargetPackage);
						File mapperFile = new File(mapperDir, mapperJavafile.getFileName());
						// 文件不存在
						if (!mapperFile.exists()) {
							mapperJavaFiles.add(mapperJavafile);
						}
					} catch (ShellException e) {
						e.printStackTrace();
					}
				}
			}
//			else if (!shortName.endsWith("Example")) { // CRUD Mapper
//				Interface mapperInterface = new Interface(daoTargetPackage + "." + shortName + "Mapper");
//
//				mapperInterface.setVisibility(JavaVisibility.PUBLIC);
//				mapperInterface.addJavaDocLine("/**");
//				mapperInterface.addJavaDocLine(" * 由MyBatis Generator工具自动生成，请不要手动修改");
//				mapperInterface.addJavaDocLine(" */");
//
//				FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(daoSuperClass);
//				// 添加泛型支持
//				daoSuperType.addTypeArgument(baseModelJavaType);
//				mapperInterface.addImportedType(baseModelJavaType);
//				mapperInterface.addImportedType(daoSuperType);
//				mapperInterface.addSuperInterface(daoSuperType);
//
//				mapperJavafile = new GeneratedJavaFile(mapperInterface, daoTargetDir, javaFormatter);
//				mapperJavaFiles.add(mapperJavafile);
//
//			}
		}
		return mapperJavaFiles;
	}

	/**
	 * value是否有值
	 * 
	 * @param value
	 * @return
	 */
	private boolean stringHasValue(String value) {
		if (value != null) {
			return true;
		} else {
			return false;
		}
	}
}