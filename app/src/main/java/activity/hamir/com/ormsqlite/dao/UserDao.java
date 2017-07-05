package activity.hamir.com.ormsqlite.dao;

import android.content.Context;

import java.sql.SQLException;

import activity.hamir.com.ormsqlite.bean.MyBean;
import activity.hamir.com.ormsqlite.hepler.DatabaseHelper;

/**
 * Created by Administrator on 2017/6/26.
 */

public class UserDao {
    private Context context;

    public UserDao(Context context) {
        this.context = context;
    }

    public void add(MyBean user) {
        try {
            DatabaseHelper.getHelper(context).getUserDao().create(user);
        } catch (SQLException e) {
        }
    }
}
