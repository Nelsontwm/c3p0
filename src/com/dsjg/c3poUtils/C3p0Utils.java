package com.dsjg.c3poUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	//��������
	//�õ�����
	//(��ʵ���Ǵ���c3p0���ӳض���
	private static DataSource dataSource = new ComboPooledDataSource();
	//������Դ�еõ�һ�����Ӷ���
		public static Connection getConnection(){
			try {
				//ͨ�����c3p0������ӳض���,�õ��������������
				return dataSource.getConnection();
			} catch (Exception e) {
				//�������ʾ����,�����е�ʱ������׳��쳣
				throw new RuntimeException("����������");
			}
		}
		
		
		
		public static void release(Connection conn,PreparedStatement pstm,ResultSet rs){
			//�ر���Դ
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
							conn.close();//�ر�
						} catch (Exception e) {
							e.printStackTrace();
						}
						conn = null;
					}
		}
}
