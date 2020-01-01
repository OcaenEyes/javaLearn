package com.gzy.page.service;

import com.gzy.page.dao.YouoneInfoDao;
import com.gzy.page.dao.YouoneInfoDaoImpl;
import com.gzy.page.model.YouoneInfo;
import com.gzy.page.model.YouoneInfoPage;

public class YouoneInfoServiceImpl implements YouoneInfoService{
    private YouoneInfoDao youoneInfoDao;

    public YouoneInfoDao getYouoneInfoDao() {
        return youoneInfoDao;
    }

    public void setYouoneInfoDao(YouoneInfoDao youoneInfoDao) {
        this.youoneInfoDao = youoneInfoDao;
    }

    public YouoneInfoServiceImpl(){
        //创建Service 实现类时 初始化dao对象
        youoneInfoDao = new YouoneInfoDaoImpl();
    }

    @Override
    public YouoneInfoPage<YouoneInfo> findInfo(YouoneInfo searchModel, int pageNum, int pageSize) {
        YouoneInfoPage<YouoneInfo> result = youoneInfoDao.findInfo(searchModel,pageNum,pageSize);
        return result;
    }
}
