package com.doctor.interceptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.doctor.util.Page;
import com.mysql.jdbc.Connection;

/**
 * 分页拦截器
 * @author Doctor邓
 *
 */
/**
 * type   为要拦截的类
 * method 要拦截的方法
 * args   要拦截的方法的参数
 *
 */
@Intercepts({@Signature(type=StatementHandler.class,  method = "prepare", args = { Connection.class ,Integer.class})})
public class PageInterceptor implements Interceptor {
	/**
	 * 经过intercept方法的都是需要代理的,反之不会经过intercept方法
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation;
		/**
		 * 使用MyBatisMetaObject对象将statementHandle转换为一个可以方便的访问其属性的对象，利用的是反射原理
		 */
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, null);
		/**
		 * 获取statementHandler的mappedStatement属性
		 */
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		String id = mappedStatement.getId();
		if (id.matches((".+ByPage$"))){
			BoundSql boundSql = statementHandler.getBoundSql();
			//原始SQL语句
			String sql = boundSql.getSql();
			
			//--------------查询总条数的SQL语句----------------------//
			String countSql = "SELECT count(*) FROM (" + sql +")";
			//从拦截的参数中获取连接(这里只拦截了一个参数Connection，故可以从中获取连接)
			Connection conn = (Connection)invocation.getArgs()[0];
			PreparedStatement countStatement = conn.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.paprameter");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();
			
			//获取分页配置参数
			Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
			Page page = (Page)parameter.get("page");
			if(rs.next()) {
				page.setRecordNum(rs.getInt(1));
			}
			
			//改造原始SQL语句
			String pageSql = sql + " limit " + page.getLimitStart() + "," + page.getPageSize();
			//替换原始SQL语句
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		/**
		 * 利用反射，调用被拦截住的方法--instantiateStatement(Connection connection)---在PreparedStatementHandler
		 */
		return invocation.proceed();
	}
	/**
	 * 参数target被拦截的对象
	 */
	@Override
	public Object plugin(Object target) {
		/**
		 * Plugin.wrap(target, interceptor)
		 * target为被拦截对象,interceptor为拦截器即代理对象
		 */
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}
	
}
