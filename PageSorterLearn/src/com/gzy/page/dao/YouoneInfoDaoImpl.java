package com.gzy.page.dao;

import com.gzy.page.model.YouoneInfo;
import com.gzy.page.model.YouoneInfoPage;
import com.gzy.page.util.YouoneInfoJdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YouoneInfoDaoImpl implements YouoneInfoDao {

    /**
     * @param searchModel 查询条件
     * @param pageNum     查询第几页数据
     * @param pageSize    每页显示多少记录
     * @return
     */
    @Override
    public YouoneInfoPage<YouoneInfo> findInfo(YouoneInfo searchModel, int pageNum, int pageSize) {
        List<YouoneInfo> allInfoList = getAllInfo(searchModel);
        YouoneInfoPage<YouoneInfo> page = new YouoneInfoPage<YouoneInfo>(pageNum, pageSize, allInfoList);
        return page;
    }

    /**
     * @param searchModel
     * @return 返回全部数据
     */
    private List<YouoneInfo> getAllInfo(YouoneInfo searchModel) {
        List<YouoneInfo> result = new ArrayList<YouoneInfo>();
        List<Object> paramList = new ArrayList<Object>();
        String textNum = searchModel.getTextNum();
        StringBuilder sql = new StringBuilder("select * from youone");
        if(textNum != null && !textNum.equals("")){
            sql.append("where textNum like ?");
            paramList.add("%" + textNum + "%");
        }

        YouoneInfoJdbcUtil youoneInfoJdbcUtil = null;
        try {
            youoneInfoJdbcUtil = new YouoneInfoJdbcUtil();
            youoneInfoJdbcUtil.getConnection();//获取数据库连接
            List<Map<String, Object>> mapList = youoneInfoJdbcUtil.selectResult(sql.toString(), paramList);
            System.out.println("查询到全部原始数据");
            if (mapList != null) {
                for (Map<String, Object> map : mapList) {
                    YouoneInfo youone = new YouoneInfo(map);
                    result.add(youone);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常", e);
        } finally {
            if (youoneInfoJdbcUtil != null) {
                youoneInfoJdbcUtil.releaseConn(); //释放资源操作
            }
        }
        return result;
    }
}
