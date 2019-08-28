package zty.practise.spring.base;

import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class ZTYSqlHelper extends SqlHelper {

	public static String insertIntoMysqlTable(Class<?> entityClass, String defaultTableName) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT IGNORE INTO ");
        sql.append(getDynamicTableName(entityClass, defaultTableName));
        sql.append(" ");
        return sql.toString();
    }
}

