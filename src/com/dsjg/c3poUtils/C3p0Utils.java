package com.dsjg.c3poUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	//加载驱动
	//得到连接
	//(其实就是创建c3p0连接池对象
	private static DataSource dataSource = new ComboPooledDataSource();
	//从数据源中得到一个连接对象
		public static Connection getConnection(){
			try {
				//通过这个c3p0这个连接池对象,拿到池子里面的连接
				return dataSource.getConnection();
			} catch (Exception e) {
				//这个是提示错误,在运行的时候就是抛出异常
				throw new RuntimeException("服务器错误");
			}
		}
		
		
		
		public static void release(Connection conn,PreparedStatement pstm,ResultSet rs){
			//关闭资源
					if(rs!=null){
						try {
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						rs = null;
					}
					if(pstm!=null){
						try {
							pstm.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						pstm = null;
					}
					if(conn!=null){
						try {
							conn.close();//关闭
						} catch (Exception e) {
							e.printStackTrace();
						}
						conn = null;
					}
		}
}
