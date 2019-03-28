package com.learning.Foo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class DefaultFooService implements FooService {
	
	public DataSourceTransactionManager dataSourceTransactionManager;
	
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		return dataSourceTransactionManager;
	}

	public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}

	@Override
	public Foo getFoo(String fooName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Foo getFoo(String fooName, String barName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void insertFoo(Foo foo) {
		Connection connection;
		try {
			connection = DataSourceUtils.getConnection(dataSourceTransactionManager.getDataSource());
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into employee values(3, 'rin')");
			throw new UnsupportedOperationException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateFoo(Foo foo) {
		throw new UnsupportedOperationException();
	}

}
