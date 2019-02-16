package com.mb2217.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mb2217.entity.Area;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.System_user;
import com.mb2217.exception.DAOException;


public class DbHelper {

	private static ThreadLocal<Connection> conns = new ThreadLocal<>();

	//封装链接数据
	public static Connection getConnection() {
		Connection conn = conns.get();
		if (conn == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection("jdbc:mysql:///moviedata?useUnicode=true&characterEncoding=UTF8", "root","");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException();
			}
			conns.set(conn);
		}
		return conn;
	}

	//关闭资源
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	//
	public static void executeSQL(String sql, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	public static <T> System_user getSystem_userSingle(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return (System_user) runner.query(getConnection(), sql, new BeanHandler<>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}
	public static <T> T getSingle(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return  runner.query(getConnection(), sql, new BeanHandler<>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	public static <T> List<T> getResults(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(getConnection(), sql, new BeanListHandler<>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	public static <T> T getScalar(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(getConnection(), sql, new ScalarHandler<T>(), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}
//	public static void main(String[] args) {
//		DbHelper d=new DbHelper();
//		Connection s=d.getConnection();
//		System.out.println(s);
//	}

}
