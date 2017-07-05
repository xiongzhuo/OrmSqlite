package activity.hamir.com.ormsqlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/6/26.
 */
@DatabaseTable(tableName = "tb_user")
public class MyBean {
    /*首先在User类上添加@DatabaseTable(tableName = "tb_user")，标明这是数据库中的一张表，标明为tb_user
    然后分别在属性上添加@DatabaseField(columnName = "name") ，columnName的值为该字段在数据中的列名
    @DatabaseField(generatedId = true) ，generatedId 表示id为主键且自动生成*/
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "desc")
    private String desc;

    public MyBean() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

