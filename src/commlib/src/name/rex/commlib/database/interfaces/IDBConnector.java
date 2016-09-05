package name.rex.commlib.database.interfaces;

import java.sql.Connection;
import java.util.List;
import name.rex.commlib.database.DBPage;
import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBGeneratedKeyResult;

public interface IDBConnector {
	
	/**
     * 获取持久化连接 
     */
    public IDBConnector getPersistInstance() throws DBException;
    /**
     * 释放持久化连接
     */
    public void releasePersistInstance() throws DBException;

    /* 关闭数据库连接 */
	public void close();
	
	/**
	 * 查询，返回指定classType的查询结果集（请保持sql中列明同classType对应类型的属性名一致）。
	 *      对于关联查询的子结果集，对应classType中的对象属性值（eg: User user,User中的name在sql中写成user.name）
	 * 
	 * @param sql
	 * @param classType
	 * @param page
	 * @return
	 * @throws DBException
	 */
	public <T> List<T> query( String sql, Class<T> classType, DBPage page ) throws DBException;	
	
	/**
	 * 增、删、改sql语句，支持批量sql执行
	 * 
	 * @param sql
	 * @return int 执行该sql影响的数据记录条数
	 */
	public int execute( String sql ) throws DBException;	

    /**
	 * 增、删、改sql语句，支持批量sql执行
	 * 
	 * @param sql
	 * @return int 执行该sql影响的数据记录条数
	 */
	public int execute( String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException;

	/**
	 * 开启事务
	 */
	public void beginTransaction() throws DBException;	
		
	/**
	 * 事务提交
	 */
	public void commit() throws DBException;	
	
	/**
	 * 事务回滚
	 * @return  false：回滚失败；true：回滚成功
	 */
	public boolean rollback() throws DBException;
	
	/**
	 * 设置“事务”隔离级别
	 * @param level
	 *      0: 不使用事务;
	 *      1: 可以读取未提交数据;
	 *      2: 可以避免脏读，不能够读取没提交的数据(默认);
	 *      4: 可以避免脏读，不可以重复读取;
	 *      8: 可以避免脏读，不可重复读取和幻读，（事务串行化）会降低数据库效率;
	 *      
	 *      脏读（Dirty Reads） 一个事务读取了另一个并行事务还未提交的数据。
	 *      不可重复读（UnRepeatable Read） 一个事务再次读取之前的数据时，得到的数据不一致，被另一个已提交的事务修改。
	 *      幻读（Phantom Read） 一个事务重新执行一个查询，返回的记录中包含了因为其它最近提交的事务而产生的新记录。
	 */
	public void setTranIsolation(int level) throws DBException;
	
	/* 0: 不使用事务; */
	public static final int TRANSACTION_NONE = Connection.TRANSACTION_NONE;
	/* 0: 不使用事务; */
	public static final int TRANSACTION_READ_UNCOMMITTED = Connection.TRANSACTION_READ_UNCOMMITTED;
	/* 2: 可以避免脏读，不能够读取没提交的数据(默认); */
	public static final int TRANSACTION_READ_COMMITTED = Connection.TRANSACTION_READ_COMMITTED;
	/* 4: 可以避免脏读，不可以重复读取; */
	public static final int TRANSACTION_REPEATABLE_READ = Connection.TRANSACTION_REPEATABLE_READ;
	/* 8: 可以避免脏读，不可重复读取和幻读，（事务串行化）会降低数据库效率; */
	public static final int TRANSACTION_SERIALIZABLE = Connection.TRANSACTION_SERIALIZABLE;
}
