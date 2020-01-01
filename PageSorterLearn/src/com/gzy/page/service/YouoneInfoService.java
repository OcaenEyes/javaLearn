package com.gzy.page.service;

import com.gzy.page.model.YouoneInfo;
import com.gzy.page.model.YouoneInfoPage;

public interface YouoneInfoService {

    /**
     * 根据查询条件，查询分页信息
     *
     * @param pageNum     查询第几页数据
     * @param pageSize    每页显示多少记录
     * @return 查询结果
     */
    public YouoneInfoPage<YouoneInfo> findInfo( int pageNum, int pageSize);
}
