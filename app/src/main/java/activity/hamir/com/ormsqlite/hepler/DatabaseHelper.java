package activity.hamir.com.ormsqlite.hepler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

import activity.hamir.com.ormsqlite.bean.MyBean;

/**
 * Created by Administrator on 2017/6/26.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    /*1、onCreate(SQLiteDatabase database,ConnectionSource connectionSource)
    创建表，我们直接使用ormlite提供的TableUtils.createTable(connectionSource, User.class);进行创建~
    2、onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
    更新表，使用ormlite提供的TableUtils.dropTable(connectionSource, User.class, true);进行删除操作~
    删除完成后，别忘了，创建操作：onCreate(database, connectionSource);*/
    private static final String TABLE_NAME = "sqlite-test.db";
    /**
     * userDao ，每张表对于一个
     */
    private Dao<MyBean, Integer> userDao;

    private DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MyBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, MyBean.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DatabaseHelper instance;

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        }
        return instance;
    }

    /**
     * 获得userDao
     *
     * @return
     * @throws SQLException
     */
    public Dao<MyBean, Integer> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(MyBean.class);
        }
        return userDao;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        userDao = null;
    }
}
